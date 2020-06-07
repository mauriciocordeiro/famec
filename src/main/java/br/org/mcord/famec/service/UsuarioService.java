package br.org.mcord.famec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.org.mcord.famec.exception.UnauthorizedException;
import br.org.mcord.famec.model.Credencial;
import br.org.mcord.famec.model.Usuario;
import br.org.mcord.famec.repository.UsuarioRepository;
import br.org.mcord.famec.security.Hash;
import br.org.mcord.famec.security.JWT;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	

	@Value("${br.org.mcord.famec.jwt.secret}")
	private String jwtSecret;
	
	@Value("${br.org.mcord.famec.jwt.exp}")
	private long jwtExp;
	
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
	
	public Usuario auth(Credencial credencial) {		
		List<Usuario> usuarios = usuarioRepository.findByNmLogin(credencial.getUsuario());
		if(usuarios.isEmpty())
			throw new UnauthorizedException("Usuário inválido");
		
		Usuario usuario = usuarios.get(0);
		
		if(!usuario.getNmSenha().equals(Hash.generateMD5(credencial.getSenha()))) 
			throw new UnauthorizedException("Senha inválida");
		
		if(usuario.getStUsuario() != 1)
			throw new UnauthorizedException("Usuário inativo");
		
		usuario.setNmSenha(null);
		usuario.setToken(JWT.generateToken(Integer.toString(usuario.getCdUsuario()), usuario.getNmLogin(), jwtSecret, jwtExp, usuario.getNmRole()));
		
		return usuario;
	}
	

	private Credencial createUser() {
		Usuario user = create(new Usuario(0, "Administrator", "admin", "admin", null, 1, null, "ADMIN"));
		return new Credencial(user.getNmLogin(), user.getNmSenha());
	}
	
	public boolean hasUser() {
		return !usuarioRepository.findAll().isEmpty();
	}

}
