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

	@Column(name = "dt_cadastro")
	private LocalDate dtCadastro;

	@Column(name = "cd_usuario_cadastro")
	private int cdUsuarioCadastro;

	@Column(name = "nr_prontuario")
	private String nrProntuario;

	@OneToMany(mappedBy = "familia")
	private Set<Aluno> alunos;

	@OneToOne(mappedBy = "familia")
	private Habitacao habitacao;

	@OneToOne(mappedBy = "familia")
	private Responsavel responsavel;

	@OneToOne(mappedBy = "familia")
	private PerfilSocial perfilSocial;

	public Familia() {
	}

	public Familia(int cdFamilia, LocalDate dtCadastro, int cdUsuarioCadastro, String nrProntuario) {
		setCdFamilia(cdFamilia);
		setDtCadastro(dtCadastro);
		setCdUsuarioCadastro(cdUsuarioCadastro);
		setNrProntuario(nrProntuario);
	}

	public void setCdFamilia(int cdFamilia) {
		this.cdFamilia = cdFamilia;
	}

	public int getCdFamilia() {
		return this.cdFamilia;
	}

	public void setDtCadastro(LocalDate dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public LocalDate getDtCadastro() {
		return this.dtCadastro;
	}

	public void setCdUsuarioCadastro(int cdUsuarioCadastro) {
		this.cdUsuarioCadastro = cdUsuarioCadastro;
	}

	public int getCdUsuarioCadastro() {
		return this.cdUsuarioCadastro;
	}

	public void setNrProntuario(String nrProntuario) {
		this.nrProntuario = nrProntuario;
	}

	public String getNrProntuario() {
		return this.nrProntuario;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Habitacao getHabitacao() {
		return habitacao;
	}

	public void setHabitacao(Habitacao habitacao) {
		this.habitacao = habitacao;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public PerfilSocial getPerfilSocial() {
		return perfilSocial;
	}

	public void setPerfilSocial(PerfilSocial perfilSocial) {
		this.perfilSocial = perfilSocial;
	}

}
