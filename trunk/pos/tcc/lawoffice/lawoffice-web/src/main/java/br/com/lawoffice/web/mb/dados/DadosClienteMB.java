/**
 * 
 */
package br.com.lawoffice.web.mb.dados;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.lawoffice.dados.PessoaServiceLocal;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.dominio.Pessoa;
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
	 * Cliente para adicionar/remover/editar 
	 */
	private Cliente cliente;
	
	
	/**
	 * Cliente selecionado na lista de cliente da página ( grid ) 
	 */
	private Cliente clienteSelecionado;
	
	
	/**
	 * Lista de Clientes cadastrado no sistema
	 */
	private List<Cliente> listClientes;
	
	
	/**
	 * Serviço de dados para {@link Pessoa} que estao no dominio do escritorio.
	 */
	@EJB
	private PessoaServiceLocal pessoaServiceLocal;
	
	
	@PostConstruct
	public void init(){
		listarClientes();
		cliente = new Cliente();
	}
	
	
	public void adicionarCliente(){
		pessoaServiceLocal.salvar(cliente);
		listarClientes();
	}
	
	
	public void atualizarCliente(){
		pessoaServiceLocal.atualizar(cliente);
	}
	
	
	
	public void removerCliente(){
		if(clienteSelecionado != null){			
			pessoaServiceLocal.remover(Cliente.class,clienteSelecionado);
			listarClientes();
		}			
	}
	
	
	public void editarCliente(){
		if(clienteSelecionado != null)
			cliente = clienteSelecionado;
	}
	
	
	
	// TODO: fornecer um método de criação conforme java efetivo ( livro )
	public void novoCliente(){
		cliente = new Cliente();  
		Conta conta = new Conta();
		conta.setSaldo(new BigDecimal(0.0));
		cliente.setConta(conta);
		conta.setCliente(cliente);
	}
	
	
	private void listarClientes() {
		listClientes = pessoaServiceLocal.listar(Cliente.class);
	}


    // >>>>>>> GETS E SETS do MB <<<<<<<<<<<<<	
	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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