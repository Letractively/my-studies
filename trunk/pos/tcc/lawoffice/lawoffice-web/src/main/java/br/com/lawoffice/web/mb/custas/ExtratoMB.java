package br.com.lawoffice.web.mb.custas;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.lawoffice.dados.DadosLocal;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.web.mb.BaseMB;
import br.com.lowoffice.custas.extrato.ExtratoLocal;

/**
 * 
 * @author robson
 * 
 * Manager Bean para página de /custas/lacamentos.xhtml
 *
 */
@ManagedBean
@ViewScoped
public class ExtratoMB extends BaseMB{


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
	 * serviços de custas
	 */
	@EJB
	private ExtratoLocal custas;
	
	
	/**
	 * Serviço de dados ( CRUD ) 
	 */
	@EJB
	private DadosLocal dados;
	
	
	// >>>>>>>>>>>  ATRIBUTOS PARA MONTAGEM DA VIEW <<<<<<<<<<<<<<<
	
	/**
	 * 
	 * Clientes cadastrados no sistema
	 * 
	 */
	private List<Cliente> clientes;

	
	
	
	//TODO: e esse cara temos que ter mesmo ?
	@PostConstruct
	public void init(){
		clientes = dados.listar(Cliente.class);
	}
	
	
	
	public void pesquisarLancamentos(){			
		listaCustas = custas.getCustasPorDataCliente(dataInicial, dataFinal, clienteID);
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



	public List<Cliente> getClientes() {
		return clientes;
	}



	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
