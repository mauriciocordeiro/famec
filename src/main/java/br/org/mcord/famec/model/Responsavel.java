package br.org.mcord.famec.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "responsavel")
public class Responsavel implements Serializable {

	private static final long serialVersionUID = 3036282568630334669L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_responsavel")
	private int cdResponsavel;
	
	@Column(name = "cd_familia", insertable = false, updatable = false)
	private int cdFamilia;
	
	@Column(name = "nm_responsavel")
	private String nmResponsavel;
	
	@ApiModelProperty(allowableValues = "1, 2, 3, 4, 5", notes = "1: Mãe/Pai, 2: Avó/Avô, 3: Irmã/Irmão, 4: Tia/Tio, 5: Outros")
	@Column(name = "tp_parentesco")
	private int tpParentesco;
	
	@ApiModelProperty(allowableValues = "1, 2", notes = "1: Masculino, 2: Feminino")
	@Column(name = "tp_genero")
	private int tpGenero;
	
	@Column(name = "dt_nascimento")
	private LocalDate dtNascimento;
	
	@Column(name = "nm_naturalidade")
	private String nmNaturalidade;
	
	@ApiModelProperty(allowableValues = "1, 2, 3, 4, 5", notes = "1: Solteiro, 2: Casado, 3: Separado, 4: Divorciado, 5: Viúvo")
	@Column(name = "tp_estado_civil")
	private int tpEstadoCivil;
	
	@Column(name = "nr_telefone_1")
	private String nrTelefone1;
	
	@Column(name = "nr_telefone_2")
	private String nrTelefone2;
	
	@Column(name = "nnr_rg")
	private String nrRg;
	
	@Column(name = "nm_orgao_expedidor_rg")
	private String nmOrgaoExpedidorRg;
	
	@ApiModelProperty(allowableValues = "AC, AL, AM, AP, BA, CE, DF, ES, GO, MA, MG, MS, MT, PA, PB, PE, PI, PR, RJ, RN, RO, RR, RS, SC, SE, SP, TO")
	@Column(name = "sg_uf_rg")
	private String sgUfRg;
	
	@Column(name = "nr_cpf")
	private String nrCpf;
	
	@Column(name = "ds_escolaridade")
	private String dsEscolaridade;
	
	@ApiModelProperty(allowableValues = "0, 1", notes = "0: Não, 1: Sim")
	@Column(name = "lg_estudante")
	private int lgEstudante;
	
	@ApiModelProperty(allowableValues = "1, 2, 3, 4", notes = "1: Fundamental, 2: Médio, 3: Superior, 4: Outro")
	@Column(name = "tp_nivel_escolar")
	private int tpNivelEscolar;
	
	@ApiModelProperty(allowableValues = "1, 2, 3, 4", notes = "1: Matutino, 2: Vespertino, 3: Noturno, 4: Diurno")
	@Column(name = "tp_turno")
	private int tpTurno;
	
	@Column(name = "nm_ocupacao")
	private String nmOcupacao;
	
	@Column(name = "vl_renda_mensal")
	private Double vlRendaMensal;
	
	@Column(name = "nm_local_trabalho")
	private String nmLocalTrabalho;
	
	@Column(name = "nr_telefone_trabalho")
	private String nrTelefoneTrabalho;
	
	@OneToOne
	@JoinColumn(name = "cd_familia", nullable = false)
	private Familia familia;
	
	@OneToOne(mappedBy = "responsavel")
	private EnderecoResponsavel enderecoResponsavel;

	public Responsavel(){ }

