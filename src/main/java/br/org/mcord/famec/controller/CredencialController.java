package br.org.mcord.famec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.mcord.famec.model.Credencial;
import br.org.mcord.famec.model.Usuario;
import br.org.mcord.famec.repository.UsuarioRepository;
import br.org.mcord.famec.security.Hash;
import br.org.mcord.famec.security.JWT;

@RestController
@RequestMapping("/api")
public class CredencialController {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Value("${br.org.mcord.famec.jwt.secret}")
	private String jwtSecret;
	
	@Value("${br.org.mcord.famec.jwt.exp}")
	private long jwtExp;
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Credencial credencial) {
		try {
			
			if(usuarioRepository.findAll().isEmpty()) {
				credencial = createUser();
			}
			
			List<Usuario> usuarios = usuarioRepository.findByNmLogin(credencial.getUsuario());
			if(usuarios.isEmpty())
				return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
			
			Usuario usuario = usuarios.get(0);
			
			if(!usuario.getNmSenha().equals(Hash.generateMD5(credencial.getSenha()))) 
				return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
			
			usuario.setNmSenha(null);
			usuario.setToken(JWT.generateToken(Integer.toString(usuario.getCdUsuario()), usuario.getNmLogin(), jwtSecret, jwtExp, usuario.getNmRole()));
			
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private Credencial createUser() throws Exception {
		Usuario user = usuarioRepository.save(new Usuario(0, "Administrator", "admin", "admin", null, 1, null, "ADMIN"));
		return new Credencial(user.getNmLogin(), user.getNmSenha());
	}

}
