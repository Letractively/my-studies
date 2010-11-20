/**
 * 
 */
package br.com.lawoffice.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * Representa uma pessoa que trabalha no escritório.
 * 
 * @author robson
 *
 */
@Entity
@Table(name="COLABORADOR")
public class Colaborador{
	
	// TODO; Long ou long
	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@Column(name="NOME")
	private String nome;

	
	@OneToMany(mappedBy="colaborador")
	private List<Lancamento> lancamentos;

	@Transient
	// TODO: veja no cliente
	private Conta conta;
	
	
	public Colaborador(){
		
	}
	

	public Colaborador(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}


	public Conta getConta() {
		return conta;
	}


	public void setConta(Conta conta) {
		this.conta = conta;
	}
	

}
