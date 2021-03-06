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
@Table(name = "perfil_social")
public class PerfilSocial implements Serializable {

	private static final long serialVersionUID = -4855389770132367275L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_perfil_social")
	private int cdPerfilSocial;
	
	@Column(name = "cd_familia", insertable = false, updatable = false)
	private int cdFamilia;
	
	@ApiModelProperty(allowableValues = "0, 1", notes = "0: Não, 1: Sim")
	@Column(name = "lg_nis")
	private int lgNis;
	
	@Column(name = "nr_nis")
	private String nrNis;
	
	@ApiModelProperty(allowableValues = "0, 1", notes = "0: Não, 1: Sim")
	@Column(name = "lg_beneficio")
	private int lgBeneficio;
	
	@Column(name = "nm_beneficio")
	private String nmBeneficio;
	
	@Column(name = "vl_beneficio")
	private Double vlBeneficio;
	
	@OneToOne
	@JoinColumn(name = "cd_familia", nullable = false)
	private Familia familia;

	public PerfilSocial(){ }

	public PerfilSocial(int cdPerfilSocial,
			int cdFamilia,
			int lgNis,
			String nrNis,
			int lgBeneficio,
			String nmBeneficio,
			Double vlBeneficio){
		setCdPerfilSocial(cdPerfilSocial);
		setCdFamilia(cdFamilia);
		setLgNis(lgNis);
		setNrNis(nrNis);
		setLgBeneficio(lgBeneficio);
		setNmBeneficio(nmBeneficio);
		setVlBeneficio(vlBeneficio);
	}
	public void setCdPerfilSocial(int cdPerfilSocial){
		this.cdPerfilSocial=cdPerfilSocial;
	}
	public int getCdPerfilSocial(){
		return this.cdPerfilSocial;
	}
	public void setCdFamilia(int cdFamilia){
		this.cdFamilia=cdFamilia;
	}
	public int getCdFamilia(){
		return this.cdFamilia;
	}
	public void setLgNis(int lgNis){
		this.lgNis=lgNis;
	}
	public int getLgNis(){
		return this.lgNis;
	}
	public void setNrNis(String nrNis){
		this.nrNis=nrNis;
	}
	public String getNrNis(){
		return this.nrNis;
	}
	public void setLgBeneficio(int lgBeneficio){
		this.lgBeneficio=lgBeneficio;
	}
	public int getLgBeneficio(){
		return this.lgBeneficio;
	}
	public void setNmBeneficio(String nmBeneficio){
		this.nmBeneficio=nmBeneficio;
	}
	public String getNmBeneficio(){
		return this.nmBeneficio;
	}
	public void setVlBeneficio(Double vlBeneficio){
		this.vlBeneficio=vlBeneficio;
	}
	public Double getVlBeneficio(){
		return this.vlBeneficio;
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
