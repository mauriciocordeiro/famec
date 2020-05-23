package br.org.mcord.famec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.mcord.famec.model.Responsavel;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer> {
	List<Responsavel> findAllByCdFamilia(int cdFamilia);
}
