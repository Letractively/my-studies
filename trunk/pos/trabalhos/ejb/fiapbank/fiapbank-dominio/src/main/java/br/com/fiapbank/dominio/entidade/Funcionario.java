/**
 * 
 */
package br.com.fiapbank.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author robson.oliveira
 *
 */
@MappedSuperclass
public class Funcionario {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="SENHA")
	private String senha;
	
	
	@Column(name="login")
	private String login;


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

}
