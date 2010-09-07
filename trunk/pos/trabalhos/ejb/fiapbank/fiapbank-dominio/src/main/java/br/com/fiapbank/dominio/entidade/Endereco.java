/**
 * 
 */
package br.com.fiapbank.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Representa um endereco simples de um cliente
 * 
 * @author robson.oliveira
 * 
 * @see {@link Cliente}
 *
 */
@Entity
@Table(name="ENDERECO")
public class Endereco {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private Long id;
	


	@Column(name="LOGRADOURO", nullable = false)
	private String logradouro;
	

	
	@Column(name="NUMERO", nullable = false)
	private String numero;
	

	
	@Column(name="CEP", nullable = false)
	private String cep;
	


	@Column(name="BAIRRO", nullable = false)
	private String bairro;
	


	@Column(name="MUNICIPIO", nullable = false)
	private String municipio;
	


	@Column(name="ESTADO", nullable = false)
	private String estado;
	
	@OneToOne(mappedBy="endereco")
	private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
