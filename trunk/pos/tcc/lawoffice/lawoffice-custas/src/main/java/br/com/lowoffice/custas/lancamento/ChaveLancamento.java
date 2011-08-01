/**
 * 
 */
package br.com.lowoffice.custas.lancamento;

import java.util.Date;

import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;

/**
 * @author rduarte
 *
 */
class ChaveLancamento {

	private Cliente cliente;
	
	private Colaborador colaborador;
	
	private Date date;

	public ChaveLancamento(Cliente cliente, Colaborador colaborador, Date date) {		
		if( cliente == null 
				|| colaborador == null 
				|| date == null);			
		this.cliente = cliente;
		this.colaborador = colaborador;
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result
				+ ((colaborador == null) ? 0 : colaborador.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChaveLancamento other = (ChaveLancamento) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (colaborador == null) {
			if (other.colaborador != null)
				return false;
		} else if (!colaborador.equals(other.colaborador))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "ChaveLancamento [cliente=" + cliente + ", colaborador="
				+ colaborador + ", date=" + date + "]";
	}
	
}
