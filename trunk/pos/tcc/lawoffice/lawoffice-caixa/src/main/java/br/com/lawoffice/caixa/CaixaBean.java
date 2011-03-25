package br.com.lawoffice.caixa;

import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.lawoffice.caixa.exception.CaixaException;
import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.dominio.TipoTransacao;
import br.com.lawoffice.dominio.Transacao;

/**
 * Implementação para a Interface de serviços de caixa do escritório.
 * 
 * @author robson
 *
 */
@Stateless
@Local(CaixaLocal.class)
@Remote(CaixaRemote.class)
public class CaixaBean implements Caixa {
	
	/**
	 * EntityManager para realizar as operações com a base de dados.
	 */
	@PersistenceContext(unitName="lawoffice-caixa")
	private EntityManager entityManager;
	
	@Override
	public Conta creditar(Conta conta, BigDecimal valor) throws CaixaException{
		validarParamentros(conta, valor);
	
		conta = getConta(conta); 
			
		conta.setSaldo(
				conta.getSaldo().add(valor)
			);
		
		entityManager.persist(
			new Transacao(
				new Date(), 
				TipoTransacao.CREDITO,
				valor,
				conta
			)
		);
		
		return entityManager.merge(conta);
	}

	
	@Override
	public Conta debitar(Conta conta, BigDecimal  valor) throws CaixaException {
		validarParamentros(conta, valor);
		
		conta = getConta(conta);
		
		conta.setSaldo(
				conta.getSaldo().subtract(valor)
			);
	 		
		entityManager.persist(
			new Transacao(
				new Date(), 
				TipoTransacao.DEBITO ,
				valor,
				conta
			)
		);
		
		return entityManager.merge(conta);
	}

	
	
	@Override
	public BigDecimal getSaldo(Conta conta) throws CaixaException {
		return getConta(conta).getSaldo();
	}
	

	/**
	 * Retorna a Conta pelo contexto do EntityManager
	 * 
	 * @param conta passda para adicionar ao contexto do EntiyManager.
	 * @return {@link Conta} no contexto do EntityManager.
	 * @throws CaixaException caso a {@link Conta} não seja encontrada na base de dados.
	 */
	private Conta getConta(Conta conta) throws CaixaException {
		conta = entityManager.find(Conta.class, conta.getId());		
		
		if(conta == null)
			throw new CaixaException("Conta não encontrado");
		return conta;
	}	

	

	/**
	 * 
	 * Realiza as validações dos parametros passado para realizar as operações de caixa.
	 * 
	 * @param conta a ser validada.
	 * @param valor a ser validado.
	 */
	private void validarParamentros(Conta conta, BigDecimal valor) {
		if(valor == null || valor.doubleValue() < 0)
			throw new IllegalArgumentException("O valor está nulo ou é menor que 0");
		if(conta == null || conta.getId() == null)
			throw new IllegalArgumentException("Conta está nula ou nao contém ID");
	}


}
