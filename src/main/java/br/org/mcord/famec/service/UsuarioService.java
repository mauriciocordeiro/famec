package br.org.mcord.famec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.mcord.famec.model.Usuario;
import br.org.mcord.famec.repository.UsuarioRepository;
import br.org.mcord.famec.security.Hash;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		usuarios.forEach(usuario -> {
			usuario.setNmSenha(null);
		});
		
		return usuarios;
	}
	
	public Optional<Usuario> findById(int cdUsuario) {
		Optional<Usuario> usuario = usuarioRepository.findById(cdUsuario);
		
		if(usuario.isPresent())
			usuario.get().setNmSenha(null);
		
		return usuario;
	}
	
	public Usuario create(Usuario usuario) {
		usuario.setNmSenha(Hash.generateMD5(usuario.getNmSenha()));
		
		Usuario created = usuarioRepository.save(usuario);
		created.setNmSenha(null);
		
		return created;
	}
	
	public Usuario update(Usuario usuario) {
		if(usuario.getNmSenha() == null) {
			usuario.setNmSenha(usuarioRepository.getOne(usuario.getCdUsuario()).getNmSenha());
		} else {
			usuario.setNmSenha(Hash.generateMD5(usuario.getNmSenha()));
		}
		
		Usuario updated = usuarioRepository.save(usuario);
		updated.setNmSenha(null);
		
		return updated;
	}

}
