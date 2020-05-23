package br.org.mcord.famec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.org.mcord.famec.model.Familia;

public interface FamiliaRepository extends JpaRepository<Familia, Integer> {
	
	List<Familia> findByNrProntuarioContaining(String nrProntuario);
	
	List<Familia> findByAlunosNmAlunoContaining(String nmAluno);
	List<Familia> findByResponsavelNmResponsavelContaining(String nmResponsavel);
	List<Familia> findByAlunosNmAlunoContainingAndResponsavelNmResponsavelContaining(String nmAluno, String nmResponsavel);
	
	@Query(value = "SELECT * "
			+ " FROM familia A "
			+ " JOIN responsavel B ON (A.cd_familia = B.cd_familia)"
			+ " JOIN aluno C ON (A.cd_familia = C.cd_familia) "
			+ " WHERE (A.nr_prontuario iLIKE '%:keyword%'"
			+ " OR B.nm_responsavel iLIKE '%:keyword%'"
			+ " OR C.nm_aluno iLIKE '%:keyword%')",
			nativeQuery = true)
	List<Familia> findByKeyword(@Param("keyword") String keyword);

}
