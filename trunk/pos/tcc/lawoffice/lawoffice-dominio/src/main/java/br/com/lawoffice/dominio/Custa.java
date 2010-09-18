package br.com.lawoffice.dominio;

import java.math.BigDecimal;

/**
 * @author robson
 *
 */
public class Custa {

	//TODO: debito tecnico com bigdecimal , usar ou não ?
	private BigDecimal valor;
	
	private String natureza;

	private Lancamento lancamento;

	public Custa(){}

	
	public Custa addLancamento(Lancamento lancamento) {
		setLancamento(lancamento);
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// gets e set ...

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}


	public Lancamento getLancamento() {
		return lancamento;
	}


	public void setLancamento(Lancamento lacamento) {
		this.lancamento = lacamento;
	}

}
