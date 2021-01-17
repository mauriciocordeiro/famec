package br.org.mcord.famec.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "escola")
public class Escola implements Serializable {
	private static final long serialVersionUID = -5971223874317962642L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_escola")
	private int cdEscola;
	
	@Column(name = "nm_escola")
	private String nmEscola;
	
	@OneToMany(mappedBy = "escola")
	private Set<Aluno> alunos;

	public Escola(int cdEscola, String nmEscola) {
		super();
		this.cdEscola = cdEscola;
		this.nmEscola = nmEscola;
	}

	public Escola() {
		super();
	}

	public int getCdEscola() {
		return cdEscola;
	}

	public void setCdEscola(int cdEscola) {
		this.cdEscola = cdEscola;
	}

	public String getNmEscola() {
		return nmEscola;
	}

	public void setNmEscola(String nmEscola) {
		this.nmEscola = nmEscola;
	}

	
	
}
