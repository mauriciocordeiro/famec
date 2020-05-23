package br.org.mcord.famec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.mcord.famec.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
