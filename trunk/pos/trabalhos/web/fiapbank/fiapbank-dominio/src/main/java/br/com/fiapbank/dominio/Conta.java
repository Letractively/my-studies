/**
 * 
 */
package br.com.fiapbank.dominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author robson.oliveira
 *
 *
 */
@Entity
@Table(name="CONTA")
public class Conta implements EntidadeBase{
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;


	@Column(name="NUMERO", nullable = false)
	private String numero;
	
	
	@Column(name="NUMERO_AGENCIA", nullable = false)
	private String numeroAgencia;
	

	@Column(name="SALDO")
	private Double saldo;
	

	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_DE_CONTA", nullable = false)
	private TipoDeConta TipoDeConta;
	
	
	@Column(name="SENHA", nullable = false)
	private String senha;
	
	
	@Column(name="FRASE_SECRETA", nullable = false)
	private String fraseSecreta;

	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "conta")
	private List<Transacao> transacoes;

	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getNumeroAgencia() {
		return numeroAgencia;
	}


	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public TipoDeConta getTipoDeConta() {
		return TipoDeConta;
	}


	public void setTipoDeConta(TipoDeConta tipoDeConta) {
		TipoDeConta = tipoDeConta;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getFraseSecreta() {
		return fraseSecreta;
	}


	public void setFraseSecreta(String fraseSecreta) {
		this.fraseSecreta = fraseSecreta;
	}


	public List<Transacao> getTransacoes() {
		return transacoes;
	}


	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}	
}
