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
public class CaixaTransacaoMB extends BaseMB{
	
	/**
	 * Valor para debitar/creditar na {@link Conta} do {@link Cliente} ou do {@link Colaborador}
	 */
	protected BigDecimal valor;
	
	
	/**
	 * Serviço de caixa para realizar o debito
	 */
	@EJB
	protected CaixaLocal caixaLocal;
	
	
	/**
	 * Serviço de dados de {@link Pessoa} para realizar o autoComplete 
	 */
	@EJB
	private DadosPessoaLocal dadosPessoaLocal;
	
	
	/**
	 * {@link Cliente} selecionado para debitar/creditar em sua conta
	 */
	protected Cliente cliente;
	
	
	/**
	 * {@link Colaborador} selecionado para debitar/creditar em sua conta 
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
