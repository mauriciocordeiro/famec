package br.org.mcord.famec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
			
			System.out.println(keyword);
			
			if(keyword == null)
				familias = familiaService.find(nmAluno, nmResponsavel, nrProntuario);
			else 
				familias = familiaRepository.findByKeyword(keyword);
			
			System.out.println(familiaRepository.findByKeyword(keyword));
						
			if(familias.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
			return new ResponseEntity<>(familias, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

}
