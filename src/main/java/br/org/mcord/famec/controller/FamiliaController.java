package br.org.mcord.famec.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.mcord.famec.exception.BadRequestException;
import br.org.mcord.famec.exception.NotFoundException;
import br.org.mcord.famec.exception.NotImplementedException;
import br.org.mcord.famec.model.Familia;
import br.org.mcord.famec.repository.FamiliaRepository;
import br.org.mcord.famec.service.FamiliaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.sf.jasperreports.engine.JRException;

@Api(tags = {"Famílias"})
@RestController
@RequestMapping("/v1/familias")
public class FamiliaController {
	
	@Autowired
	FamiliaRepository familiaRepository;

	@Autowired
	FamiliaService familiaService;
	
	@ApiOperation(value = "Recupera lista de famílias")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista gerada"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 403, message = "Usuário não autenticado"),
			@ApiResponse(code = 404, message = "Nenhum resultado encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("")
	public ResponseEntity<List<Familia>> getAllFamilias(
			@RequestParam(name = "aluno", required = false) String nmAluno,
			@RequestParam(name = "responsavel", required = false) String nmResponsavel,
			@RequestParam(name = "prontuario", required = false) String nrProntuario) {
		
		List<Familia> familias = familiaService.find(nmAluno, nmResponsavel, nrProntuario);
		
		if(familias.isEmpty())
			throw new NotFoundException("Nenhum resultado");
		
		return ResponseEntity.ok(familias);
	}
	
	@ApiOperation(value = "Recupera família com base no id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Registro encontrado"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 403, message = "Usuário não autenticado"),
			@ApiResponse(code = 404, message = "Nenhum resultado encontrado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<Familia> getFamiliaById(@PathVariable("id") int cdFamilia) {
		Optional<Familia> familia = familiaRepository.findById(cdFamilia);
		if(!familia.isPresent())
			throw new NotFoundException("Família não encontrada");
		
		return ResponseEntity.ok(familia.get());	
	}
	
	@ApiOperation(value = "Registra uma nova família")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Registrado"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 403, message = "Usuário não autenticado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@PostMapping("")
	public ResponseEntity<Familia> createFamilia(@RequestBody Familia familia) {
		Familia _familia = familiaService.save(familia);
		return ResponseEntity.ok(_familia);
	}
	
	@ApiOperation(value = "Edita o registro de uma família")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Editado"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 403, message = "Usuário não autenticado"),
			@ApiResponse(code = 500, message = "Erro no servidor")
	})
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<Familia> updateFamilia(@PathVariable("id") int cdFamilia, @RequestBody Familia familia) {
		Optional<Familia> familiaData = familiaRepository.findById(cdFamilia);
		if(!familiaData.isPresent())
			throw new BadRequestException("Família não encontrada");
		
		Familia _familia = familiaService.save(familia);
		
		return ResponseEntity.ok(_familia);
	}
	
	@ApiOperation(value = "Apaga o registro de uma família")
	@ApiResponses(value = {
			@ApiResponse(code = 501, message = "Recurso não implementado")
	})
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteFamiliaById(@PathVariable("id") int cdFamilia) {
		throw new NotImplementedException("Recurso não implementado");
	}
	
	@ApiOperation(value = "Apaga o registro de famílias")
	@ApiResponses(value = {
			@ApiResponse(code = 501, message = "Recurso não implementado")
	})
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("")
	public ResponseEntity<HttpStatus> deleteAllFamilia() {
		throw new NotImplementedException("Recurso não implementado");
	}

	// TODO:
	@ApiOperation(value = "Gera comprovante de matrícula dos alunos da familia")
	@ApiResponses(value = {
			@ApiResponse(code = 501, message = "Recurso não implementado")
	})
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("/{id}/matriculas")
	public ResponseEntity<byte[]> getMatriculaReport(@PathVariable("id") int cdFamilia) {
		throw new NotImplementedException("Recurso não implementado");
	}
	
	// TODO:
	@ApiOperation(value = "Gera comprovante de matrícula dos alunos da familia")
	@ApiResponses(value = {
			@ApiResponse(code = 501, message = "Recurso não implementado")
	})
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@GetMapping("/report")
	public ResponseEntity<byte[]> getAlunoReport(
			@RequestParam(name = "aluno", required = false) String nmAluno,
			@RequestParam(name = "responsavel", required = false) String nmResponsavel,
			@RequestParam(name = "prontuario", required = false) String nrProntuario) throws JRException, IOException {
		
		byte[] report = familiaService.getReport(null, null, null);
		
		return ResponseEntity.ok(report);
	}

}
