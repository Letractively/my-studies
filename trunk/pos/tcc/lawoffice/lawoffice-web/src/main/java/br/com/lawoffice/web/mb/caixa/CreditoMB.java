/**
 * 
 */
package br.com.lawoffice.web.mb.caixa;

import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.lawoffice.caixa.CaixaLocal;
import br.com.lawoffice.caixa.exception.CaixaException;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.web.mb.AutoCompleteMB;

/**
 * 
 * Manager Bean para página de /caixa/credito.xhtml
 * 
 * @author rduarte
 *
 *
 */

@ManagedBean
public class CreditoMB extends AutoCompleteMB{

	
	/**
	 * Valor para creditar na {@link Conta} do {@link Cliente} ou do {@link Colaborador}
	 */
	protected BigDecimal valor;
	
	
	/**
	 * Serviço de caixa para realizar o credito
	 */
	@EJB
	protected CaixaLocal caixaLocal;
	
	
	
	public void creditarCliente(){
		try {
			
			if(cliente == null){
				adicionarMensagemErro(
						null, 
						"Existe Campos ..: ",  
						"Selecione um cliente"  
					);
			}			
			else if( valor.doubleValue() <= 0 ){
				adicionarMensagemErro(
						null, 
						"slsls: ",  
						"Saldo Atual =  "  
					);
			}else{
			
				caixaLocal.creditar(cliente.getConta(), valor);
				
				
				// TODO: internacionalização
				adicionarMensagemInformacao(
						null, 
						"Crédito realizado com sucesso: ",  
						"Saldo Atual =  "  + NumberFormat.getCurrencyInstance().format(cliente.getConta().getSaldo())
					);				
			}
						
						
		} catch (CaixaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void creditarColaborador(){
		try {
			
			if(cliente == null){
				adicionarMensagemErro(
						null, 
						"Existe Campos ..: ",  
						"Selecione um cliente"  
					);
			}			
			else if( valor.doubleValue() <= 0 ){
				adicionarMensagemErro(
						null, 
						"slsls: ",  
						"Saldo Atual =  "  
					);
			}else{
			
				caixaLocal.creditar(colaborador.getConta(), valor);
				
				
				// TODO: internacionalização
				adicionarMensagemInformacao(
						null, 
						"Crédito realizado com sucesso: ",  
						"Saldo Atual =  "  + NumberFormat.getCurrencyInstance().format(colaborador.getConta().getSaldo())
					);				
			}			
			
			
			
		} catch (CaixaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	// >>>> GETS E SETS do MB <<<<
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}	
}
