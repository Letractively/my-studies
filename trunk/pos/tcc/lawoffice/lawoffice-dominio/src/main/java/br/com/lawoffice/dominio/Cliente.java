/**
 * 
 */
package br.com.lawoffice.dominio;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * Representa um cliente do escritório
 * 
 * @author robson
 *
 */
@Entity
@Table(name="CLIENTE")
public class Cliente extends Pessoa{

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
	private List<Lancamento> lancamentos;
	
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name="CONTA_ID")
	private Conta conta;


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
