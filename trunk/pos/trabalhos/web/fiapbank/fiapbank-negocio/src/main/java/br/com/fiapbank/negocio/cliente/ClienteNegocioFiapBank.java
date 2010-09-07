package br.com.fiapbank.negocio.cliente;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.fiapbank.dominio.Conta;
import br.com.fiapbank.dominio.TipoDeTransacao;
import br.com.fiapbank.dominio.Transacao;
import br.com.fiapbank.negocio.NegocioBase;
import br.com.fiapbank.negocio.NegocioException;
import br.com.fiapbank.persistencia.dao.ContaDao;
import br.com.fiapbank.persistencia.dao.DaoException;

/**
 * @author robson
 *
 */
public class ClienteNegocioFiapBank extends NegocioBase implements ClienteNegocio {

	
	
	public ClienteNegocioFiapBank(){
		super();
	}
	
	
	public ClienteNegocioFiapBank(ContaDao contaDao){
		super(contaDao);
	}
	
	@Override
	public List<Transacao> getTransacoes(Conta conta, String senha, String fraseSecreta) throws NegocioException{		
		validarConta(conta);		
		conta = getConta(conta);		
		validarSenhaFraseSecreta(conta,senha,fraseSecreta);		
		return conta.getTransacoes();
	}


	@Override
	public Conta getSaldo(Conta conta, String senha, String fraseSecreta)throws NegocioException {
		validarConta(conta);		
		conta = getConta(conta);		
		validarSenhaFraseSecreta(conta,senha,fraseSecreta);		
		return conta;
		
	}


	@Override
	public void alterarFraseSecreta(Conta conta, String senha,String fraseSecreta, String novaFraseSecreta)throws NegocioException {
		validarConta(conta);		
		conta = getConta(conta);		
		validarSenhaFraseSecreta(conta,senha,fraseSecreta);
		if(StringUtils.isBlank(novaFraseSecreta) )
			throw new NegocioException("A Nova Frase nao pode ser branca");
		conta.setFraseSecreta(novaFraseSecreta);
		try {
			contaDao.update(conta);
		} catch (DaoException e) {
			throw new NegocioException(e);
		}
	}


	@Override
	public void aplicarPoupanca(Conta conta, String senha, String fraseSecreta,Double valor)throws NegocioException{
		validarConta(conta);
		validarValor(valor);				
		conta = getConta(conta);
		validarContaPoupanca(conta);
		validarSenhaFraseSecreta(conta,senha,fraseSecreta);
		
		conta.setSaldo( conta.getSaldo() + valor );
		
		salvarTransacao(conta, valor, TipoDeTransacao.APLICACAO_POUPANCA);
	}


	@Override
	public void resgatarPoupanca(Conta conta, String senha,String fraseSecreta, Double valor) throws NegocioException {
		validarConta(conta);
		validarValor(valor);				
		conta = getConta(conta);
		validarContaPoupanca(conta);
		validarSenhaFraseSecreta(conta,senha,fraseSecreta);
		
		
		if( conta.getSaldo() < valor)
			throw new NegocioException("Nao e possivel resgatar esse valor");
		
		conta.setSaldo( conta.getSaldo() - valor );
		
		salvarTransacao(conta, valor, TipoDeTransacao.RESGATE_POUPANCA);
	}


	@Override
	public void realizarTransferencia(Conta conta, String senha,String fraseSecreta, Double valor, Conta contaDestino)
			throws NegocioException{
		validarContas(conta,contaDestino);
		validarValor(valor);
		conta = getConta(conta);
		validarSenhaFraseSecreta(conta, senha, fraseSecreta);
		
		if( conta.getSaldo() < valor)
			throw new NegocioException("Saldo insuficiente");
		
		
		conta.setSaldo( conta.getSaldo() - valor );
		
		salvarTransacao(conta, contaDestino, valor,  TipoDeTransacao.TRANSFERENCIA);
		
	}


	@Override
	public void realizarDocTed(Conta conta, String senha, String fraseSecreta,
			Double valor, Conta contaDestino) throws NegocioException {
		
		validarContas(conta,contaDestino);
		validarValor(valor);
		conta = getConta(conta);
		validarSenhaFraseSecreta(conta, senha, fraseSecreta);
		
		if( conta.getSaldo() < valor)
			throw new NegocioException("Saldo insuficiente");
		
		
		conta.setSaldo( conta.getSaldo() - valor );
		
		salvarTransacao(conta, contaDestino, valor,  TipoDeTransacao.DOC_TED);
	}
	
	
}
