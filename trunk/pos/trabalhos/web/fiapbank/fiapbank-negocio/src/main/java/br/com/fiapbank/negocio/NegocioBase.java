/**
 * 
 */
package br.com.fiapbank.negocio;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import br.com.fiapbank.dominio.Conta;
import br.com.fiapbank.dominio.TipoDeConta;
import br.com.fiapbank.dominio.TipoDeTransacao;
import br.com.fiapbank.dominio.Transacao;
import br.com.fiapbank.persistencia.dao.ContaDao;
import br.com.fiapbank.persistencia.dao.DaoException;
import br.com.fiapbank.persistencia.dao.hibernate.jpa.ContaDaoJPAHibernate;

/**
 * @author robson
 *
 */
public class NegocioBase {

	/**
	 * 
	 */
	protected ContaDao contaDao;
	
	
	/**
	 * 
	 */
	public NegocioBase(){
		contaDao = new ContaDaoJPAHibernate();
	}
	
	
	/**
	 * @param contaDao
	 */
	public NegocioBase(ContaDao contaDao){
		if (contaDao == null) 
			throw new IllegalArgumentException("contadao null");
		this.contaDao = contaDao;
	}
	
	
	/**
	 * 
	 * obtem a conta da base atraves do numero de agencia/conta
	 * 
	 * @param conta
	 * @return
	 * @throws CaixaException
	 */
	protected Conta getConta(Conta conta) throws NegocioException {
		try {
			conta = contaDao.getContaPorNumeroAgencia(conta);
			if (conta == null)
				throw new NegocioException("Conta nao encontrada");
			return conta;
		} catch (DaoException e){
			throw new NegocioException(e);
		}
	}
	

	/**
	 * 
	 * efetua a transacao realizada em questao
	 * 
	 * @param conta
	 * @param valor
	 * @param tipoDeTransacao
	 * @throws CaixaException
	 */
	protected void salvarTransacao(Conta conta, Double valor, TipoDeTransacao tipoDeTransacao)throws NegocioException {
		conta.getTransacoes().add( 
				new Transacao(
						new Date(), 
						valor , 
						tipoDeTransacao, 
						conta
				)
		);		
		try {
			contaDao.update(conta);
		} catch (DaoException e) {
			throw new NegocioException(e);
		}
	}
	
	
	
	/**
	 * 
	 * efetua a transacao realizada em questao
	 * 
	 * @param conta
	 * @param valor
	 * @param tipoDeTransacao
	 * @throws CaixaException
	 */
	protected void salvarTransacao(Conta conta, Conta contaDestino, Double valor, TipoDeTransacao tipoDeTransacao)throws NegocioException {
		conta.getTransacoes().add( 
				new Transacao(
						new Date(), 
						valor , 
						tipoDeTransacao,
					    contaDestino.getNumero(),
					    contaDestino.getNumeroAgencia(),
						conta
				)
		);		
		try {
			contaDao.update(conta);
		} catch (DaoException e) {
			throw new NegocioException(e);
		}
	}
	
	public void validarConta(Conta conta){
		if ( conta == null) 
			throw new IllegalArgumentException("conta esta nulla");
	}
	
	
	protected void validarSenhaFraseSecreta(Conta conta, String senha,String fraseSecreta) throws NegocioException {
		if( !conta.getSenha().equals(senha) )
			throw new NegocioException("Senha nao confere");
		if( !conta.getFraseSecreta().equals(fraseSecreta) )
			throw new NegocioException("Frase Secreta nao confere");
	}	
	
	
	protected void validarContaPoupanca(Conta conta) throws NegocioException {
		if(conta.getTipoDeConta() != TipoDeConta.POUPANCA)
			throw new NegocioException("Operacao nao disponviel para esse tipo de conta");
	}	
	
	
	protected void validarValor(Double valor) throws NegocioException {
		if (valor == null) 
			throw new IllegalArgumentException("valor nullo");
		if(valor < 0)
			throw new NegocioException("O valor nao pode ser negativo");
	}
	
	
	
	protected void validarSenha(Conta conta, String senha)throws NegocioException{
		if( !conta.getSenha().equals(senha))
			throw new NegocioException("Senha nao confere");
	}
	
	
	protected void validarSenhaTipoDeConta(Conta conta, String senha)throws NegocioException{
		if ( conta.getTipoDeConta() == TipoDeConta.POUPANCA) 
			throw new NegocioException("Transacao nao disponviel para esse tipo de conta");
		if( !conta.getSenha().equals(senha))
			throw new NegocioException("Senha nao confere");
	}
	
	
	protected void validarContaValor(Conta conta, Double valor)throws NegocioException {
		validarConta(conta);
		validarValor(valor);
	}
	
	
	
	protected void validarContas(Conta conta, Conta contaDestino){
		validarConta(contaDestino);
		validarConta(conta);
	}
	
}
