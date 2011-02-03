package br.com.lawoffice.web.mb.caixa;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;

import br.com.lawoffice.caixa.CaixaLocal;
import br.com.lawoffice.dados.DadosPessoaLocal;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Conta;
import br.com.lawoffice.dominio.Pessoa;
import br.com.lawoffice.web.mb.BaseMB;

/**
 * 
 * Manager Bean base para os manager bean que realizam operações de transação de caixa
 * 
 * @author robson
 *
 * @see {@link DebitoMB} {@link CreditoMB}
 *
 */
public class CaixaBaseMB extends BaseMB{
	
	
	/**
	 * Serviço de dados de {@link Pessoa} para realizar o autoComplete 
	 */
	@EJB
	private DadosPessoaLocal dadosPessoaLocal;
	
	
	/**
	 * {@link Cliente} selecionado no autocomplete
	 */
	protected Cliente cliente;
	
	
	/**
	 * {@link Colaborador} selecionado no autocomplete 
	 */
	protected Colaborador colaborador;
	
	
	
	public List<Cliente> listarClientes(String query){
		return dadosPessoaLocal.listarPorNome(Cliente.class, query); 
	}
	
	public List<Colaborador> listarColaboradores(String query){
		return dadosPessoaLocal.listarPorNome(Colaborador.class, query); 
	}
	

	// >>>>>>> GETS & SETS <<<<<<<<<<<
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}	
	
}
