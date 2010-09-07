package br.com.fiapbank.mb.autenticacao;

import javax.annotation.PostConstruct;

import br.com.fiapbank.dominio.Cargo;
import br.com.fiapbank.dominio.Conta;
import br.com.fiapbank.dominio.Funcionario;
import br.com.fiapbank.mb.BaseMB;
import br.com.fiapbank.negocio.NegocioException;
import br.com.fiapbank.negocio.autenticacao.Autenticador;
import br.com.fiapbank.negocio.autenticacao.AutenticadorFiapBank;

/**
 * @author robson.oliveira
 *
 */
public class AutenticadorMB extends BaseMB{

	/**
	 * 
	 */
	private Conta conta;
	
	
	/**
	 * 
	 */
	private Funcionario funcionario;
	

	/**
	 * 
	 */
	private Autenticador autenticador;
	

	
	public AutenticadorMB() {
		super();
	}

	
	
	public String autenticarFuncionario(){
		try {
			funcionario = autenticador.autenticarFuncionario(funcionario);
		} catch (NegocioException e) {
			setMsg(e.getMessage());
			return null;
		} 
	
		String navegacao = null;
		
		if(funcionario == null){
			setMsg("Login e senha nao confere");
		}else if( funcionario.getCargo() == Cargo.CAIXA){
			navegacao = "caixa";
		}else{
			navegacao = "cadastro-conta";
		}
		
		setAtributoInSession("funcionario", funcionario);
		
		return navegacao;
	}
	
	
	
	public String autenticarConta(){
		try {
			conta = autenticador.autenticarConta(conta);
		} catch (NegocioException e) {
			setMsg(e.getMessage());
			return null;
		}
		
		String navegacao = null;
		
		if (conta != null) 
			navegacao = "cliente";
		else
			setMsg("Dados da conta nao confere");
	
		setAtributoInSession("conta", conta);
		
		return navegacao;
	}


	
	@PostConstruct
	public void init(){
		conta = new Conta();
		funcionario = new Funcionario();
		autenticador = new AutenticadorFiapBank();
	}	

	
	
	// gets e sets	
	


	public Conta getConta() {
		return conta;
	}





	public void setConta(Conta conta) {
		this.conta = conta;
	}





	public Funcionario getFuncionario() {
		return funcionario;
	}





	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


}
