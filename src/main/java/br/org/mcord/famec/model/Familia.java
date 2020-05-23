package br.org.mcord.famec.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "familia")
public class Familia implements Serializable {

	private static final long serialVersionUID = -3127631617441485377L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_familia")
	private int cdFamilia;
	
	@Column(name = "cd_cadastro")
	private LocalDate dtCadastro;
	
	@Column(name = "cd_usuario_cadastro")
	private int cdUsuarioCadastro;
	
	@Column(name = "nr_prontuario")
	private String nrProntuario;
	
	@OneToMany(mappedBy = "familia", cascade = CascadeType.ALL)
	private Set<Aluno> alunos;

	@OneToMany(mappedBy = "familia", cascade = CascadeType.ALL)
	private Set<Habitacao> habitacao;

	@OneToOne(mappedBy = "familia", cascade = CascadeType.ALL)
	private Responsavel responsavel;
	
	@OneToMany(mappedBy = "familia", cascade = CascadeType.ALL)
	private Set<PerfilSocial> perfilSocial;

	public Familia(){ }

	public Familia(int cdFamilia,
			LocalDate dtCadastro,
			int cdUsuarioCadastro,
			String nrProntuario){
		setCdFamilia(cdFamilia);
		setDtCadastro(dtCadastro);
		setCdUsuarioCadastro(cdUsuarioCadastro);
		setNrProntuario(nrProntuario);
	}
	public void setCdFamilia(int cdFamilia){
		this.cdFamilia=cdFamilia;
	}
	public int getCdFamilia(){
		return this.cdFamilia;
	}
	public void setDtCadastro(LocalDate dtCadastro){
		this.dtCadastro=dtCadastro;
	}
	public LocalDate getDtCadastro(){
		return this.dtCadastro;
	}
	public void setCdUsuarioCadastro(int cdUsuarioCadastro){
		this.cdUsuarioCadastro=cdUsuarioCadastro;
	}
	public int getCdUsuarioCadastro(){
		return this.cdUsuarioCadastro;
	}
	public void setNrProntuario(String nrProntuario){
		this.nrProntuario=nrProntuario;
	}
	public String getNrProntuario(){
		return this.nrProntuario;
	}

}
