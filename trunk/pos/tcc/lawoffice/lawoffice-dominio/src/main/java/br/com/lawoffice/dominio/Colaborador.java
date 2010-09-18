/**
 * 
 */
package br.com.lawoffice.dominio;

import java.util.List;

/**
 * @author robson
 *
 */
public class Colaborador{
	
	private String nome;

	private List<Lancamento> lancamentos;

	// idem ao cliente 
	public Colaborador(String nomeColaborador) {
		setNome(nomeColaborador);
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
