package br.org.mcord.famec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.mcord.famec.model.Habitacao;

public interface HabitacaoRepository extends JpaRepository<Habitacao, Integer> {
	List<Habitacao> findAllByCdFamilia(int cdFamilia);
}
