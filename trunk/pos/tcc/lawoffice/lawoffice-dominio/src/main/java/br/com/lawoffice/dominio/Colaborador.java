/**
 * 
 */
package br.com.lawoffice.dominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * Representa uma pessoa que trabalha no escritório.
 * 
 * @author robson
 *
 */
@Entity
@Table(name="COLABORADOR")
public class Colaborador extends Pessoa{
		
	@Column(name="CARGO")
	private String cargo;
	
	@OneToMany(mappedBy="colaborador")
	private List<Lancamento> lancamentos;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CONTA_ID")
	private Conta conta;

	@OneToOne(mappedBy="colaborador")
	private Agenda agenda;
	

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}	
}
