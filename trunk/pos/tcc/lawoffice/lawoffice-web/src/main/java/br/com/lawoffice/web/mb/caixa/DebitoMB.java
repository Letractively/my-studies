/**
 * 
 */
package br.com.lawoffice.web.mb.caixa;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.lawoffice.caixa.CaixaServiceLocal;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.web.mb.AutoCompleteMB;

/**
 * 
 * Manager Bean para página de /caixa/debito.xhtml
 * 
 * @author rduarte
 *
 *
 */

@ManagedBean
public class DebitoMB extends AutoCompleteMB{
	
	
	/**
	 * Valor para debitar na {@link Conta} do {@link Cliente} ou do {@link Colaborador}
	 */
	protected BigDecimal valor;
	
	
	/**
	 * Serviço de caixa para realizar o debito
	 */
	@EJB
	protected CaixaServiceLocal caixaService;
	
	
	public void debitarCliente(){
		Conta conta = 
			caixaService.debitar(cliente.getConta(), valor, new Date());
		
		addMsgDebitoSucesso(conta);
	}
	
	
	public void debitarColaborador(){
		Conta conta = 
			caixaService.debitar(colaborador.getConta(), valor, new Date());
		
		addMsgDebitoSucesso(conta);
	}

	
	private void addMsgDebitoSucesso(Conta conta) {
		// TODO: internacionalização
		addMsgInformacao(
				null, 
				"Débito realizado com sucesso: ",  
				"Saldo Atual =  "  + NumberFormat.getCurrencyInstance().format(conta.getSaldo())
			);		
	}	
	
	
	// >>>> GETS e SETS do MB <<< 
		
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
