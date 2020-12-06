package br.org.mcord.famec.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.mcord.famec.model.Aluno;
import br.org.mcord.famec.model.EnderecoResponsavel;
import br.org.mcord.famec.model.Familia;
import br.org.mcord.famec.model.Habitacao;
import br.org.mcord.famec.model.PerfilSocial;
import br.org.mcord.famec.model.Responsavel;
import br.org.mcord.famec.repository.AlunoRepository;
import br.org.mcord.famec.repository.EnderecoResponsavelRepository;
import br.org.mcord.famec.repository.FamiliaRepository;
import br.org.mcord.famec.repository.HabitacaoRepository;
import br.org.mcord.famec.repository.PerfilSocialRepository;
import br.org.mcord.famec.repository.ResponsavelRepository;

@Service
public class FamiliaService {

	@Autowired
	FamiliaRepository familiaRepository;
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	HabitacaoRepository habitacaoRepository;
	
	@Autowired
	PerfilSocialRepository perfilSocialRepository;
	
	@Autowired
	ResponsavelRepository responsavelRepository;
	
	@Autowired
	EnderecoResponsavelRepository enderecoResponsavelRepository;
	
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
	
	public Familia save(Familia familia) {
		Set<Aluno> alunos = familia.getAlunos();
		familia.setAlunos(null);
		
		Habitacao habitacao = familia.getHabitacao();
		familia.setHabitacao(null);
		
		Responsavel responsavel = familia.getResponsavel();
		familia.setResponsavel(null);
		
		EnderecoResponsavel enderecoResponsavel = responsavel.getEnderecoResponsavel();
		responsavel.setEnderecoResponsavel(null);
		
		PerfilSocial perfilSocial = familia.getPerfilSocial();
		familia.setPerfilSocial(null);
		
		
		Familia _familia = familiaRepository.save(familia);
		
		if(alunos != null) {
			for (Aluno aluno : alunos) {				
				aluno.setFamilia(_familia);
				alunoRepository.save(aluno);
			}
			_familia.setAlunos(alunos);
		}
		
		if(habitacao != null) {
			habitacao.setFamilia(_familia);
			_familia.setHabitacao(habitacaoRepository.save(habitacao));
		}
		
		if(perfilSocial != null) {
			perfilSocial.setFamilia(_familia);
			_familia.setPerfilSocial(perfilSocialRepository.save(perfilSocial));
		}
		
		if(responsavel != null) {
			responsavel.setFamilia(_familia);
			_familia.setResponsavel(responsavelRepository.save(responsavel));
		}
		
		if(enderecoResponsavel != null) {
			enderecoResponsavel.setResponsavel(_familia.getResponsavel());
			enderecoResponsavelRepository.save(enderecoResponsavel);
		}
		
		return _familia;
	}
}
