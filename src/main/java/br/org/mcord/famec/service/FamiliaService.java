package br.org.mcord.famec.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.mcord.famec.model.Familia;
import br.org.mcord.famec.repository.FamiliaRepository;

@Service
public class FamiliaService {

	@Autowired
	FamiliaRepository familiaRepository;
	
	public List<Familia> find(String nmAluno, String nmResponsavel, String nrProntuario) {
		if(nrProntuario != null) {
			return familiaRepository.findByNrProntuarioContaining(nrProntuario);
		} else {
			if(nmAluno == null && nmResponsavel == null) {
				return familiaRepository.findAll();
			} if(nmAluno != null && nmResponsavel == null) {
				return familiaRepository.findByAlunosNmAlunoContaining(nmAluno);
			} if(nmAluno == null && nmResponsavel != null) {
				return familiaRepository.findByResponsavelNmResponsavelContaining(nmResponsavel);
			} else {
				return familiaRepository.findByAlunosNmAlunoContainingAndResponsavelNmResponsavelContaining(nmAluno, nmResponsavel);
			}
		}
	}
	
	public List<Familia> find(String keyword) {
		//List<Familia> familias = new ArrayList<Familia>();
		
		return familiaRepository.findByKeyword(keyword);
	}
}
