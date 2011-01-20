/**
 * 
 */
package br.com.lawoffice.web.dados.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.resource.spi.IllegalStateException;

import br.com.lawoffice.dados.DadosLocal;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.web.mb.BaseMB;

/**
 * 
 * Manager Bean para página de /dados/cliente.xhtml
 * 
 * @author rduarte
 *
 */
@ManagedBean
@ViewScoped
public class DadosClienteMB extends BaseMB {

	
	/**
	 * Cliente para adcionar/remover/editar 
	 */
	private Cliente cliente;
	
	
	/**
	 * Cliente selecionado na lista de cliente da página 
	 */
	private Cliente clienteSelecionado;
	
	
	/**
	 * Lista de Clientes cadastrado no sistema
	 */
	private List<Cliente> listClientes;
	
	
	/**
	 * 
	 * Serviço de cadastro de dados
	 * 
	 */
	@EJB
	private DadosLocal dadosLocal;
	
	
	@PostConstruct
	public void init(){
		cliente = new Cliente();
		listarClientes();
	}
	
	
	public void adicionarCliente(){
		dadosLocal.salvar(cliente);
		listarClientes();
	}
	
	
	public void atualizarCliente(){
		dadosLocal.atualizar(cliente);
	}
	
	
	public void removerCliente(){
		if(clienteSelecionado != null){
			dadosLocal.remover(Cliente.class, clienteSelecionado.getId());
			listarClientes();
		}			
	}
	
	public void editarCliente(){
		if(clienteSelecionado != null)
			cliente = clienteSelecionado;
		else
			throw new IllegalArgumentException();// TODO: test
	}
	
	public void novoCliente(){
		cliente = new Cliente();
	}
	
	
	private void listarClientes() {
		listClientes = dadosLocal.listar(Cliente.class);
	}
	

	
	
	
	
	
    // >>>>>>> GETS E SETS do MB <<<<<<<<<<<<<
	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente clienteNovo) {
		this.cliente = clienteNovo;
	}


	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}


	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}


	public List<Cliente> getListClientes() {
		return listClientes;
	}


	public void setListClientes(List<Cliente> listClientes) {
		this.listClientes = listClientes;
	}	
	
  
}
