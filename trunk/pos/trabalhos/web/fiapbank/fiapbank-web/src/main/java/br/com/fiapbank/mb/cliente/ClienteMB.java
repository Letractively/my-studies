/**
 * 
 */
package br.com.fiapbank.mb.cliente;


import java.util.List;

import javax.annotation.PostConstruct;

import br.com.fiapbank.dominio.Conta;
import br.com.fiapbank.dominio.Transacao;
import br.com.fiapbank.mb.BaseMB;
import br.com.fiapbank.negocio.cliente.ClienteNegocio;
import br.com.fiapbank.negocio.cliente.ClienteNegocioFiapBank;

/**
 * @author robson
 *
 */
public class ClienteMB extends BaseMB {

	
	
	
	private ClienteNegocio clienteNegocio;
	

	/**
	 *   
	 */
	private Conta conta;
	
	
	
	/**
	 * 
	 */
	private List<Transacao> transacaoes;
	
	
	/**
	 * 
	 */
	private String novaFraseSecreta;
	
	
	/**
	 * 
	 */
	private Double valor;
	
	
	
	@PostConstruct
	public void initi(){
		conta = new Conta();
		clienteNegocio = new ClienteNegocioFiapBank();
	}
	
	
	
	public void criarExtrato(){
		try {			
			transacaoes = 
				clienteNegocio.getTransacoes(
						getContaSession(), 
						conta.getSenha(), 
						conta.getFraseSecreta()
					);
			limparMsg();
		} catch (Exception e) {
			setMsg(e.getMessage());
		}
	}

	
	public void getSaldo(){
		try {			
			conta = 
				clienteNegocio.getSaldo(
						getContaSession(), 
						conta.getSenha(), 
						conta.getFraseSecreta()
					);
			limparMsg();
		} catch (Exception e) {
			setMsg(e.getMessage());
		}
	}
	
	
	public void alterarFraseSecreta(){
		try {			
			clienteNegocio.alterarFraseSecreta(
					getContaSession(), 
					conta.getSenha(), 
					conta.getFraseSecreta(), 
					novaFraseSecreta
				);
			setMsg("Frase alterada com sucesso");
		} catch (Exception e) {
			setMsg(e.getMessage());
		}
	}	
	
	
	public void aplicarPoupanca(){
		try {			
			clienteNegocio.aplicarPoupanca(
					getContaSession(), 
					conta.getSenha(), 
					conta.getFraseSecreta(),
					valor
				);
			setValor(null);
			setMsg("Aplicacao realizada com sucesso");
		} catch (Exception e) {
			setMsg(e.getMessage());
		}
	}
	
	public void resgatarPoupanca(){
		try {			
			clienteNegocio.resgatarPoupanca(
					getContaSession(), 
					conta.getSenha(), 
					conta.getFraseSecreta(),
					valor
				);
			setValor(null);
			setMsg("Resgate realizado com sucesso");
		} catch (Exception e) {
			setMsg(e.getMessage());
		}
	}
	
	public void realizarTransferencia(){
		try {			
			clienteNegocio.realizarTransferencia(
					getContaSession(), 
					conta.getSenha(), 
					conta.getFraseSecreta(),
					valor, 
					conta
				);
			setMsg("Transferencia realizado com sucesso");
			limpar();
			setValor(null);
		} catch (Exception e) {
			setMsg(e.getMessage());
		}
	}
	
	
	public void realizarDocTed(){
		try {			
			clienteNegocio.realizarDocTed(
					getContaSession(), 
					conta.getSenha(), 
					conta.getFraseSecreta(),
					valor, 
					conta
				);
			setMsg("Doc Ted realizado com sucesso");
			limpar();
			setValor(null);
		} catch (Exception e) {
			setMsg(e.getMessage());
		}
	}

	
	public void limpar(){
		conta = new Conta();
	}
	
	
	public void limparExtrato(){
		setTransacaoes(null);
		limparMsg();
	}
	
	
	public  void limparSaldo(){
		limpar();
		limparMsg();
	}
	
	
	public void limparMsg(){
		setMsg("");
	}

	
	// gets e sets ...
	
	
	
	public Conta getConta() {
		return conta;
	}



	public void setConta(Conta conta) {
		this.conta = conta;
	}



	public List<Transacao> getTransacaoes() {
		return transacaoes;
	}



	public void setTransacaoes(List<Transacao> transacaoes) {
		this.transacaoes = transacaoes;
	}



	public String getNovaFraseSecreta() {
		return novaFraseSecreta;
	}



	public void setNovaFraseSecreta(String novaFraseSecreta) {
		this.novaFraseSecreta = novaFraseSecreta;
	}



	public Double getValor() {
		return valor;
	}



	public void setValor(Double valor) {
		this.valor = valor;
	}	
}
