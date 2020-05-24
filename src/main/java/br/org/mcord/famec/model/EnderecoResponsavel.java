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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "endereco_responsavel")
public class EnderecoResponsavel implements Serializable {

	private static final long serialVersionUID = -7834929780420617486L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_endereco_responsavel")
	private int cdEnderecoResponsavel;
	
	@Column(name = "cd_responsavel", insertable = false, updatable = false)
	private int cdResponsavel;
	
	@Column(name = "nm_rua")
	private String nmRua;
	
	@Column(name = "nr_casa")
	private int nrCasa;
	
	@Column(name = "nm_complemento")
	private String nmComplemento;
	
	@Column(name = "nm_bairro")
	private String nmBairro;
	
	@Column(name = "nm_cidade")
	private String nmCidade;
	
	@Column(name = "nm_estado")
	private String nmEstado;
	
	@OneToOne
	@JoinColumn(name = "cd_responsavel", nullable = false)
	private Responsavel responsavel;

	public EnderecoResponsavel(){ }

	public EnderecoResponsavel(int cdEnderecoResponsavel,
			int cdResponsavel,
			String nmRua,
			int nrCasa,
			String nmComplemento,
			String nmBairro,
			String nmCidade,
			String nmEstado){
		setCdEnderecoResponsavel(cdEnderecoResponsavel);
		setCdResponsavel(cdResponsavel);
		setNmRua(nmRua);
		setNrCasa(nrCasa);
		setNmComplemento(nmComplemento);
		setNmBairro(nmBairro);
		setNmCidade(nmCidade);
		setNmEstado(nmEstado);
	}
	public void setCdEnderecoResponsavel(int cdEnderecoResponsavel){
		this.cdEnderecoResponsavel=cdEnderecoResponsavel;
	}
	public int getCdEnderecoResponsavel(){
		return this.cdEnderecoResponsavel;
	}
	public void setCdResponsavel(int cdResponsavel){
		this.cdResponsavel=cdResponsavel;
	}
	public int getCdResponsavel(){
		return this.cdResponsavel;
	}
	public void setNmRua(String nmRua){
		this.nmRua=nmRua;
	}
	public String getNmRua(){
		return this.nmRua;
	}
	public void setNrCasa(int nrCasa){
		this.nrCasa=nrCasa;
	}
	public int getNrCasa(){
		return this.nrCasa;
	}
	public void setNmComplemento(String nmComplemento){
		this.nmComplemento=nmComplemento;
	}
	public String getNmComplemento(){
		return this.nmComplemento;
	}
	public void setNmBairro(String nmBairro){
		this.nmBairro=nmBairro;
	}
	public String getNmBairro(){
		return this.nmBairro;
	}
	public void setNmCidade(String nmCidade){
		this.nmCidade=nmCidade;
	}
	public String getNmCidade(){
		return this.nmCidade;
	}
	public void setNmEstado(String nmEstado){
		this.nmEstado=nmEstado;
	}
	public String getNmEstado(){
		return this.nmEstado;
	}
	
	@JsonIgnore
	public Responsavel getResponsavel() {
		return responsavel;
	}

	@JsonIgnore
	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	

}
