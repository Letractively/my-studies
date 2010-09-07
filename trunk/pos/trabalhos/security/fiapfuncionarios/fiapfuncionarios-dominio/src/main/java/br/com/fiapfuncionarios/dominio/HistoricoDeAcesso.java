/**
 * 
 */
package br.com.fiapfuncionarios.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author robson
 *
 */
@Entity
@Table(name="HISTORICO_DE_ACESSO")
public class HistoricoDeAcesso {
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	
	@ManyToOne()
	@JoinColumn(name="FUNCIONARIO_ID")
	private Funcionario funcionario;
	
	@Column(name="DATA_DE_ACESSO")
	@Temporal(TemporalType.DATE)
	private Date dataDeAcesso;
	
	@Temporal(TemporalType.TIME)
	@Column(name="HORA_DE_ACESSO")
	private Date horaDeAcesso;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataDeAcesso() {
		return dataDeAcesso;
	}

	public void setDataDeAcesso(Date dataDeAcesso) {
		this.dataDeAcesso = dataDeAcesso;
	}

	public Date getHoraDeAcesso() {
		return horaDeAcesso;
	}

	public void setHoraDeAcesso(Date horaDeAcesso) {
		this.horaDeAcesso = horaDeAcesso;
	}
	
}
