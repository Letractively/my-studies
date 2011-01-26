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

import br.com.lawoffice.dados.DadosLocal;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.web.mb.BaseMB;

/**
 * 
 * Manager Bean para página de /dados/colaborador.xhtml
 * 
 * @author rduarte
 *
 */
@ManagedBean
@ViewScoped
public class DadosColaboradorMB extends BaseMB {

	
	/**
	 * Colaborador para adicionar/remover/editar 
	 */
	private Colaborador colaborador;
	
	
	/**
	 * Colaborador selecionado na lista de cliente da página ( grid ) 
	 */
	private Colaborador colaboradorSelecionado;
	
	
	/**
	 * Lista de Colaboradores cadastrado no sistema
	 */
	private List<Colaborador> listColaboradores;
	
	
	/**
	 * 
	 * Serviço de cadastro de dados
	 * 
	 */
	@EJB
	private DadosLocal dadosLocal;
	
	
	@PostConstruct
	public void init(){
		listarColaboradores();
	}
	
	
	public void adicionarColaborador(){
		dadosLocal.salvar(colaborador);
		listarColaboradores();
	}
	
	
	public void atualizarColaborador(){
		dadosLocal.atualizar(colaborador);
	}
	
	
	public void removerColaborador(){
		if(colaboradorSelecionado != null){
			dadosLocal.remover(Colaborador.class, colaboradorSelecionado.getId());
			listarColaboradores();
		}			
	}
	
	
	// TODO: problemas na edição na página
	// quando clica no btn de editar e não tem ninguém
	// selecionado a página de cadastro é exibida
	// e isso não pode ocorrer , analisar como podemos bloquear isso
	// existe um onerror mas não funcionou então vamos estudar com 
	// mais calma isso ficando como todo
	public void editarColaborador(){
		if(colaboradorSelecionado != null)
			colaborador = colaboradorSelecionado;
	}
	
	
	public void novoColaborador(){
		colaborador = new Colaborador();
		Conta conta = new Conta();
		conta.setSaldo(new BigDecimal(0.0));
		colaborador.setConta(conta);
		conta.setColaborador(colaborador);// TODO: fornecer um método de criação conforme java efetivo ( livro )
	}
	
	
	private void listarColaboradores() {
		listColaboradores = dadosLocal.listar(Colaborador.class);
	}

	
	
	
    // >>>>>>> GETS E SETS do MB <<<<<<<<<<<<<
	
	public Colaborador getColaborador() {
		return colaborador;
	}


	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}


	public Colaborador getColaboradorSelecionado() {
		return colaboradorSelecionado;
	}


	public void setColaboradorSelecionado(Colaborador colaboradorSelecionado) {
		this.colaboradorSelecionado = colaboradorSelecionado;
	}


	public List<Colaborador> getListColaboradores() {
		return listColaboradores;
	}


	public void setListColaboradores(List<Colaborador> listColaboradores) {
		this.listColaboradores = listColaboradores;
	}	

}
