package br.com.fiapbank.dominio.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * Representa um Conta Bancaria Simples
 * 
 * @author robson.oliveira
 * 
 * @see Cliente 
 *
 */
@Entity
@Table(name="CONTA")
public class Conta {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private Long id;
	
	
	@Column(name="DATA_DE_ABERTURA", nullable = false )
	private Date dataDeAbertura;
	
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="CLIENTE_ID")
	private Cliente cliente;
	
	
	@OneToMany(mappedBy="conta", cascade = CascadeType.ALL)
	private List<Credito> creditos;

	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="SEGURANCA_ID")
	private Seguranca seguranca;
	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDataDeAbertura() {
		return dataDeAbertura;
	}


	public void setDataDeAbertura(Date dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}

	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Credito> getCreditos() {
		return creditos;
	}


	public void setCreditos(List<Credito> creditos) {
		this.creditos = creditos;
	}


	public Seguranca getSeguranca() {
		return seguranca;
	}


	public void setSeguranca(Seguranca seguranca) {
		this.seguranca = seguranca;
	}
	
	
		
}
