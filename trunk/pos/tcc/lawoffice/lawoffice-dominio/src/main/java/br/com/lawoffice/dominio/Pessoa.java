package br.com.lawoffice.dominio;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * Classe base para entidades que se são pessoas no sistema
 * 
 * @author robson
 * 
 * @see  {@link Colaborador} {@link Cliente}
 *
 */
@MappedSuperclass
public class Pessoa implements EntityBase{

	@Id
	@GeneratedValue
	@Column(name = "ID")	
	private Long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "EMAIL")
	private String email;
	

	public Pessoa() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
}