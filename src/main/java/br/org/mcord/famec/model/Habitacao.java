package br.org.mcord.famec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "habitacao")
public class Habitacao implements Serializable {

	private static final long serialVersionUID = 6864144009300268711L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_habitacao")
	private int cdHabitacao;
	
	@Column(name = "cd_familia", insertable = false, updatable = false)
	private int cdFamilia;
	
	@ApiModelProperty(allowableValues = "1, 2, 3, 4, 5", notes = "1: Própria, 2: Alugada, 3: Cedida, 4: Invasão, 5: De favor")
	@Column(name = "tp_situacao")
	private int tpSituacao;
	
	@Column(name = "vl_aluguel")
	private Double vlAluguel;
	
	@Column(name = "nr_comodos")
	private int nrComodos;
	
	@ApiModelProperty(allowableValues = "1", notes = "1: Reda pública")
	@Column(name = "tp_abastecimento")
	private int tpAbastecimento;
	
	@ApiModelProperty(allowableValues = "1, 2, 3, 4", notes = "1: Filtração, 2: Fervura, 3: S/ tratamento, 4: Outros")
	@Column(name = "tp_tratamento_agua")
	private int tpTratamentoAgua;
	
	@ApiModelProperty(allowableValues = "1, 2, 3", notes = "1: Medidor próprio, 2: S/ medidor, 3: Outros")
	@Column(name = "tp_iluminacao")
	private int tpIluminacao;
	
	@ApiModelProperty(allowableValues = "1, 2, 3, 4", notes = "1: Coletado, 2: Fossa, 3: Céu aberto, 4: Outros")
	@Column(name = "tp_escoamento_sanitario")
	private int tpEscoamentoSanitario;
	
	@ApiModelProperty(allowableValues = "1, 2, 3, 4, 5", notes = "1: Coletado, 2: Queimado, 3: Enterrado, 4: Céu aberto, 5: Outros")
	@Column(name = "tp_destino_lixo")
	private int tpDestinoLixo;
	
	@OneToOne
	@JoinColumn(name = "cd_familia", nullable = true)
	private Familia familia;

	public Habitacao(){ }

	public Habitacao(int cdHabitacao,
			int cdFamilia,
			int tpSituacao,
			Double vlAluguel,
			int nrComodos,
			int tpAbastecimento,
			int tpTratamentoAgua,
			int tpIluminacao,
			int tpEscoamentoSanitario,
			int tpDestinoLixo){
		setCdHabitacao(cdHabitacao);
		setCdFamilia(cdFamilia);
		setTpSituacao(tpSituacao);
		setVlAluguel(vlAluguel);
		setNrComodos(nrComodos);
		setTpAbastecimento(tpAbastecimento);
		setTpTratamentoAgua(tpTratamentoAgua);
		setTpIluminacao(tpIluminacao);
		setTpEscoamentoSanitario(tpEscoamentoSanitario);
		setTpDestinoLixo(tpDestinoLixo);
	}
	public void setCdHabitacao(int cdHabitacao){
		this.cdHabitacao=cdHabitacao;
	}
	public int getCdHabitacao(){
		return this.cdHabitacao;
	}
	public void setCdFamilia(int cdFamilia){
		this.cdFamilia=cdFamilia;
	}
	public int getCdFamilia(){
		return this.cdFamilia;
	}
	public void setTpSituacao(int tpSituacao){
		this.tpSituacao=tpSituacao;
	}
	public int getTpSituacao(){
		return this.tpSituacao;
	}
	public void setVlAluguel(Double vlAluguel){
		this.vlAluguel=vlAluguel;
	}
	public Double getVlAluguel(){
		return this.vlAluguel;
	}
	public void setNrComodos(int nrComodos){
		this.nrComodos=nrComodos;
	}
	public int getNrComodos(){
		return this.nrComodos;
	}
	public void setTpAbastecimento(int tpAbastecimento){
		this.tpAbastecimento=tpAbastecimento;
	}
	public int getTpAbastecimento(){
		return this.tpAbastecimento;
	}
	public void setTpTratamentoAgua(int tpTratamentoAgua){
		this.tpTratamentoAgua=tpTratamentoAgua;
	}
	public int getTpTratamentoAgua(){
		return this.tpTratamentoAgua;
	}
	public void setTpIluminacao(int tpIluminacao){
		this.tpIluminacao=tpIluminacao;
	}
	public int getTpIluminacao(){
		return this.tpIluminacao;
	}
	public void setTpEscoamentoSanitario(int tpEscoamentoSanitario){
		this.tpEscoamentoSanitario=tpEscoamentoSanitario;
	}
	public int getTpEscoamentoSanitario(){
		return this.tpEscoamentoSanitario;
	}
	public void setTpDestinoLixo(int tpDestinoLixo){
		this.tpDestinoLixo=tpDestinoLixo;
	}
	public int getTpDestinoLixo(){
		return this.tpDestinoLixo;
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
