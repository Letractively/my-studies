package br.com.lawoffice.web.mb.custa;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.time.DateFormatUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.web.mb.AutoCompleteMB;
import br.com.lowoffice.custas.extrato.ExtratoLocal;
import br.com.lowoffice.custas.extrato.TipoExtrato;

/**
 * 
 * @author robson
 * 
 * Managed Bean para página de /caixa/extrato.xhtml
 *
 */
@ManagedBean
@ViewScoped
public class ExtratoMB extends AutoCompleteMB{


	// >>>>>>> ATRIBUTOS DE DOMINIO <<<<<<<<<<<<
	
	/**
	 * Lista de {@link Custa} com o resultado da pesquisa  
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
	 * valor totala cáculado para a pesquisa realizada.
	 */
	private BigDecimal valorTotalPesquisa;
	
	
	/**
	 * Arquivo para dowload do .pdf do extrado do resultado da pesquisa.
	 */
	private StreamedContent fileExtrado;
	
	
	/**
	 * serviços de extrato de {@link Custa}
	 */
	@EJB
	private ExtratoLocal extrato;
	
	
	
	public void pesquisarLancamentos(){			
		listaCustas = 
			extrato.getCustasPorDataCliente(
				dataInicial, 
				dataFinal, 
				cliente.getId()
			);
		
		if(listaCustas.isEmpty()){
			adicionarMensagemAlerta(
					null, 
					null, 
					"Não foi encontrado lançamento de custa para esse periodo"
				);
		}else{
			
			valorTotalPesquisa = extrato.getValorTotalPesquisa();
			
			fileExtrado = new DefaultStreamedContent(
					new ByteArrayInputStream(extrato.gerarExtrato(TipoExtrato.PDF)), 
					"application/pdf", 
					getNomeArquivo()
				);
		}

	}
	
	
	
	private String getNomeArquivo() {		
		return cliente.getNome().replace(" ", "-")
			+ "-"
			+ DateFormatUtils.format(dataInicial, "dd/MM/yyyy")
			+ "-"
			+ "A"
			+ "-"
			+DateFormatUtils.format(dataFinal, "dd/MM/yyyy")
			+ ".pdf";
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


	public BigDecimal getValorTotalPesquisa() {
		return valorTotalPesquisa;
	}


	public void setValorTotalPesquisa(BigDecimal valorTotalPesquisa) {
		this.valorTotalPesquisa = valorTotalPesquisa;
	}



	public StreamedContent getFileExtrado() {
		return fileExtrado;
	}



	public void setFileExtrado(StreamedContent fileExtrado) {
		this.fileExtrado = fileExtrado;
	}
}
