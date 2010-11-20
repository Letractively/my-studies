package br.com.lawoffice.dominio;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author robson
 *
 */
@Entity
@Table(name="CUSTA")
public class Custa {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	//TODO: debito tecnico com bigdecimal , usar ou não ?
	@Column(name="VALOR", precision = 19 , scale = 2)
	private BigDecimal valor;
	
	@Column(name="NATUREZA")
	private String natureza;

	
	@ManyToOne
	@JoinColumn(name="LANCAMENTO_ID")
	private Lancamento lancamento;
	
	
	
	// >>>>>>>>>> gets e set <<<<<<<<<<<<<<<<<

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
	
	
	// >>>>>>>> MÉTODOS DE DOMINIO <<<<<<<<<
	
	
	public Custa addLancamento(Lancamento lancamento) {
		setLancamento(lancamento);
		return this;
	}
	

}
