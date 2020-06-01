package br.org.mcord.famec.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1346701327167692819L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_aluno")
	private int cdAluno;
	
	@Column(name = "cd_familia", insertable = false, updatable = false)
	private int cdFamilia;
	
	@Column(name = "nm_aluno")
	private String nmAluno;
	
	@Column(name = "dt_nascimento")
	private LocalDate dtNascimento;
	
	@ApiModelProperty(allowableValues = "1, 2", notes = "1: Masculino, 2: Feminino")
	@Column(name = "tp_sexo")
	private int tpSexo;
	
	@Column(name = "nm_naturalidade")
	private String nmNaturalidade;
	
	@Column(name = "nm_escola")
	private String nmEscola;
	
	@Column(name = "nr_nivel_escolar")
	private int nrNivelEscolar;
	
	@ApiModelProperty(allowableValues = "1, 2, 3", notes = "1: Infantil, 2: Fundamental, 3: Médio")
	@Column(name = "tp_modalidade_escolar")
	private int tpModalidadeEscolar;
	
	@ApiModelProperty(allowableValues = "1, 2, 3, 4", notes = "1: Matutino, 2: Vespertino, 3: Noturno, 4: Diurno")
	@Column(name = "tp_horario_escolar")
	private int tpHorarioEscolar;
	
	@ApiModelProperty(allowableValues = "1, 2, 3, 4", notes = "1: Matutino, 2: Vespertino, 3: Noturno, 4: Diurno")
	@Column(name = "tp_turno_famec")
	private int tpTurnoFamec;
	
	@ApiModelProperty(allowableValues = "0, 1", notes = "0: Inativo, 1: Ativo")
	@Column(name = "st_aluno")
	private int stAluno;
	
	@Column(name = "hr_saida")
	private LocalDate hrSaida;
	
	@ApiModelProperty(allowableValues = "0, 1", notes = "0: Sozinho, 1: Acompanhado")
	@Column(name = "lg_acompanhante_saida")
	private int lgAcompanhanteSaida;
	
	@Column(name = "nm_acompanhante_saida")
	private String nmAcompanhanteSaida;
	
	@ApiModelProperty(allowableValues = "0, 1", notes = "0: NÂO almoça na FAMEC, 1: Almoça na FAMEC")
	@Column(name = "lg_almoco_instituicao")
	private int lgAlmocoInstituicao;
	
	@ManyToOne
	@JoinColumn(name = "cd_familia", nullable = false)
	private Familia familia;

	public Aluno(){ }

	public Aluno(int cdAluno,
			int cdFamilia,
			String nmAluno,
			LocalDate dtNascimento,
			int tpSexo,
			String nmNaturalidade,
			String nmEscola,
			int nrNivelEscolar,
			int tpModalidadeEscolar,
			int tpHorarioEscolar,
			int tpTurnoFamec,
			int stAluno,
			LocalDate hrSaida,
			int lgAcompanhanteSaida,
			String nmAcompanhanteSaida,
			int lgAlmocoInstituicao){
		setCdAluno(cdAluno);
		setCdFamilia(cdFamilia);
		setNmAluno(nmAluno);
		setDtNascimento(dtNascimento);
		setTpSexo(tpSexo);
		setNmNaturalidade(nmNaturalidade);
		setNmEscola(nmEscola);
		setNrNivelEscolar(nrNivelEscolar);
		setTpModalidadeEscolar(tpModalidadeEscolar);
		setTpHorarioEscolar(tpHorarioEscolar);
		setTpTurnoFamec(tpTurnoFamec);
		setStAluno(stAluno);
		setHrSaida(hrSaida);
		setLgAcompanhanteSaida(lgAcompanhanteSaida);
		setNmAcompanhanteSaida(nmAcompanhanteSaida);
		setLgAlmocoInstituicao(lgAlmocoInstituicao);
	}
	public void setCdAluno(int cdAluno){
		this.cdAluno=cdAluno;
	}
	public int getCdAluno(){
		return this.cdAluno;
	}
	public void setCdFamilia(int cdFamilia){
		this.cdFamilia=cdFamilia;
	}
	public int getCdFamilia(){
		return this.cdFamilia;
	}
	public void setNmAluno(String nmAluno){
		this.nmAluno=nmAluno;
	}
	public String getNmAluno(){
		return this.nmAluno;
	}
	public void setDtNascimento(LocalDate dtNascimento){
		this.dtNascimento=dtNascimento;
	}
	public LocalDate getDtNascimento(){
		return this.dtNascimento;
	}
	public void setTpSexo(int tpSexo){
		this.tpSexo=tpSexo;
	}
	public int getTpSexo(){
		return this.tpSexo;
	}
	public void setNmNaturalidade(String nmNaturalidade){
		this.nmNaturalidade=nmNaturalidade;
	}
	public String getNmNaturalidade(){
		return this.nmNaturalidade;
	}
	public void setNmEscola(String nmEscola){
		this.nmEscola=nmEscola;
	}
	public String getNmEscola(){
		return this.nmEscola;
	}
	public void setNrNivelEscolar(int nrNivelEscolar){
		this.nrNivelEscolar=nrNivelEscolar;
	}
	public int getNrNivelEscolar(){
		return this.nrNivelEscolar;
	}
	public void setTpModalidadeEscolar(int tpModalidadeEscolar){
		this.tpModalidadeEscolar=tpModalidadeEscolar;
	}
	public int getTpModalidadeEscolar(){
		return this.tpModalidadeEscolar;
	}
	public void setTpHorarioEscolar(int tpHorarioEscolar){
		this.tpHorarioEscolar=tpHorarioEscolar;
	}
	public int getTpHorarioEscolar(){
		return this.tpHorarioEscolar;
	}
	public void setTpTurnoFamec(int tpTurnoFamec){
		this.tpTurnoFamec=tpTurnoFamec;
	}
	public int getTpTurnoFamec(){
		return this.tpTurnoFamec;
	}
	public void setStAluno(int stAluno){
		this.stAluno=stAluno;
	}
	public int getStAluno(){
		return this.stAluno;
	}
	public void setHrSaida(LocalDate hrSaida){
		this.hrSaida=hrSaida;
	}
	public LocalDate getHrSaida(){
		return this.hrSaida;
	}
	public void setLgAcompanhanteSaida(int lgAcompanhanteSaida){
		this.lgAcompanhanteSaida=lgAcompanhanteSaida;
	}
	public int getLgAcompanhanteSaida(){
		return this.lgAcompanhanteSaida;
	}
	public void setNmAcompanhanteSaida(String nmAcompanhanteSaida){
		this.nmAcompanhanteSaida=nmAcompanhanteSaida;
	}
	public String getNmAcompanhanteSaida(){
		return this.nmAcompanhanteSaida;
	}
	public void setLgAlmocoInstituicao(int lgAlmocoInstituicao){
		this.lgAlmocoInstituicao=lgAlmocoInstituicao;
	}
	public int getLgAlmocoInstituicao(){
		return this.lgAlmocoInstituicao;
	}

	@JsonIgnore
	public Familia getFamilia() {
		return familia;
	}

	@JsonIgnore
	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

}