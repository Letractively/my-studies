/**
 * 
 */
package br.com.lawoffice.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * Representa um laçamento para o colaborador/cliente
 * 
 * @author robson
 *
 */
@Entity
@Table(name="LANCAMENTO")
public class Lancamento{

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="CLIENTE_ID")
	private Cliente cliente;
	
	
	@ManyToOne
	@JoinColumn(name="COLABORADOR_ID")
	private Colaborador colaborador;
	
	
	@Column(name="DATA_LANCAMENTO")
	@Temporal(TemporalType.DATE)
	private Date dataLancamento;
	
	
	@OneToMany(mappedBy="lancamento", cascade = CascadeType.ALL)
	private List<Custa> custas;
	
	
	
	// >>>>>>> GETS E SETS <<<<<<<<<<<

	
	public Cliente getCliente() {
		return cliente;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Date getDataLancamento() {
		return dataLancamento;
	}


	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}


	public List<Custa> getCustas() {
		return custas;
	}


	public void setCustas(List<Custa> custas) {
		this.custas = custas;
	}

	
	// >>>>>>>> MÉTODOS DE DOMINIO <<<<<<<<<<<<<<
	
	// TODO; para o método que recebe parametros abaixo
	// a necessidade de refatorar para validar os mesmo
	// como estou com débito técnico com beans validation
	// vamos refatorar após fechar o débito técnico
	public Lancamento adicionarCliente(Cliente cliente) {
		setCliente(cliente);
		return this;
	}


	public Lancamento adicionarColaborador(Colaborador colaborador){
		setColaborador(colaborador);
		return this;
	}	
	
	
	public Lancamento adicionarDataLancamento(){
		setDataLancamento(new Date());
		return this;
	}

	
	public Lancamento addCusta(Custa custa){
		if(custas == null)
			custas = new ArrayList<Custa>();
		custas.add(custa);
		return this;
	}
	
	
	/**
	 * Retorna o total do lançamento.
	 * <br><br>
	 * <b>Obs:</b> Se não houver nenhuma custa retorna um {@link BigDecimal} com valor 0.0
	 * 
	 * @return {@link BigDecimal}
	 */
	public BigDecimal getTotal(){
		BigDecimal total = new BigDecimal(0.0);
		if(custas == null || custas.isEmpty())
			return total;
		
		for (Custa custa : custas)
			total = total.add(custa.getValor());
		
		return total;
	}

}
