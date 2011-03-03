/**
 * 
 */
package br.com.lawoffice.web.mb.caixa;

import java.math.BigDecimal;

import javax.ejb.EJB;

import br.com.lawoffice.caixa.CaixaLocal;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.web.mb.AutoCompleteMB;
import br.com.lawoffice.web.mb.custa.ExtratoMB;

/**
 * Manager Bean Base para os Manage Beans do módulo de caixa
 * 
 * @author robson
 *
 * @see {@link CreditoMB} {@link DebitoMB} {@link ExtratoMB}
 *
 */
public class CaixaMB extends AutoCompleteMB {

	/**
	 * Valor para creditar na {@link Conta} do {@link Cliente} ou do {@link Colaborador}
	 */
	protected BigDecimal valor;
	
	
	/**
	 * Serviço de caixa para realizar o credito
	 */
	@EJB
	protected CaixaLocal caixaLocal;


	
	protected boolean validarDados(){
		
	}
	
	
	
	// >>>> GETS E SETS do MB <<<<	
	public BigDecimal getValor(){
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
