package br.org.mcord.famec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.mcord.famec.model.Usuario;
import br.org.mcord.famec.repository.UsuarioRepository;
import br.org.mcord.famec.service.UsuarioService;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioService usuarioService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		try {
			return new ResponseEntity<>(usuarioService.create(usuario), HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") int cdUsuario, @RequestBody Usuario usuario) {
		try {
			if(!usuarioRepository.findById(cdUsuario).isPresent())
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			return new ResponseEntity<>(usuarioService.update(usuario), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("")
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		try {
			List<Usuario> usuarios = usuarioService.findAll();
			if(usuarios.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(usuarios, HttpStatus.OK);			
		} catch (IllegalArgumentException e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") int cdUsuario) {
		try {
			Optional<Usuario> usuario = usuarioRepository.findById(cdUsuario);
			
			if(!usuario.isPresent())
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			return new ResponseEntity<>(usuario.get(), HttpStatus.OK);			
		} catch (IllegalArgumentException e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
}
