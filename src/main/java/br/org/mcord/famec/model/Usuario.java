package br.org.mcord.famec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = -6458272529453856524L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_usuario")
	private int cdUsuario;
	
	@Column(name = "nm_usuario")
	private String nmUsuario;
	
	@Column(name = "nm_login", unique = true)
	private String nmLogin;
	
	@Column(name = "nm_senha")
	private String nmSenha;
	
	@Column(name = "nm_email")
	private String nmEmail;
	
	@Column(name = "st_usuario")
	private int stUsuario;
	
	@Column(name = "nm_funcao")
	private String nmFuncao;
	
	@Column(name = "nm_role")
	private String nmRole;
	
	private String token;

	public Usuario(){ }

	public Usuario(int cdUsuario,
			String nmUsuario,
			String nmLogin,
			String nmSenha,
			String nmEmail,
			int stUsuario,
			String nmFuncao,
			String nmRole){
		setCdUsuario(cdUsuario);
		setNmUsuario(nmUsuario);
		setNmLogin(nmLogin);
		setNmSenha(nmSenha);
		setNmEmail(nmEmail);
		setStUsuario(stUsuario);
		setNmFuncao(nmFuncao);
		setNmRole(nmRole);
	}
	public void setCdUsuario(int cdUsuario){
		this.cdUsuario=cdUsuario;
	}
	public int getCdUsuario(){
		return this.cdUsuario;
	}
	public void setNmUsuario(String nmUsuario){
		this.nmUsuario=nmUsuario;
	}
	public String getNmUsuario(){
		return this.nmUsuario;
	}
	public void setNmLogin(String nmLogin){
		this.nmLogin=nmLogin;
	}
	public String getNmLogin(){
		return this.nmLogin;
	}
	public void setNmSenha(String nmSenha){
		this.nmSenha=nmSenha;
	}
	public String getNmSenha(){
		return this.nmSenha;
	}
	public void setNmEmail(String nmEmail){
		this.nmEmail=nmEmail;
	}
	public String getNmEmail(){
		return this.nmEmail;
	}
	public void setStUsuario(int stUsuario){
		this.stUsuario=stUsuario;
	}
	public int getStUsuario(){
		return this.stUsuario;
	}
	public void setNmFuncao(String nmFuncao){
		this.nmFuncao=nmFuncao;
	}
	public String getNmFuncao(){
		return this.nmFuncao;
	}		
	public String getNmRole() {
		return this.nmRole;
	}
	public void setNmRole(String nmRole) {
		this.nmRole = nmRole;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
