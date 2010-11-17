/**
 * 
 */
package br.com.lawoffice.dominio;

import java.util.List;

/**
 * 
 * Representa uma pessoa que trabalha no escritório.
 * 
 * @author robson
 *
 */
public class Colaborador{
	
	// TODO; Long ou long
	private long id;
	
	private String nome;

	private List<Lancamento> lancamentos;

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
