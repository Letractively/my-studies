/**
 * 
 */
package br.com.fiapbank.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author robson.oliveira
 *
 */
@Entity
@Table(name="FUNCIONARIO")
public class Funcionario implements EntidadeBase{
		
	/**
	 * 
	 */
	@Id
	@GeneratedValue()
	@Column(name="ID")
	private Long id;
	
	/**
	 * 
	 */
	@Column(name="SENHA")
	private String senha;

	/**
	 * 
	 */
	@Column(name="LOGIN", unique = true)
	private String login;
	
	/**
	 * 
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="CARGO")
	private Cargo cargo;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
}
