/**
 * 
 */
package br.com.fiapbank.credito;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.security.annotation.SecurityDomain;

import br.com.fiapbank.dominio.entidade.Conta;
import br.com.fiapbank.dominio.entidade.Credito;
import br.com.fiapbank.dominio.entidade.Renda;
import br.com.fiapbank.dominio.entidade.StatusCredito;

/**
 * implementacao staleless para o gerenciador de credito 
 * 
 * @author robson
 *
 */
@Stateless
@Local(GerenciadorCreditoLocal.class)
@Remote(GerenciadorDeCreditosRemote.class)
@SecurityDomain(value="fiapbank-security")
public class GerenciadorDeCreditosBean implements GerenciadorCreditoLocal,GerenciadorDeCreditosRemote {

	
	@PersistenceContext(unitName="fiapbank_credito")
	private EntityManager entityManager;
	
	@RolesAllowed(value="CLIENTE")
	public Credito avaliarCredito(Credito credito,Renda renda) {
		if (credito == null || renda == null) 
			throw new IllegalArgumentException("Credito nullo ou Renda nulla");
		
		if( primeiraRegra(renda, credito))
			credito.setStatusCredito(StatusCredito.APROVADO);
		else if( segundaRegra(renda, credito) )
			credito.setStatusCredito(StatusCredito.APROVADO);
		else if( terceiraRegra(renda, credito) )
			credito.setStatusCredito(StatusCredito.REJEITADO);
		else
			credito.setStatusCredito(StatusCredito.SUJEITO_A_APROVACAO);
		return credito;
	}

	
	@RolesAllowed(value="CLIENTE")
	public void criarCredito(Credito credito, Conta conta){
		if (credito == null || conta == null)
			throw new IllegalArgumentException("Credito nulo ou Conta nula");
		if (credito.getStatusCredito() == null || credito.getStatusCredito() == StatusCredito.REJEITADO) {
			throw new IllegalStateException( "Credito sem status ou com Status Rejeitado");
		}

		conta = entityManager.find(Conta.class, conta.getId());
		
		credito.setConta(conta);
		
		entityManager.persist(credito);

	}
	

	@Override
	@RolesAllowed(value="CLIENTE")
	public Conta getContaParaCredito(String login) {
		return (Conta) entityManager.createQuery("select c from Conta c where c.seguranca.login = :login")
			.setParameter("login", login)
			.getSingleResult();
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	@RolesAllowed(value="CLIENTE")
	public List<Credito> getCreditos(Conta conta){
		if(conta == null )
			throw new IllegalArgumentException("Conta nula");
		
		return entityManager.createQuery("select c from Credito c where c.conta.id = :idConta")
			.setParameter("idConta", conta.getId())
			.getResultList();
	}	

	
	
	@Override
	@SuppressWarnings("unchecked")
	@RolesAllowed(value="GERENTE")
	public List<Credito> getCreditosAvaliar() {
		return entityManager.createQuery("select c from Credito c where c.statusCredito = :statusCredito ")
			.setParameter("statusCredito", StatusCredito.SUJEITO_A_APROVACAO)
			.getResultList();
	}

	
	@Override
	@RolesAllowed(value="GERENTE")
	public void aprovarCredito(Credito credito) {
		validarCredito(credito);
		credito.setStatusCredito(StatusCredito.APROVADO);
		entityManager.merge(credito);
	}


	
	@Override
	@RolesAllowed(value="GERENTE")
	public void reijetarCredito(Credito credito) {
		validarCredito(credito);
		credito.setStatusCredito(StatusCredito.REJEITADO);
		entityManager.merge(credito);		
	}
	
	
	
	// valor < (renda - gasto) * 0,4 * meses
	private boolean primeiraRegra(Renda renda,Credito credito){
		return credito.getValorCredito()
			.compareTo(
				rendaMenosGastos(renda)
					.multiply(
						alicotaVezesMeses(0.4, credito)
					)
			) <= 0;
	}
	

	private boolean segundaRegra(Renda renda, Credito credito) {
		return credito.getValorCredito()
		.compareTo(
			rendaMenosGastos(renda)
				.multiply(
					alicotaVezesMeses(0.2, credito)
				).add(
					alicotaVezesPatrimonio(0.1,renda)
				)
		) <= 0;
	}

	
	private boolean terceiraRegra(Renda renda, Credito credito) {
		return credito.getValorCredito()
		.compareTo(
			rendaMenosGastos(renda)
				.multiply(
					alicotaVezesMeses(0.6, credito)
				).add(
					alicotaVezesPatrimonio(0.3,renda)
				)
		) > 0;
	}	
	

	private BigDecimal rendaMenosGastos(Renda renda){
		return renda.getRendaMensal().subtract(renda.getGastoMensal());
	}
		
	private BigDecimal alicotaVezesMeses(double aliquota, Credito credito) {
		return new BigDecimal(aliquota).multiply(new BigDecimal(credito.getQuantidadeDeMeses()));
	}
	
	private BigDecimal alicotaVezesPatrimonio(Double aliquota, Renda renda) {
		return new BigDecimal(aliquota).multiply(renda.getValorTotalPatrimonio());
	}

	
	private void validarCredito(Credito credito) {
		if(credito == null || credito.getId() == null)
			throw new IllegalArgumentException("Credito nulo ou Credito com ID nulo");
	}
	
}
