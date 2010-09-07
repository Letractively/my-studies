/**
 * 
 */
package br.com.fiapbank.negocio.caixa;


import br.com.fiapbank.dominio.Conta;
import br.com.fiapbank.dominio.TipoDeConta;
import br.com.fiapbank.dominio.TipoDeTransacao;
import br.com.fiapbank.negocio.NegocioBase;
import br.com.fiapbank.negocio.NegocioException;
import br.com.fiapbank.persistencia.dao.ContaDao;

/**
 * @author robson
 *
 */
public class CaixaNegocioFiapBank extends NegocioBase implements CaixaNegocio {


	public CaixaNegocioFiapBank(){
		super();
	}
	
	
	public CaixaNegocioFiapBank(ContaDao contaDao){
		super(contaDao);
	}
	
	
	@Override
	public void depositar(Conta conta, Double valor, String senha) throws NegocioException {		
		validarContaValor(conta, valor);
		conta = getConta(conta);
		validarSenhaTipoDeConta(conta, senha);
		
		conta.setSaldo(conta.getSaldo() + valor);
		
		salvarTransacao(
			conta, 
			valor, 
			TipoDeTransacao.DEPOSITO
		);
	}


	

	@Override
	public void sacar(Conta conta, Double valor,String senha) throws NegocioException{
		validarContaValor(conta, valor);
		conta = getConta(conta);
		validarSenhaTipoDeConta(conta, senha);
		
		if (conta.getSaldo() < valor) 	
			throw new NegocioException("Saldo insuficiente");
			
		
		conta.setSaldo( conta.getSaldo() - valor);
		
		salvarTransacao(
			conta, 
			valor, 
			TipoDeTransacao.SAQUE
		);
	}
	
	
	
	@Override
	public void retirarCartao(Conta conta, int quantidade,String senha) throws NegocioException{
		validarConta(conta);
		if (quantidade <=0) 
			throw new NegocioException("Quantidade minina de retirada = 1");
		if (quantidade > 1) 
			throw new NegocioException("Quantidade maxima de retirada = 1");
		conta = getConta(conta);
		validarSenha(conta, senha);

	}

	
	@Override
	public void retirarTalao(Conta conta,int quantidade,String senha) throws NegocioException{
		validarConta(conta);
		if (quantidade <=0) 
			throw new NegocioException("Quantidade minina de retirada = 1");		
		if (quantidade > 2) 
			throw new NegocioException("Quantidade maxima de retirada = 2");
		conta = getConta(conta);
		validarSenha(conta, senha);
	}
}
