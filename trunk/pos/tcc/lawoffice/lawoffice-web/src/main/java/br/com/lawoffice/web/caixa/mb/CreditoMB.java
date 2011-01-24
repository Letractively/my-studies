/**
 * 
 */
package br.com.lawoffice.web.caixa.mb;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.lawoffice.caixa.CaixaLocal;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.web.mb.BaseMB;

/**
 * 
 * Manager Bean para página de /caixa/credito.xhtml
 * 
 * @author rduarte
 *
 *
 */

@ManagedBean
public class CreditoMB extends BaseMB {

	
	
	/**
	 * Valor para debitar na {@link Conta} do {@link Cliente} ou do {@link Colaborador}
	 */
	private BigDecimal valor;
	
	
	/**
	 * Serviço de caixa
	 */
	@EJB
	private CaixaLocal caixaLocal;
	
	
	
	public void creditarCliente(){
		//caixaLocal.debitar(conta, quantidade);
	}
	
	
	public void creditarColaborador(){
		//caixaLocal.debitar(conta, quantidade);
	}	
	
}
