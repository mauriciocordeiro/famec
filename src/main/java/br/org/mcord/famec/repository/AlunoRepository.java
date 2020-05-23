package br.org.mcord.famec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.mcord.famec.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
	
	List<Aluno> findAllByCdFamilia(int cdFamilia);


}
