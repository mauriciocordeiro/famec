package br.org.mcord.famec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.mcord.famec.model.Familia;

public interface FamiliaRepository extends JpaRepository<Familia, Integer> {

}
