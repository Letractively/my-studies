/**
 * 
 */
package br.com.lawoffice.dominio;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Historico de uma {@link Conta} do {@link Cliente} ou {@link Colaborador} no escritório
 * 
 * @author robson
 *
 */
@Entity
@Table(name="HISTORICO_CONTA")
public class HistoricoConta implements EntityBase{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_TRANSACAO")
	private Date dataTransacao;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_TRANSACAO")
	private TipoTransacao tipoTransacao;
	
	
	@Column(name="VALOR_TRANSACAO", precision = 19 , scale = 2)
	private BigDecimal valorTransacao;

	
	@Column(name="SALDO_ANTERIOR", precision = 19 , scale = 2)
	private BigDecimal saloAnterior;	
	
	
	@ManyToOne
	@JoinColumn(name="CONTA_ID")
	private Conta conta;

	
	
	/**
	 * Construtor padrão. 
	 */
	public HistoricoConta() {
	}
	
	
	
	
	

	// TODO: java doc 
	public HistoricoConta(Date dataTransacao, 
			TipoTransacao tipoTransacao,
			BigDecimal valorTransacao, 
			BigDecimal saloAnterior, 
			Conta conta) {
		super();
		this.dataTransacao = dataTransacao;
		this.tipoTransacao = tipoTransacao;
		this.valorTransacao = valorTransacao;
		this.saloAnterior = saloAnterior;
		this.conta = conta;
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


	public BigDecimal getValorTransacao() {
		return valorTransacao;
	}


	public void setValorTransacao(BigDecimal valorTransacao) {
		this.valorTransacao = valorTransacao;
	}


	public BigDecimal getSaloAnterior() {
		return saloAnterior;
	}


	public void setSaloAnterior(BigDecimal saloAnterior) {
		this.saloAnterior = saloAnterior;
	}


	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
