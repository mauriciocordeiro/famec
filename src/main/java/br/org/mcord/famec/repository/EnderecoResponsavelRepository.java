package br.org.mcord.famec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.mcord.famec.model.EnderecoResponsavel;

public interface EnderecoResponsavelRepository extends JpaRepository<EnderecoResponsavel, Integer> {
	List<EnderecoResponsavel> findAllByCdResponsavel(int cdResponsavel);
}
