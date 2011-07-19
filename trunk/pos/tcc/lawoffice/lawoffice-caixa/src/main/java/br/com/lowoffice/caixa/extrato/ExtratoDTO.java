package br.com.lowoffice.caixa.extrato;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.dominio.Pessoa;

/**
 * 
 * DTO para exibição e criação do Extrato de consulta. 
 * 
 * 
 * @author robson
 *
 */
public class ExtratoDTO {

	
	/**
	 * Nome da pessoa que o extrato será gerado.
	 */
	private String nomePessoa;
	
	/**
	 * Saldo anterior da data inicial da consulta; 
	 */
	private BigDecimal saldoAnterior;
	
	/**
	 * Saldo atual da {@link Conta} da {@link Pessoa}.
	 */
	private BigDecimal saldoAtual;
	
	/**
	 * Data inicial do periodo da consulta.
	 */
	private Date dataInicial;
	
	/**
	 * Data final do periodo da consulta;
	 */
	private Date dataFinal;
	
	/**
	 *  Itens do extrado. 
	 */
	private List<ExtroItem> extratoItens;

	
	public ExtratoDTO(String nomePessoa, BigDecimal saldoAnterior,
			BigDecimal saldoAtual, Date dataInicial, Date dataFinal) {
		super();
		this.nomePessoa = nomePessoa;
		this.saldoAnterior = saldoAnterior;
		this.saldoAtual = saldoAtual;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	
	public String getNomePessoa() {
		return nomePessoa;
	}

	public BigDecimal getSaldoAnterior() {
		return saldoAnterior;
	}

	public BigDecimal getSaldoAtual() {
		return saldoAtual;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public List<ExtroItem> getExtratoItens() {
		return extratoItens;
	}
}