	public Responsavel(int cdResponsavel,
			int cdFamilia,
			String nmResponsavel,
			int tpParentesco,
			int tpGenero,
			LocalDate dtNascimento,
			String nmNaturalidade,
			int tpEstadoCivil,
			String nrTelefone1,
			String nrTelefone2,
			String nrRg,
			String nmOrgaoExpedidorRg,
			String sgUfRg,
			String nrCpf,
			String dsEscolaridade,
			int lgEstudante,
			int tpNivelEscolar,
			int tpTurno,
			String nmOcupacao,
			Double vlRendaMensal,
			String nmLocalTrabalho,
			String nrTelefoneTrabalho){
		setCdResponsavel(cdResponsavel);
		setCdFamilia(cdFamilia);
		setNmResponsavel(nmResponsavel);
		setTpParentesco(tpParentesco);
		setTpGenero(tpGenero);
		setDtNascimento(dtNascimento);
		setNmNaturalidade(nmNaturalidade);
		setTpEstadoCivil(tpEstadoCivil);
		setNrTelefone1(nrTelefone1);
		setNrTelefone2(nrTelefone2);
		setNrRg(nrRg);
		setNmOrgaoExpedidorRg(nmOrgaoExpedidorRg);
		setSgUfRg(sgUfRg);
		setNrCpf(nrCpf);
		setDsEscolaridade(dsEscolaridade);
		setLgEstudante(lgEstudante);
		setTpNivelEscolar(tpNivelEscolar);
		setTpTurno(tpTurno);
		setNmOcupacao(nmOcupacao);
		setVlRendaMensal(vlRendaMensal);
		setNmLocalTrabalho(nmLocalTrabalho);
		setNrTelefoneTrabalho(nrTelefoneTrabalho);
	}
	public void setCdResponsavel(int cdResponsavel){
		this.cdResponsavel=cdResponsavel;
	}
	public int getCdResponsavel(){
		return this.cdResponsavel;
	}
	public void setCdFamilia(int cdFamilia){
		this.cdFamilia=cdFamilia;
	}
	public int getCdFamilia(){
		return this.cdFamilia;
	}
	public void setNmResponsavel(String nmResponsavel){
		this.nmResponsavel=nmResponsavel;
	}
	public String getNmResponsavel(){
		return this.nmResponsavel;
	}
	public void setTpParentesco(int tpParentesco){
		this.tpParentesco=tpParentesco;
	}
	public int getTpParentesco(){
		return this.tpParentesco;
	}
	public void setTpGenero(int tpGenero){
		this.tpGenero=tpGenero;
	}
	public int getTpGenero(){
		return this.tpGenero;
	}
	public void setDtNascimento(LocalDate dtNascimento){
		this.dtNascimento=dtNascimento;
	}
	public LocalDate getDtNascimento(){
		return this.dtNascimento;
	}
	public void setNmNaturalidade(String nmNaturalidade){
		this.nmNaturalidade=nmNaturalidade;
	}
	public String getNmNaturalidade(){
		return this.nmNaturalidade;
	}
	public void setTpEstadoCivil(int tpEstadoCivil){
		this.tpEstadoCivil=tpEstadoCivil;
	}
	public int getTpEstadoCivil(){
		return this.tpEstadoCivil;
	}
	public void setNrTelefone1(String nrTelefone1){
		this.nrTelefone1=nrTelefone1;
	}
	public String getNrTelefone1(){
		return this.nrTelefone1;
	}
	public void setNrTelefone2(String nrTelefone2){
		this.nrTelefone2=nrTelefone2;
	}
	public String getNrTelefone2(){
		return this.nrTelefone2;
	}
	public void setNrRg(String nrRg){
		this.nrRg=nrRg;
	}
	public String getNrRg(){
		return this.nrRg;
	}
	public void setNmOrgaoExpedidorRg(String nmOrgaoExpedidorRg){
		this.nmOrgaoExpedidorRg=nmOrgaoExpedidorRg;
	}
	public String getNmOrgaoExpedidorRg(){
		return this.nmOrgaoExpedidorRg;
	}
	public void setSgUfRg(String sgUfRg){
		this.sgUfRg=sgUfRg;
	}
	public String getSgUfRg(){
		return this.sgUfRg;
	}
	public void setNrCpf(String nrCpf){
		this.nrCpf=nrCpf;
	}
	public String getNrCpf(){
		return this.nrCpf;
	}
	public void setDsEscolaridade(String dsEscolaridade){
		this.dsEscolaridade=dsEscolaridade;
	}
	public String getDsEscolaridade(){
		return this.dsEscolaridade;
	}
	public void setLgEstudante(int lgEstudante){
		this.lgEstudante=lgEstudante;
	}
	public int getLgEstudante(){
		return this.lgEstudante;
	}
	public void setTpNivelEscolar(int tpNivelEscolar){
		this.tpNivelEscolar=tpNivelEscolar;
	}
	public int getTpNivelEscolar(){
		return this.tpNivelEscolar;
	}
	public void setTpTurno(int tpTurno){
		this.tpTurno=tpTurno;
	}
	public int getTpTurno(){
		return this.tpTurno;
	}
	public void setNmOcupacao(String nmOcupacao){
		this.nmOcupacao=nmOcupacao;
	}
	public String getNmOcupacao(){
		return this.nmOcupacao;
	}
	public void setVlRendaMensal(Double vlRendaMensal){
		this.vlRendaMensal=vlRendaMensal;
	}
	public Double getVlRendaMensal(){
		return this.vlRendaMensal;
	}
	public void setNmLocalTrabalho(String nmLocalTrabalho){
		this.nmLocalTrabalho=nmLocalTrabalho;
	}
	public String getNmLocalTrabalho(){
		return this.nmLocalTrabalho;
	}
	public void setNrTelefoneTrabalho(String nrTelefoneTrabalho){
		this.nrTelefoneTrabalho=nrTelefoneTrabalho;
	}
	public String getNrTelefoneTrabalho(){
		return this.nrTelefoneTrabalho;
	}

	@JsonIgnore
	public Familia getFamilia() {
		return familia;
	}

	@JsonIgnore
	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public EnderecoResponsavel getEnderecoResponsavel() {
		return enderecoResponsavel;
	}

	public void setEnderecoResponsavel(EnderecoResponsavel enderecoResponsavel) {
		this.enderecoResponsavel = enderecoResponsavel;
	}
	
	
}
