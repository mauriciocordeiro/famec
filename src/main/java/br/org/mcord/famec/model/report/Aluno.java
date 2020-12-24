package br.org.mcord.famec.model.report;

public class Aluno {
	
	private String nmAluno;
	private String nrProntuario;
	private String dsDtNascimento;
	private String nrIdade;
	private String nmTpSexo;
	private String nrTelefone;
	private String nmTpTurnoFamec;
	private String nmEscola;
	private String dsAcompanhante;
	private String dsHrSaida;
	private String nmUsuario;
	private String nmLgAlmocoInstituicao;
	private String nmResponsavel;
	private String dsEndereco;
		
	public Aluno() {
		super();
	}
	
	public Aluno(String nmAluno, String nrProntuario, String dsDtNascimento, String nrIdade, String nmTpSexo,
			String nrTelefone, String nmTpTurnoFamec, String nmEscola, String dsAcompanhante, String dsHrSaida,
			String nmUsuario, String nmLgAlmocoInstituicao, String nmResponsavel, String dsEndereco) {
		super();
		this.nmAluno = nmAluno;
		this.nrProntuario = nrProntuario;
		this.dsDtNascimento = dsDtNascimento;
		this.nrIdade = nrIdade;
		this.nmTpSexo = nmTpSexo;
		this.nrTelefone = nrTelefone;
		this.nmTpTurnoFamec = nmTpTurnoFamec;
		this.nmEscola = nmEscola;
		this.dsAcompanhante = dsAcompanhante;
		this.dsHrSaida = dsHrSaida;
		this.nmUsuario = nmUsuario;
		this.nmLgAlmocoInstituicao = nmLgAlmocoInstituicao;
		this.nmResponsavel = nmResponsavel;
		this.dsEndereco = dsEndereco;
	}
	public String getNmAluno() {
		return nmAluno;
	}
	public void setNmAluno(String nmAluno) {
		this.nmAluno = nmAluno;
	}
	public String getNrProntuario() {
		return nrProntuario;
	}
	public void setNrProntuario(String nrProntuario) {
		this.nrProntuario = nrProntuario;
	}
	public String getDsDtNascimento() {
		return dsDtNascimento;
	}
	public void setDsDtNascimento(String dsDtNascimento) {
		this.dsDtNascimento = dsDtNascimento;
	}
	public String getNrIdade() {
		return nrIdade;
	}
	public void setNrIdade(String nrIdade) {
		this.nrIdade = nrIdade;
	}
	public String getNmTpSexo() {
		return nmTpSexo;
	}
	public void setNmTpSexo(String nmTpSexo) {
		this.nmTpSexo = nmTpSexo;
	}
	public String getNrTelefone() {
		return nrTelefone;
	}
	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}
	public String getNmTpTurnoFamec() {
		return nmTpTurnoFamec;
	}
	public void setNmTpTurnoFamec(String nmTpTurnoFamec) {
		this.nmTpTurnoFamec = nmTpTurnoFamec;
	}
	public String getNmEscola() {
		return nmEscola;
	}
	public void setNmEscola(String nmEscola) {
		this.nmEscola = nmEscola;
	}
	public String getDsAcompanhante() {
		return dsAcompanhante;
	}
	public void setDsAcompanhante(String dsAcompanhante) {
		this.dsAcompanhante = dsAcompanhante;
	}
	public String getDsHrSaida() {
		return dsHrSaida;
	}
	public void setDsHrSaida(String dsHrSaida) {
		this.dsHrSaida = dsHrSaida;
	}
	public String getNmUsuario() {
		return nmUsuario;
	}
	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}
	public String getNmLgAlmocoInstituicao() {
		return nmLgAlmocoInstituicao;
	}
	public void setNmLgAlmocoInstituicao(String nmLgAlmocoInstituicao) {
		this.nmLgAlmocoInstituicao = nmLgAlmocoInstituicao;
	}
	public String getNmResponsavel() {
		return nmResponsavel;
	}
	public void setNmResponsavel(String nmResponsavel) {
		this.nmResponsavel = nmResponsavel;
	}
	public String getDsEndereco() {
		return dsEndereco;
	}
	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}
	
}
