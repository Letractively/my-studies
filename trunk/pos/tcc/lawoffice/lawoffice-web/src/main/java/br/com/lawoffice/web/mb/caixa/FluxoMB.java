/**
 * 
 */
package br.com.lawoffice.web.mb.caixa;

import javax.faces.bean.ManagedBean;

import br.com.lawoffice.web.mb.AutoCompleteMB;

/**
 * 
 * Managed Bean para página de /caixa/fluxo.xhtml
 * 
 * @author robson
 *
 */
@ManagedBean
public class FluxoMB extends AutoCompleteMB {

	/**
	 * Data inicial para consulta
	 *//*
	private Date dataInicial;
	
	
	*//**
	 * Data final para consulta
	 * 
	 *//*
	private Date dataFinal;
	
	
	*//**
	 * Lista de {@link Transacao} com o resultado da consulta
	 * 
	 *//*
	private List<Transacao> listTransacoes;
	
	*//**
	 * 
	 * Serviço que realiza a consulta de fluxos de Caixa
	 * 
	 *//*
	@EJB
	private FluxoCaixaLocal fluxoLocal;
	
	
	
	public void consultar(){
		listTransacoes = 
			fluxoLocal.consultarFluxoDeCaixa(
				dataInicial, 
				dataFinal, 
				colaborador.getConta().getId()
			);
		
		if(listTransacoes.isEmpty())
			adicionarMensagemAlerta(null, null, "Não foi encontrado nem fluxo de caixa para esse periodo");
	}

	
	
	/// GETS E SETS do MB


	public Date getDataInicial() {
		return dataInicial;
	}



	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}



	public Date getDataFinal() {
		return dataFinal;
	}



	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}



	public List<Transacao> getListTransacoes() {
		return listTransacoes;
	}



	public void setListTransacoes(List<Transacao> listTransacoes) {
		this.listTransacoes = listTransacoes;
	}
*/	
}