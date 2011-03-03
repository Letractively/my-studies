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
			if(cliente != null){
				caixaLocal.creditar(cliente.getConta(), valor);
				adicionarMensagemCreditoSucesso(cliente.getConta());
			}
				
		} catch (CaixaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void creditarColaborador(){
		try {			
			if(parametrosValidosCreditoColaborador()){
				caixaLocal.creditar(colaborador.getConta(), valor);
				adicionarMensagemCreditoSucesso(colaborador.getConta());
			}
		} catch (CaixaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private boolean parametrosValidosCreditoColaborador(){
		if(colaborador == null){
			adicionarMensagemErroValidacao(null, "O colaborador é obrigatório");
			return false;
		}											
		return validarValor();
	}


	private boolean parametrosValidosCreditoCliente() {
		if(cliente == null){
			adicionarMensagemErroValidacao(null, "O colaborador é obrigatório");
			return false;
		}							
		return validarValor();
	}	
	

	
	private boolean validarValor() {
		if( valor.doubleValue() <= 0 ){
			adicionarMensagemErroValidacao(null, "O valor do credito é obrigatório e deve ser maior que zero");
			return false;
		}			
		return true;
	}
	
	
	private void adicionarMensagemCreditoSucesso(Conta conta) {
		// TODO: internacionalização
		adicionarMensagemInformacao(
				null, 
				"Crédito realizado com sucesso: ",  
				"Saldo Atual =  "  + NumberFormat.getCurrencyInstance().format(conta.getSaldo())
			);		
	}

	

	// >>>> GETS E SETS do MB <<<<
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}	
}
