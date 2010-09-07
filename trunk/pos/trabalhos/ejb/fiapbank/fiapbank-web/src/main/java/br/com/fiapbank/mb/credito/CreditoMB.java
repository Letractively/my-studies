/**
 * 
 */
package br.com.fiapbank.mb.credito;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import br.com.fiapbank.credito.GerenciadorCreditoLocal;
import br.com.fiapbank.dominio.entidade.Conta;
import br.com.fiapbank.dominio.entidade.Credito;
import br.com.fiapbank.mb.BaseMB;


/**
 * 
 * MB para requisicoes de /credito/paginas..
 * 
 * @author robson.oliveira
 *
 */
public class CreditoMB extends BaseMB {

	@EJB
	private GerenciadorCreditoLocal gerenciadorCreditoLocal;
		
	
	/**
	 * Credito a ser avaliado
	 */
	private Credito credito;
	
	
	/**
	 * Creditos da conta logada
	 */
	private List<Credito> creditos;
	

	/**
	 * Lista de creditos para avaliar  
	 */
	private List<Credito> creditosAvaliar;
	
	
	
	/**
	 * Status do credito utilizado para navegacao na view 
	 */
	private String statusCredito;


	/**
	 * Id do credito selecionado para exibicao de detalhes
	 */
	private Long idCreditoSelecionado;
	
	
	public void avaliarCredito(){
		credito = gerenciadorCreditoLocal.avaliarCredito(credito, getContaSessao().getCliente().getRenda());
		exibirStatus();
	}

	
	public void criarCredito(){
		gerenciadorCreditoLocal.criarCredito(credito, getContaSessao());
	}

	/**
	 * 
	 * lista os creditos da conta da sessao
	 * 
	 * @return
	 */
	public String listarCreditos(){
		creditos = gerenciadorCreditoLocal.getCreditos(getContaSessao());		
		return "lista-de-credito";
	}
	
	
	/**
	 * 
	 * lista os creditos que estao a espera de aprovacao
	 * 
	 * @return
	 */
	public String listarCreditosAvaliar(){				
		creditosAvaliar = gerenciadorCreditoLocal.getCreditosAvaliar();		
		return "lista-de-credito-avaliar";
	}	
	
	
	public void aprovarCredito(){
		gerenciadorCreditoLocal.aprovarCredito(credito);
		listarCreditosAvaliar();
	}

	
	public void rejeitarCredito(){
		gerenciadorCreditoLocal.reijetarCredito(credito);
		listarCreditosAvaliar();
	}
	
	/**
	 * inicializa um novo pedido de credito
	 * 
	 * @return
	 */
	public String novoPedidodeCredito(){
		init();
		return "abertura-de-credito";
	}
	
	/**
	 * 
	 * seleciona o credito para avaliacao
	 * 
	 * @return
	 */
	public void selecionarCreditoAvaliar(){
		for (Credito credito : creditosAvaliar) {
			if(credito.getId().equals(idCreditoSelecionado)){
				this.credito = credito;
				break;
			}
		}
	}

	
	@PostConstruct
	public void init(){
		credito = new Credito();
	}	
	
	
	private void exibirStatus() {
		setStatusCredito(credito.getStatusCredito().name());
	}
	
	
	/**
	 * obtem a conta logada
	 * 
	 * @return
	 */
	private Conta getContaSessao(){
		return gerenciadorCreditoLocal.getContaParaCredito(getLoginSessao());
	}

	
	
	// Gets e sets do mb 
	
	
	public Credito getCredito() {
		return credito;
	}


	public void setCredito(Credito credito) {
		this.credito = credito;
	}

	
	public String getStatusCredito() {
		return statusCredito;
	}

	
	public void setStatusCredito(String statusCredito) {
		this.statusCredito = statusCredito;
	}


	public List<Credito> getCreditos() {
		return creditos;
	}


	public void setCreditos(List<Credito> creditos) {
		this.creditos = creditos;
	}


	public List<Credito> getCreditosAvaliar() {
		return creditosAvaliar;
	}


	public void setCreditosAvaliar(List<Credito> creditosAvaliar) {
		this.creditosAvaliar = creditosAvaliar;
	}


	public Long getIdCreditoSelecionado() {
		return idCreditoSelecionado;
	}


	public void setIdCreditoSelecionado(Long idCreditoSelecionado) {
		this.idCreditoSelecionado = idCreditoSelecionado;
	}
}
