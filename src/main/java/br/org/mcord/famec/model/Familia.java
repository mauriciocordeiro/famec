package br.org.mcord.famec.model;

import java.util.GregorianCalendar;

public class Familia {

	private int cdFamilia;
	private GregorianCalendar dtCadastro;
	private int cdUsuarioCadastro;
	private String nrProntuario;

	public Familia(){ }

	public Familia(int cdFamilia,
			GregorianCalendar dtCadastro,
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
	public void setDtCadastro(GregorianCalendar dtCadastro){
		this.dtCadastro=dtCadastro;
	}
	public GregorianCalendar getDtCadastro(){
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
	

	public Object clone() {
		return new Familia(getCdFamilia(),
			getDtCadastro()==null ? null : (GregorianCalendar)getDtCadastro().clone(),
			getCdUsuarioCadastro(),
			getNrProntuario());
	}

}
