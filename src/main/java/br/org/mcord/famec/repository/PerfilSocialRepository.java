package br.org.mcord.famec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.mcord.famec.model.PerfilSocial;

public interface PerfilSocialRepository extends JpaRepository<PerfilSocial, Integer> {
	List<PerfilSocial> findAllByCdFamilia(int cdFamilia);
}
