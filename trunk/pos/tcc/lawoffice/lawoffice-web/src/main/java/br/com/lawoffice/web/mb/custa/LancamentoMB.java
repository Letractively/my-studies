package br.com.lawoffice.web.mb.custa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.lawoffice.custas.lancamento.LancamentoServiceLocal;
import br.com.lawoffice.dominio.Custa;
import br.com.lawoffice.web.mb.AutoCompleteMB;

/**
 * Manager Bean para página de /custas/lacamento.xhtml
 * 
 * @author robson
 *
 */
@ManagedBean
@ViewScoped 
public class LancamentoMB extends AutoCompleteMB {
	
	
	// >>>>>>> ATRIBUTOS DE DOMINIO <<<<<<<<<<<<
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
	private LancamentoServiceLocal lancamentoDeCusta;

	
	
	private Date dataLancamento;
	
	
	// >>>>>>>>>>>  ATRIBUTOS PARA MONTAGEM DA VIEW <<<<<<<<<<<<<<<
	
	/**
	 * Custas adicionadas para efetuar o lançamento ( montagem da tabela )
	 */
	private List<Custa> custas;
	
	
	
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
				colaborador,
				dataLancamento
			)
		);
		custa = new Custa();	
	}
	

	public void removerCusta(){		
		if(custaSelecionada != null){
			lancamentoDeCusta.removerCusta(custaSelecionada);
			custas.remove(custaSelecionada);
		}			
	}
	

	
	public void fecharLancamento(){
		try {
			lancamentoDeCusta.fecharLacamento();
			custas.clear();
			addMsgInformacao(
				null, 
				null, 
				"Lançamento fechado com sucesso."
			);
		} catch (IllegalStateException e){
			adicionarMensagemErro(null, null, e.getMessage());
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


	public Date getDataLancamento() {
		return dataLancamento;
	}


	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
}
