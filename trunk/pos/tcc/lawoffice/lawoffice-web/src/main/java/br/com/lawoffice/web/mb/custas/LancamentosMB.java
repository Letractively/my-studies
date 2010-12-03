package br.com.lawoffice.web.mb.custas;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.web.mb.BaseMB;
import br.com.lowoffice.custas.CustasLocal;

/**
 * 
 * @author robson
 * 
 * Manager Bean para página de /custas/lacamentos.xhtml
 *
 */
@ManagedBean
@ViewScoped
public class LancamentosMB extends BaseMB{


	// >>>>>>> ATRIBUTOS DE DOMINIO <<<<<<<<<<<<
	
	/**
	 * Lista com o resultado da pesquisa 
	 */
	private List<Custa> listaCustas;

	/**
	 * Data inicial para filtrar a pesquisa de lançamentos de custas
	 */
	private Date dataInicial;
	
	/**
	 * Data final para filtrar a pesquisa de lançamentos de custas
	 */
	private Date dataFinal;
	
	/**
	 * ID do cliente selecionado para filtrar a pesquisa de lançamentos custas
	 */
	private Long clienteID;
	
	
	/**
	 * Mapa para o filtro da pesquisa
	 */
	private Map<String, Object> filtro = new HashMap<String, Object>();
	
	
	// FIXME o bean injetado está com um implementação mock ainda do 
	// serviço de filtrar devido o débito tecnico em creteria em jpa 2.0
	@EJB
	private CustasLocal custas;
	

	
	
	
	public void pesquisarLancamentos(){
		
		filtro.put("dataInicial", dataInicial);
		filtro.put("dataFinal", dataFinal);
		filtro.put("clienteId", clienteID);
		
		listaCustas = custas.getCustas(filtro);
	}
	
	
	// >>> GETS e SETS do MB <<<

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


	public Long getClienteID() {
		return clienteID;
	}


	public void setClienteID(Long clienteID) {
		this.clienteID = clienteID;
	}


	public List<Custa> getListaCustas() {
		return listaCustas;
	}


	public void setListaCustas(List<Custa> listaCustas) {
		this.listaCustas = listaCustas;
	}
}
