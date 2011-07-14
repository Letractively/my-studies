package br.com.lawoffice.caixa;

import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.dominio.HistoricoConta;
import br.com.lawoffice.dominio.TipoTransacao;

/**
 * Implementação para a Interface de serviços de caixa do escritório.
 * 
 * @author robson
 *
 */
@Stateless
@Local(CaixaServiceLocal.class)
@Remote(CaixaServiceRemote.class)
public class CaixaServiceBean implements CaixaService {
	
	
	@Override
	public Conta creditar(Conta conta, BigDecimal valor){
		validarParamentros(conta, valor);
	
/*		conta = getConta(conta); 
			
		conta.setSaldo(
				conta.getSaldo().add(valor)
			);
		
		entityManager.persist(
			new HistoricoConta(
				new Date(), 
				TipoTransacao.CREDITO,
				valor,
				conta
			)
		);
		
		return entityManager.merge(conta);*/
		
		return null;
	}

	
	@Override
	public Conta debitar(Conta conta, BigDecimal  valor){
		validarParamentros(conta, valor);
		
/*		conta = getConta(conta);
		
		conta.setSaldo(
				conta.getSaldo().subtract(valor)
			);
	 		
		entityManager.persist(
			new HistoricoConta(
				new Date(), 
				TipoTransacao.DEBITO ,
				valor,
				conta
			)
		);
		
		return entityManager.merge(conta);*/
		
		return null;
	}

	
	

	/**
	 * Retorna a Conta pelo contexto do EntityManager
	 * 
	 * @param conta passda para adicionar ao contexto do EntiyManager.
	 * @return {@link Conta} no contexto do EntityManager.
	 * @throws CaixaException caso a {@link Conta} não seja encontrada na base de dados.
	 */
	private Conta getConta(Conta conta){
/*		conta = entityManager.find(Conta.class, conta.getId());		
		
		if(conta == null)
			throw new CaixaException("Conta não encontrado");
		return conta;*/
		
		return null;
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
