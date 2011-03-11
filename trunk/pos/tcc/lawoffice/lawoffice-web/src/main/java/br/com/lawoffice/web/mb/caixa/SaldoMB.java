/**
 * 
 */
package br.com.lawoffice.web.mb.caixa;

import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.lawoffice.caixa.CaixaLocal;
import br.com.lawoffice.caixa.exception.CaixaException;
import br.com.lawoffice.web.mb.AutoCompleteMB;

/**
 * 
 * Manager Bean para página de /caixa/saldo.xhtml
 * 
 * @author rduarte
 *
 *
 */

@ManagedBean
public class SaldoMB extends AutoCompleteMB{

	
	/**
	 * Serviço de caixa para realizar o credito
	 */
	@EJB
	protected CaixaLocal caixaLocal;
	
	
	
	public void consultarSaldoCliente(){
		try {
			adicionarMensagemSaldo(
				caixaLocal.getSaldo(cliente.getConta())
			);						
		} catch (CaixaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void consultarSaldoColaborador(){
		try {
			adicionarMensagemSaldo(
				caixaLocal.getSaldo(colaborador.getConta())
			);						
		} catch (CaixaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void adicionarMensagemSaldo(BigDecimal saldo) {
		// TODO: internacionalização
		adicionarMensagemInformacao(
				null, 
				"Consulta realizada com sucesso: ",  
				"Saldo Atual =  "  + NumberFormat.getCurrencyInstance().format(saldo)
			);		
	}

}
