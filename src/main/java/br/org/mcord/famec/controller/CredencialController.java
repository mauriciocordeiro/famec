package br.org.mcord.famec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.mcord.famec.model.Credencial;
import br.org.mcord.famec.model.Usuario;
import br.org.mcord.famec.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Autenticação"})
@RestController
@RequestMapping("/v1")
public class CredencialController {
	
	@Autowired
	UsuarioService usuarioService;
		
	@ApiOperation(value = "Realiza a autenticação do usuário da API")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Autenticado."),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 401, message = "Falha na autenticação"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@ApiParam(value = "Dados de acesso") @RequestBody Credencial credencial) {
		return ResponseEntity.ok(usuarioService.auth(credencial));
	}
	

}
