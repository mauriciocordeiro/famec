package br.org.mcord.famec.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.mcord.famec.model.Familia;
import br.org.mcord.famec.repository.FamiliaRepository;
import br.org.mcord.famec.service.FamiliaService;

@RestController
@RequestMapping("/api/familias")
public class FamiliaController {
	
	@Autowired
	FamiliaRepository familiaRepository;

	@Autowired
	FamiliaService familiaService;
	
	@GetMapping("")
	public ResponseEntity<List<Familia>> getAllFamilias(
			@RequestParam(name = "aluno", required = false) String nmAluno,
			@RequestParam(name = "responsavel", required = false) String nmResponsavel,
			@RequestParam(name = "prontuario", required = false) String nrProntuario,
			@RequestParam(name = "palavra-chave", required = false) String keyword) {
		try {
			
			List<Familia> familias = new ArrayList<Familia>();
						
			if(keyword == null)
				familias = familiaService.find(nmAluno, nmResponsavel, nrProntuario);
			else 
				familias = familiaRepository.findByKeyword(keyword);
						
			if(familias.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(familias, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Familia> getFamiliaById(@PathVariable("id") int cdFamilia) {
		try {
			
			Optional<Familia> familia = familiaRepository.findById(cdFamilia);
			if(!familia.isPresent())
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			return new ResponseEntity<>(familia.get(), HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PostMapping("")
	public ResponseEntity<Familia> createFamilia(@RequestBody Familia familia) {
		try {
			
			Familia _familia = familiaService.save(familia);
			
			return new ResponseEntity<>(_familia, HttpStatus.CREATED);			
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Familia> updateFamilia(@PathVariable("id") int cdFamilia, @RequestBody Familia familia) {
		try {
			
			Optional<Familia> familiaData = familiaRepository.findById(cdFamilia);
			
			if(!familiaData.isPresent())
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			Familia _familia = familiaService.save(familia);
			
			return new ResponseEntity<>(_familia, HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteFamiliaById(@PathVariable("id") int cdFamilia) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
	
	@DeleteMapping("")
	public ResponseEntity<HttpStatus> deleteAllFamilia() {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}


}
