/**
 * 
 */
package br.com.lawoffice.web.temp;

import java.util.Date;

import org.primefaces.model.DefaultScheduleEvent;

/**
 * @author robson
 *
 */
public class EventoTemp extends DefaultScheduleEvent implements EventoX {

	
	private Long idEvento;
	

	
	public EventoTemp() {
		super();
	}


	public EventoTemp(Long idEvento, String title, Date start, Date end) {
		super(title, start, end, false);
		this.idEvento = idEvento;
	}

	
	@Override
	public String getNomeCliente() {
		return "Robson";
	}

	@Override
	public String getDescricaoEvento() {
		return "Descricao evento.";
	}


	@Override
	public Long getIdEvento() {
		return idEvento;
	}

}
