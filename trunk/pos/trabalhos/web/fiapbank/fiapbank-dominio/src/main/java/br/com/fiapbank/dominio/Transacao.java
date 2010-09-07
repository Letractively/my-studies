/**
 * 
 */
package br.com.fiapbank.dominio;

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
 * @author robson
 *
 */

@Entity
@Table(name="TRANSACAO")
public class Transacao implements EntidadeBase{

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name="CONTA_ID", nullable = false)
	private Conta conta;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA")
	private Date data;
	
	
    @Column(name="VALOR")
	private Double valor;
    
    
    @Enumerated(EnumType.STRING)
    @Column(name="TIPO_DE_TRANSACAO")
    private TipoDeTransacao tipoDeTransacao;

    
    @Column(name="NUMERO_CONTA_DESTINO")
    private String numeroContaDestino;
    
    
    @Column(name="NUMERO_AGENCIA_DESTINO")
    private String numeroAgenciaDestino;
    
    
 
	public Transacao() {
	}


	public Transacao(Date data, Double valor, TipoDeTransacao tipoDeTransacao, Conta conta) {
		super();
		this.data = data;
		this.valor = valor;
		this.tipoDeTransacao = tipoDeTransacao;
		this.conta = conta;
	}


	


	public Transacao(Date data, Double valor, TipoDeTransacao tipoDeTransacao,
			String numeroContaDestino, String numeroAgenciaDestino,
			Conta conta) {
		super();
		this.data = data;
		this.valor = valor;
		this.tipoDeTransacao = tipoDeTransacao;
		this.numeroContaDestino = numeroContaDestino;
		this.numeroAgenciaDestino = numeroAgenciaDestino;
		this.conta = conta;
	}


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


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public TipoDeTransacao getTipoDeTransacao() {
		return tipoDeTransacao;
	}


	public void setTipoDeTransacao(TipoDeTransacao tipoDeTransacao) {
		this.tipoDeTransacao = tipoDeTransacao;
	}


	public String getNumeroContaDestino() {
		return numeroContaDestino;
	}


	public void setNumeroContaDestino(String numeroContaDestino) {
		this.numeroContaDestino = numeroContaDestino;
	}


	public String getNumeroAgenciaDestino() {
		return numeroAgenciaDestino;
	}


	public void setNumeroAgenciaDestino(String numeroAgenciaDestino) {
		this.numeroAgenciaDestino = numeroAgenciaDestino;
	}	
}
