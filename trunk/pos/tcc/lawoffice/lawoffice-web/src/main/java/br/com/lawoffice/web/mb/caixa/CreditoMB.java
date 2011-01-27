/**
 * 
 */
package br.com.lawoffice.web.mb.caixa;

import javax.faces.bean.ManagedBean;

import br.com.lawoffice.caixa.CaixaException;

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
		try {
			caixaLocal.creditar(cliente.getConta(), valor);
		} catch (CaixaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void creditarColaborador(){
		try {
			caixaLocal.creditar(colaborador.getConta(), valor);
		} catch (CaixaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
