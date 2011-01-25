/**
 * 
 */
package br.com.lawoffice.web.mb.caixa;

import javax.faces.bean.ManagedBean;

/**
 * 
 * Manager Bean para página de /caixa/debito.xhtml
 * 
 * @author rduarte
 *
 *
 */

@ManagedBean
public class DebitoMB extends CaixaTransacaoMB{

	public void debitarCliente(){
		caixaLocal.debitar(cliente.getConta(), valor);
	}
	
	public void debitarColaborador(){
		caixaLocal.debitar(colaborador.getConta(), valor);
	}

}
