/**
 * 
 */
package br.com.fiapbank.mb.conta;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.fiapbank.contas.GerenciadorDeContasException;
import br.com.fiapbank.contas.GerenciadorDeContasLocal;
import br.com.fiapbank.dominio.entidade.Cliente;
import br.com.fiapbank.dominio.entidade.Conta;
import br.com.fiapbank.dominio.entidade.Endereco;
import br.com.fiapbank.dominio.entidade.Renda;
import br.com.fiapbank.dominio.entidade.Seguranca;
import br.com.fiapbank.mb.BaseMB;

/**
 * 
 * MB para as paginas de contas  /conta/paginas
 * 
 * 
 * @author robson.oliveira
 *
 */
public class ContaMB extends BaseMB {

	/**
	 * Log do MB 
	 */
	private static final Log LOG = LogFactory.getLog(ContaMB.class);
	
	
	@EJB
	private GerenciadorDeContasLocal gerenciadorDeContasLocal;
	
	
	
	/**
	 * Cliente para avaliacao e abertura da conta 
	 */
	private Cliente cliente;
	
	
	/**
	 * Renda para avaliacao e abertura de conta
	 * 
	 */
	private Renda renda;
	

	/**
	 *  Conta para abertura
	 */
	private Conta conta;
	

	
	/**
	 * utilizada para controlar os passos de abertura de conta na view 
	 */
	private boolean proximoPasso;
	
	/**
	 * 
	 * efetua a avaliacao do cliente 
	 * 
	 * @return
	 */
	public void avaliarCliente(){
		try {
			gerenciadorDeContasLocal.avaliarCliente(cliente);
			liberarProximoPasso();
		} catch (Exception e) { 
			bloquearProximoPasso(e.getMessage());
		} 		
	}

	
	/**
	 * 
	 * efetua a avaliacao da renda
	 * 
	 * @return
	 */
	public void avaliarRenda(){
		try {
			gerenciadorDeContasLocal.avaliarRenda(renda);
			liberarProximoPasso();
		} catch (Exception e) {
			bloquearProximoPasso(e.getMessage());
		} 
	}	
	
	
	
	/**
	 * 
	 * efetua a abertura da conta
	 * 
	 */
	public void abriConta(){	
		try {
			gerenciadorDeContasLocal.abriConta(conta);
			liberarProximoPasso();
		} catch (GerenciadorDeContasException e) {
			LOG.error("Ocorreu um erro ao criar ao abrir a conta.: ", e);
			bloquearProximoPasso(msg);
		} catch (Exception e) {
			bloquearProximoPasso(msg);
		} 
	}
	
	
	
	/**
	 * 
	 * prepra o MB para uma nova abertura de conta
	 * 
	 * @return
	 */
	public String novaConta(){
		init();
		return "abertura-de-conta";
	}	
	
	
	
	/**
	 *
	 * Inicializa os objetos do MB
	 * 
	 */
	@PostConstruct
	public void init(){
		cliente = new Cliente();
		cliente.setEndereco(new Endereco());
		renda = new Renda();
		conta = new Conta();
		conta.setSeguranca(new Seguranca());
		setProximoPasso(false);
	}


	/**
	 * 
	 * bloquea o passao atual da abertura de conta
	 * 
	 * @param msg
	 */
	private void bloquearProximoPasso(String msg) {
		setProximoPasso(false);
		adicionarMsg(msg);
	}


	
	/**
	 *
	 * libera o proximo passo para abertura da conta
	 * 
	 */
	private void liberarProximoPasso() {
		setProximoPasso(true);
		removeMsg();
	}	

	
	
	// >>>>>>>>>>>>>>>>>>> GETS e SETS do MB <<<<<<<<<<<<<<<<<<<<<


	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Renda getRenda() {
		return renda;
	}



	public void setRenda(Renda renda) {
		this.renda = renda;
	}


	public Conta getConta() {
		return conta;
	}


	public void setConta(Conta conta) {
		this.conta = conta;
	}


	public boolean isProximoPasso() {
		return proximoPasso;
	}


	public void setProximoPasso(boolean proximoPasso) {
		this.proximoPasso = proximoPasso;
	}
	
}
