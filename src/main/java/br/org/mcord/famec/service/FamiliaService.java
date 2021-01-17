package br.org.mcord.famec.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.lowagie.text.pdf.PdfWriter;

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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

@Service
public class FamiliaService {
	
	@Autowired
	private ResourceLoader resourceLoader;

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
				System.out.println("findAll");
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
	
	public byte[] getReport(String nmAluno, String nmResponsavel, String nrProntuario) throws JRException, IOException {
		
		List<Familia> familias = find(nmAluno, nmResponsavel, nrProntuario);
		
		System.out.println(familias);
		
		List<br.org.mcord.famec.model.report.Aluno> reportDetail = new ArrayList<br.org.mcord.famec.model.report.Aluno>();
		for (Familia familia : familias) {	
			
			for (Aluno aluno : familia.getAlunos()) {
				
				br.org.mcord.famec.model.report.Aluno item = new br.org.mcord.famec.model.report.Aluno(
						aluno.getNmAluno(), 
						familia.getNrProntuario(), 
						"dd/mm/yyyy", //new SimpleDateFormat("dd/MM/yyyy").format(aluno.getDtNascimento()), 
						"10", 
						(aluno.getTpSexo()==1 ? "M" : "F"), 
						familia.getResponsavel().getNrTelefone1(), 
						"", //nmTpTurnoFamec, 
						"", //nmEscola, 
						"", //dsAcompanhante, 
						"", //dsHrSaida, 
						"", //nmUsuario, 
						"", //nmLgAlmocoInstituicao, 
						"", //nmResponsavel, 
						"" //dsEndereco
						);
				
				System.out.println(item);
				
				reportDetail.add(item);	
			}
		}		
		
		Resource resource = resourceLoader.getResource("classpath:reports/lista_aluno.jrxml");
		
		System.out.println(resource.getFile().getAbsolutePath());
		
		// Compile the Jasper report from .jrxml to .japser
		JasperReport jasperReport = JasperCompileManager.compileReport(resource.getFile().getAbsolutePath());

		// Get your data source
		JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(reportDetail);

		// Add parameters
		Map<String, Object> parameters = new HashMap<>();		
		parameters.put("dsHoje", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

		// Fill the report
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);

		// Export the report to a PDF file
		JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Emp-Rpt.pdf");

	
		return getPdfReport(jasperPrint);		
	}
	
	private byte[] getPdfReport(JasperPrint print) throws JRException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
    	
    	
    	JRPdfExporter exporter = new JRPdfExporter();
    	exporter.setExporterInput(new SimpleExporterInput(print));
    	exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
    	SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
    	configuration.setPermissions(PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_PRINTING);
    	exporter.setConfiguration(configuration);
    	exporter.exportReport();
		
		return out.toByteArray();
	}
}
