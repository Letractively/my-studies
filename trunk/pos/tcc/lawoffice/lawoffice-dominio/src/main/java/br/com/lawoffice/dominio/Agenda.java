/**
 * 
 */
package br.com.lawoffice.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * Representa a agenda de compromisso do {@link Colaborador} do escritório.
 * 
 * @author robson
 *
 */
@Entity
@Table(name="AGENDA")
public class Agenda implements EntityBase {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	
	@OneToOne()
	@JoinColumn(name="COLABORADOR_ID")
	private Colaborador colaborador;
	
	
	@OneToMany(mappedBy="agenda")
	private List<Evento> listEventos;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Colaborador getColaborador() {
		return colaborador;
	}


	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}


	public List<Evento> getListEventos() {
		return listEventos;
	}


	public void setListEventos(List<Evento> listEventos) {
		this.listEventos = listEventos;
	}
}
