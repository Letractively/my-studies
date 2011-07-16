/**
 * 
 */
package br.com.lawoffice.dominio;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Representa uma conta do {@link Cliente} ou {@link Colaborador} no escritório
 * 
 * @author robson
 *
 */

@Entity
@Table(name="CONTA")
public class Conta implements EntityBase{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="SALDO")
	private BigDecimal saldo;
	
	@OneToMany(mappedBy="conta", cascade = CascadeType.ALL)
	private List<HistoricoConta> historicos;
	
	@OneToOne(mappedBy="conta")
	private Cliente cliente;
	
	@OneToOne(mappedBy="conta")
	private Colaborador	colaborador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public List<HistoricoConta> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<HistoricoConta> historicos) {
		this.historicos = historicos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

}