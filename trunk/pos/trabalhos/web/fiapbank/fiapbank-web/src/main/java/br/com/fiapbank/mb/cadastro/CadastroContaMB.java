/**
 * 
 */
package br.com.fiapbank.mb.cadastro;

import javax.annotation.PostConstruct;
import javax.persistence.EnumType;

import br.com.fiapbank.dominio.Conta;
import br.com.fiapbank.dominio.TipoDeConta;
import br.com.fiapbank.mb.BaseMB;
import br.com.fiapbank.negocio.NegocioException;
import br.com.fiapbank.negocio.cadastro.CadastroContaNegocio;
import br.com.fiapbank.negocio.cadastro.CadastroContaNegocioFiapBank;

/**
 * @author robson
 *
 */
public class CadastroContaMB extends BaseMB {

	/**
	 * 
	 */
	public Conta conta;
	
	
	/**
	 * 
	 */
	public String tipoConta;
	
	
	/**
	 * 
	 */
	private CadastroContaNegocio cadastroContaNegocio;
	
	
	@PostConstruct
	public void init(){
		conta = new Conta();
		cadastroContaNegocio = new CadastroContaNegocioFiapBank();
	}
	
	public void cadastrar(){
		try {
			TipoDeConta tipoDeConta = Enum.valueOf(TipoDeConta.class, tipoConta);
			conta.setTipoDeConta(tipoDeConta);
			cadastroContaNegocio.cadastrar(conta);
			setMsg("Conta cadastrada com sucesso");
			setConta(new Conta());
		} catch (NegocioException e) {
			setMsg(e.getMessage());
		}
	}


	
	
	// gets e sets 

	public Conta getConta() {
		return conta;
	}



	public void setConta(Conta conta) {
		this.conta = conta;
	}



	public String getTipoConta() {
		return tipoConta;
	}



	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	
}
