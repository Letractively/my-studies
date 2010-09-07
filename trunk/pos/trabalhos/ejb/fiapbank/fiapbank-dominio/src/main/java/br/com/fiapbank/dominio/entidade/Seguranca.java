/**
 * 
 */
package br.com.fiapbank.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author robson
 *
 */
@Entity
@Table(name="SEGURANCA")
public class Seguranca {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private Long id;
	
	
	@Column(name="SENHA")
	private String senha;
	
	
	@Column(name="LOGIN")
	private String login;
	
	
	@Column(name="PERFIL")
	@Enumerated(EnumType.STRING)
	private Perfil perfil;

	
	@OneToOne(mappedBy="seguranca")
	private Conta conta;

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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}
