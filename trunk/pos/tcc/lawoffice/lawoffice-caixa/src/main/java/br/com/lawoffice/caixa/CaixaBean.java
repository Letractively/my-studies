package br.com.lawoffice.caixa;

import java.math.BigDecimal;
import java.util.Date;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.dominio.TipoTransacao;
import br.com.lawoffice.dominio.Transacao;

/**
 * 
 * TODO: javadoc
 * 
 * @author robson
 *
 */
@Stateless
@Local(CaixaLocal.class)
@Remote(CaixaRemote.class)
public class CaixaBean implements Caixa {

	
	@PersistenceContext(unitName="lawoffice-caixa")
	private EntityManager entityManager;
	
	@Override
	public Conta creditar(Conta conta, BigDecimal valor){
		
		// TODO: refatorar
		if(conta == null || conta.getSaldo() == null)
			throw new IllegalArgumentException("Conta está nula ou sem saldo");
		if(valor == null || valor.doubleValue() < 0)
			throw new IllegalArgumentException("Conta está nula ou é menor que 0");
		
		
		// TODO: testar		
		conta = entityManager.find(Conta.class, conta.getId());
		
		
		conta.setSaldo(
				conta.getSaldo().add(valor)
			);
		
		Transacao t = new Transacao(new Date(), TipoTransacao.CREDITO);
		
		t.setConta(conta);
		
		conta.getTransacoes().add(
				t	
			);
		
		entityManager.merge(conta);
		
		return conta;
	}

	
	
	
	@Override
	public void debitar(Conta conta, BigDecimal  valor) {
		// TODO Auto-generated method stub
		System.out.println("debitando");

	}

}
