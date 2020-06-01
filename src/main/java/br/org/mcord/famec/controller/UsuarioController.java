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

import br.org.mcord.famec.exception.BadRequestException;
import br.org.mcord.famec.exception.InternalServerErrorException;
import br.org.mcord.famec.exception.NotFoundException;
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
		return ResponseEntity.ok(usuarioService.create(usuario));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") int cdUsuario, @RequestBody Usuario usuario) {
		if(!usuarioRepository.findById(cdUsuario).isPresent())
			throw new NotFoundException("Usuário não encontrado");
		
		return ResponseEntity.ok(usuarioService.update(usuario));
	}
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("")
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		List<Usuario> usuarios = usuarioService.findAll();
		if(usuarios.isEmpty())
			throw new NotFoundException("Nenhum usuário encontrado");
		
		return ResponseEntity.ok(usuarios);
	}
	
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") int cdUsuario) {
		Optional<Usuario> usuario = usuarioRepository.findById(cdUsuario);
		
		if(!usuario.isPresent())
			throw new NotFoundException("Usuário não encontrado");
		
		return ResponseEntity.ok(usuario.get());
	}
	
}
