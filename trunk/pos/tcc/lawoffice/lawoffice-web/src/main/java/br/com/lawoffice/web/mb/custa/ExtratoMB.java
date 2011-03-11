package br.com.lawoffice.web.mb.custa;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.web.mb.AutoCompleteMB;
import br.com.lowoffice.custas.extrato.ExtratoLocal;

/**
 * 
 * @author robson
 * 
 * Manager Bean para página de /caixa/extrato.xhtml
 *
 */
@ManagedBean
@ViewScoped
public class ExtratoMB extends AutoCompleteMB{


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
	 * serviços de custas
	 */
	@EJB
	private ExtratoLocal custas;
	
	
	public void pesquisarLancamentos(){			
		listaCustas = 
			custas.getCustasPorDataCliente(
				dataInicial, 
				dataFinal, 
				cliente.getId()
			);
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


	public List<Custa> getListaCustas() {
		return listaCustas;
	}


	public void setListaCustas(List<Custa> listaCustas) {
		this.listaCustas = listaCustas;
	}
}
