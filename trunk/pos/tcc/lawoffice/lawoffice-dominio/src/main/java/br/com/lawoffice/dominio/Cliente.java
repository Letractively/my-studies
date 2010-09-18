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

	private String nome;
	
	private List<Lancamento> lancamentos;
	
	
	// TODO: temp para validação do primeiro sprint ... falta definição de regras ..
	public Cliente(String nomeCliente) {
		setNome(nomeCliente);
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
