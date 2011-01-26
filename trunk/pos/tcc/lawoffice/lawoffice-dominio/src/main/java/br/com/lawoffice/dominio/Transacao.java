/**
 * 
 */
package br.com.lawoffice.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representa uma transação de uma {@link Conta} do {@link Cliente} ou {@link Colaborador} no escritório
 * 
 * @author robson
 *
 */
@Entity
@Table(name="TRANSACAO")
public class Transacao{

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_TRANSACAO")
	private Date dataTransacao;
	
	
	@Enumerated(EnumType.STRING)
	private TipoTransacao tipoTransacao;

	
	@ManyToOne
	@JoinColumn(name="CONTA_ID")
	private Conta conta;

	
	public Transacao() {
	}


	public Transacao(Date dataTransacao, TipoTransacao tipoTransacao) {
		super();
		this.dataTransacao = dataTransacao;
		this.tipoTransacao = tipoTransacao;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDataTransacao() {
		return dataTransacao;
	}


	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}


	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}


	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}


	public Conta getConta() {
		return conta;
	}


	public void setConta(Conta conta) {
		this.conta = conta;
	}
		
}
