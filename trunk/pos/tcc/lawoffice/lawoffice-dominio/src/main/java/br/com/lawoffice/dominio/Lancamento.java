/**
 * 
 */
package br.com.lawoffice.dominio;

import java.util.Date;
import java.util.List;

/**
 * @author robson
 *
 */
public class Lancamento {

	
	private Cliente cliente;
	
	
	private Colaborador colaborador;
	
	
	private Date dataLancamento;
	
	
	private List<Custa> custas;
	
	
	public Lancamento addCliente(Cliente cliente) {
		setCliente(cliente);
		return this;
	}


	public Lancamento addColaborador(Colaborador colaborador){
		setColaborador(colaborador);
		return this;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// gets e sets
	
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


	public Date getDataLancamento() {
		return dataLancamento;
	}


	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}


	public List<Custa> getCustas() {
		return custas;
	}


	public void setCustas(List<Custa> custas) {
		this.custas = custas;
	}
	
}
