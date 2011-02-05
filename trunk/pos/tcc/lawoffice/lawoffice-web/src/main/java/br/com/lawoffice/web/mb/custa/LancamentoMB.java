package br.com.lawoffice.web.mb.custa;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.lawoffice.dados.DadosLocal;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.web.mb.AutoCompleteMB;
import br.com.lowoffice.custas.exception.LancamentoDeCustaException;
import br.com.lowoffice.custas.lancamento.LancamentoDeCustaLocal;

/**
 * @author robson
 *
 * Manager Bean para página de /custas/lacamento.xhtml
 *
 */
@ManagedBean()
@ViewScoped // TODO: @ViewScoped ? débito técnico 
public class LancamentoMB extends AutoCompleteMB {
	
	
	// >>>>>>> ATRIBUTOS DE DOMINIO <<<<<<<<<<<<
		
	// TODO: cdi ?
	/**
	 * {@link Custa} para adição/edicão/remoção da lista de custas 
	 */
	private Custa custa;
	
	
	/**
	 * {@link Custa} selecionada para edição e remoção do grid de custa na página
	 */
	private Custa custaSelecionada;
	
	
	/**
	 * Serviço de lançamentos de custas 
	 */
	@EJB
	private LancamentoDeCustaLocal lancamentoDeCusta;
	
	
	// >>>>>>>>>>>  ATRIBUTOS PARA MONTAGEM DA VIEW <<<<<<<<<<<<<<<
	
	
	// TODO: cdi ?
	/**
	 * Custas adicionadas para efetuar o lançamento ( montagem da tabela )
	 */
	private List<Custa> custas;
	
	
	
	//TODO: e esse cara temos que ter mesmo ?
	@PostConstruct
	public void init(){
		custa = new Custa();
		custas = new ArrayList<Custa>();
	}
	
	
	public void adicionarCusta(){		
		custas.add(
			lancamentoDeCusta.adicionarCusta(
				custa, 
				cliente,
				colaborador
			)
		);
		custa = new Custa();	
	}
	

	public void removerCusta(){
		try {
			if(custaSelecionada != null){
				lancamentoDeCusta.removerCusta(custaSelecionada);
				custas.remove(custaSelecionada);
			}				
		} catch (LancamentoDeCustaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	public void editarCusta(){
		if(custaSelecionada != null)
			custa = custaSelecionada;
	}
	
	
	
	
	// TODO: revisar o editar/remover
	// pelo que vi o editar não precisa de ter um serviço no ejb
	// vou tocado outros lances no projeto
	public void atualizarCusta(){
		
/*		try {

			lancamentoDeCusta.atualizarCusta(
					custa,
					getClienteSelecionado(),
					getColaboradorSelecionado()
				);*/
			
			custa = new Custa();
			
/*		} catch (LancamentoDeCustaException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}*/
	}


	
	public void fecharLancamento(){
		try {
			lancamentoDeCusta.fecharLacamento();
			custas.clear();
		} catch (LancamentoDeCustaException e){
			// TODO: 
			e.printStackTrace();
		}
	}


	// >>>>>>>> GETS E SETS DO MB <<<<<<<<<<<<<
	
	public Custa getCusta() {
		return custa;
	}

	public void setCusta(Custa custa) {
		this.custa = custa;
	}


	public Custa getCustaSelecionada() {
		return custaSelecionada;
	}


	public void setCustaSelecionada(Custa custaSelecionada) {
		this.custaSelecionada = custaSelecionada;
	}

	public List<Custa> getCustas() {
		return custas;
	}
	
	public void setCustas(List<Custa> custas) {
		this.custas = custas;
	}	

}
