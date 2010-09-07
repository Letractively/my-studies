/**
 * 
 */
package br.com.fiapbank.dominio.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Representa credito(s) comuns para um conta simples
 * 
 * @author robson.oliveira
 *
 *@see Conta
 */
@Entity
@Table(name="CREDITO")
public class Credito {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name="CONTA_ID")
	private Conta conta;
	
	@Column(name="VALOR_CREDITO")
	private BigDecimal valorCredito;
	
	@Column(name="QUANTIDADE_DE_MESES")
	private Integer quantidadeDeMeses;
	
	
	@Column(name="STATUS_CREDITO")
	@Enumerated(EnumType.STRING)
	private StatusCredito statusCredito ;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Conta getConta() {
		return conta;
	}


	public void setConta(Conta conta) {
		this.conta = conta;
	}


	public BigDecimal getValorCredito() {
		return valorCredito;
	}


	public void setValorCredito(BigDecimal valorCredito) {
		this.valorCredito = valorCredito;
	}


	public Integer getQuantidadeDeMeses() {
		return quantidadeDeMeses;
	}


	public void setQuantidadeDeMeses(Integer quantidadeDeMeses) {
		this.quantidadeDeMeses = quantidadeDeMeses;
	}


	public StatusCredito getStatusCredito() {
		return statusCredito;
	}


	public void setStatusCredito(StatusCredito statusCredito) {
		this.statusCredito = statusCredito;
	}
	
}
