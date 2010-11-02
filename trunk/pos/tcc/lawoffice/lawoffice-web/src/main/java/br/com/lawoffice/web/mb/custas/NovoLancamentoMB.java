package br.com.lawoffice.web.mb.custas;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.web.mb.BaseMB;
import br.com.lowoffice.custas.LancamentoDeCusta;
import br.com.lowoffice.custas.LancamentoDeCustaBean;

/**
 * @author robson
 *
 * Manager Bean para página de /custos/novo-custo.xhtml
 *
 */
@ManagedBean()
@SessionScoped // TODO: @ViewScoped ? débito técnico 
public class NovoLancamentoMB extends BaseMB{
	
	// TODO: cdi ?
	private List<Custa> custas;

	// TODO: cdi ?
	private Custa custa;

	
	private List<Colaborador> colaboradores;
	

	private List<Cliente> clientes;
	
	
	// TODO: futuro ejb 3.1 !! debito técnico e fechamento das regras do serviço
	private LancamentoDeCusta lancamentoDeCusta;
	
	
	//TODO: e esse cara temos que ter mesmo ?
	@PostConstruct
	public void init(){
		custa = new Custa();
		custas = new ArrayList<Custa>();
		lancamentoDeCusta = new LancamentoDeCustaBean();
	}
	
	
	public void addCusta(){
		custa = new Custa();
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
	
}
