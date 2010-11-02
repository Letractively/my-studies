/**
 * 
 */
package br.com.lawoffice.dominio;

import java.util.List;

/**
 * @author robson
 *
 */
public class Cliente{

	
	// TODO: long ou Long
	private long id;
	
	private String nome;
	
	private List<Lancamento> lancamentos;

	
	public Cliente() {
	}
	
	// TODO: construtor temporario
	public Cliente(long id, String nome) {
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
	
	
}
