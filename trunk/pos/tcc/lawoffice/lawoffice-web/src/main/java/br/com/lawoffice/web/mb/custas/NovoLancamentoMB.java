package br.com.lawoffice.web.mb.custas;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.web.mb.BaseMB;
import br.com.lowoffice.custas.LancamentoDeCusta;
import br.com.lowoffice.custas.LancamentoDeCustaBean;
import br.com.lowoffice.custas.LancamentoDeCustaLocal;
import br.com.lowoffice.custas.exception.LacamentoDeCustaException;

/**
 * @author robson
 *
 * Manager Bean para página de /custas/novo-lacamento.xhtml
 *
 */
@ManagedBean()
@SessionScoped // TODO: @ViewScoped ? débito técnico 
public class NovoLancamentoMB extends BaseMB{
	
	
	// >>>>>>> ATRIBUTOS DE DOMINIO <<<<<<<<<<<<
		
	// TODO: cdi ?
	/**
	 * Custa para adição de custas 
	 */
	private Custa custa;
	
	/**
	 * Colaborador selecionada na view para para adcionar nova custa 
	 */
	private Colaborador colaborador;
	
	
	/**
	 * Cliente selecionada na view para para adcionar nova custa 
	 */	
	private Cliente cliente;
	
	

	/**
	 * Serviço de lançamentos de custas 
	 */
	@EJB
	private LancamentoDeCustaLocal lancamentoDeCusta;
	
	
	
	// >>>>>>>>>>>  ATRIBUTOS PARA MONTAGEM DA VIEW <<<<<<<<<<<<<<<
	
	/**
	 * 
	 * Colaboradores cadastrados no  sistema
	 * 
	 */
	private List<Colaborador> colaboradores;
	

	/**
	 * 
	 * Clientes cadastrados no sistema
	 * 
	 */
	private List<Cliente> clientes;
	
	// TODO: cdi ?
	/**
	 * Custas adicionadas ( montagem da tabela )
	 */
	private List<Custa> custas;
	
	
	
	//TODO: e esse cara temos que ter mesmo ?
	@PostConstruct
	public void init(){
		custa = new Custa();
		custas = new ArrayList<Custa>();
		colaborador = new Colaborador();
		cliente = new Cliente();
	}
	
	
	
	public void addCusta(){		
		custa = lancamentoDeCusta.adicionarCusta(custa, cliente, colaborador);
		custas.add(custa);
		custa = new Custa();
		
		// TODO: esses tem que ser selecionado direto na página via componente que vamos construir
		colaborador = new Colaborador();
		cliente = new Cliente();
	}
	
	
	
	public void fecharLancamento(){
		try {
			lancamentoDeCusta.fecharLacamento();
			custas.clear();
		} catch (LacamentoDeCustaException e){
			// TODO: 
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// gets e sets ...
	public Custa getCusta() {
		return custa;
	}


	public void setCusta(Custa custa) {
		this.custa = custa;
	}


	public List<Custa> getCustas() {
		return custas;
	}

	public void setCustas(List<Custa> custas) {
		this.custas = custas;
	}


	
	// 
	public List<Colaborador> getColaboradores() {
		colaboradores = new ArrayList<Colaborador>();
		colaboradores.add(new Colaborador(1 , "Adv 1"));
		colaboradores.add(new Colaborador(2 , "Adv 2"));
		colaboradores.add(new Colaborador(3 , "Adv 3"));
		colaboradores.add(new Colaborador(4 , "Adv 4"));
		return colaboradores;
	}


	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}


	public List<Cliente> getClientes() {
		clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente(1, "Robson"));
		clientes.add(new Cliente(2, "Robson"));
		clientes.add(new Cliente(3, "Robson"));
		clientes.add(new Cliente(4, "Robson"));		
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}



	public Colaborador getColaborador() {
		return colaborador;
	}



	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
