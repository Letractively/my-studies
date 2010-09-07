package br.com.fiapfuncionarios.dominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author robson
 *
 */
@Entity
@Table(name="FUNCIONARIO")
public class Funcionario {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name="NOME", nullable = false)
	private String nome;
	
	@Column(name="EMAIL", nullable = false)
	private String email;
	
	
	@Column(name="LOGIN", unique = true, nullable = false)
	private String login;
	
	@Column(name="SENHA",  nullable = false)
	private String senha;	
	
	
	@Column(name="CARGO", nullable = false)
	private String cargo;
	
	
	@OneToMany(mappedBy="funcionario", cascade = CascadeType.ALL)
	private List<HistoricoDeAcesso> historicoDeAcessos;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<HistoricoDeAcesso> getHistoricoDeAcessos() {
		return historicoDeAcessos;
	}


	public void setHistoricoDeAcessos(List<HistoricoDeAcesso> historicoDeAcessos) {
		this.historicoDeAcessos = historicoDeAcessos;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
