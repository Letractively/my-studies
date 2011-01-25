/**
 * 
 */
package br.com.lawoffice.web.mb.caixa;

import javax.faces.bean.ManagedBean;

/**
 * 
 * Manager Bean para página de /caixa/credito.xhtml
 * 
 * @author rduarte
 *
 *
 */

@ManagedBean
public class CreditoMB extends CaixaTransacaoMB{

	public void creditarCliente(){
		caixaLocal.creditar(cliente.getConta(), valor);
	}
		
	public void creditarColaborador(){
		caixaLocal.creditar(colaborador.getConta(), valor);
	}
	
}
