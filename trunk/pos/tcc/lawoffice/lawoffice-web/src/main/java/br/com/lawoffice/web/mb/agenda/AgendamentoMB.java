/**
 * 
 */
package br.com.lawoffice.web.mb.agenda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleModel;

import br.com.lawoffice.agenda.service.AgendaServiceLocal;
import br.com.lawoffice.dominio.Evento;
import br.com.lawoffice.web.mb.AutoCompleteMB;

/**
 * 
 * Manager Bean para página de /caixa/credito.xhtml
 * 
 * @author rduarte
 *
 *
 */

@ManagedBean
public class AgendamentoMB extends AutoCompleteMB{

	
	private ScheduleModel scheduleModel;
	
	@EJB
	private AgendaServiceLocal agendaService;
	
	
	@PostConstruct
	public void init(){
		
		scheduleModel = new LazyScheduleModel(){

			@Override
			public void loadEvents(Date start, Date end) {
			
				List<DefaultScheduleEvent> listDefaultScheduleEvents =
					getDefaultScheduleEvents(start,end);
				
				for (DefaultScheduleEvent defaultScheduleEvent : listDefaultScheduleEvents) {
					addEvent(defaultScheduleEvent);
				}

			}
			
		};
	}

	
	private List<DefaultScheduleEvent> getDefaultScheduleEvents(Date dataIncial, Date dataFinal) {
	
		
		
		
		
		// obtem o colaborador
		// algum serviço que retorna a lista e eventos
		// de evento para DefaultScheduleEvnet
		// add na lista
		
		
		List<Evento> listEventos = null;
		
		try {
			listEventos = agendaService.listarEventos(colaborador, dataIncial, dataFinal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		List<DefaultScheduleEvent> list = new ArrayList<DefaultScheduleEvent>();
		
		for (Evento evento : listEventos) {
			list.add(new DefaultScheduleEvent(evento.getTitulo(), evento.getDataIncial(), evento.getDataFinal()
					));
		}
		
	
		return list;
	}

	
	public ScheduleModel getScheduleModel() {
		return scheduleModel;
	}


	public void setScheduleModel(ScheduleModel scheduleModel) {
		this.scheduleModel = scheduleModel;
	}
	

}
