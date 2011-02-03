/**
 * 
 */
package br.com.lawoffice.web.mb.caixa;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.lawoffice.caixa.CaixaLocal;
import br.com.lawoffice.caixa.exception.CaixaException;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Conta;

/**
 * 
 * Manager Bean para página de /caixa/debito.xhtml
 * 
 * @author rduarte
 *
 *
 */

@ManagedBean
public class DebitoMB extends CaixaBaseMB{
	
	
	/**
	 * Valor para debitar na {@link Conta} do {@link Cliente} ou do {@link Colaborador}
	 */
	protected BigDecimal valor;
	
	
	/**
	 * Serviço de caixa para realizar o debito
	 */
	@EJB
	protected CaixaLocal caixaLocal;
	
	
	public void debitarCliente(){
		try {
			caixaLocal.debitar(cliente.getConta(), valor);
		} catch (CaixaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void debitarColaborador(){
		try {
			caixaLocal.debitar(colaborador.getConta(), valor);
		} catch (CaixaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	// >>>> GETS e SETS do MB <<< 
	
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
