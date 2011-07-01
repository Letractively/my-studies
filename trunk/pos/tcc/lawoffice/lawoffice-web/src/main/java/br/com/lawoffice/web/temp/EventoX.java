/**
 * 
 */
package br.com.lawoffice.web.temp;

import org.primefaces.model.ScheduleEvent;

/**
 * @author robson
 *
 */
public interface EventoX extends ScheduleEvent {

	
	Long getIdEvento();
	
	String getNomeCliente();
	
	String getDescricaoEvento();
}
