package br.com.lawoffice.web.mb.custas;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.lawoffice.dominio.Custa;
import br.com.lowoffice.custas.LancamentoDeCusta;
import br.com.lowoffice.custas.LancamentoDeCustaMock;

/**
 * @author robson
 *
 * Manager Bean para página de /custos/novo-custo.xhtml
 *
 */
@ManagedBean()
@SessionScoped // TODO: @ViewScoped ? débito técnico 
public class NovoLancamentoMB{
	
	// TODO: cdi ?
	private List<Custa> custas;

	// TODO: cdi ?
	private Custa custa;
	
	// TODO: hoje o combo está fixo, e outra , ainda não sei se realemente vai ser um combo então fica essa cara
	// temporário para realizar a validação com o carlos do primeiro sprint....
	private String nomeColaborador;
	
	// TODO: idem ao cara de cima
	private String nomeCliente;
	
	
	// TODO: futuro ejb 3.1 !! debito técnico e fechamento das regras do serviço
	private LancamentoDeCusta lancamentoDeCusta;
	
	
	//TODO: e esse cara temos que ter mesmo ?
	@PostConstruct
	public void init(){
		custa = new Custa();
		custas = new ArrayList<Custa>();
		lancamentoDeCusta = new LancamentoDeCustaMock();
		System.out.println("init");
	}
	
	
	public void addCusta(){		
		custas.add(
				lancamentoDeCusta.addCusta(custa, nomeCliente, nomeColaborador)
			);
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



	public String getNomeColaborador() {
		return nomeColaborador;
	}



	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}



	public String getNomeCliente() {
		return nomeCliente;
	}



	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
}
