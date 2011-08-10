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
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.ScheduleEntrySelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import br.com.lawoffice.agenda.service.AgendaServiceLocal;
import br.com.lawoffice.dominio.Agenda;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Evento;
import br.com.lawoffice.web.mb.AutoCompleteMB;

/**
 * 
 * Manager Bean para página de /caixa/credito.xhtml
 * 
 * @author rduarte
 *
 */

@ManagedBean
@ViewScoped
public class AgendaMB extends AutoCompleteMB{

	
	/**
	 * 
	 */
	private ScheduleModel scheduleModel;
	
	
	
	
	@EJB
	private AgendaServiceLocal agendaService;
	
	

	
	private EventoAdapter eventoAdapter;
	
	
	
	@PostConstruct
	public void init(){
		
		scheduleModel = new LazyScheduleModel(){

			@Override
			public void loadEvents(Date start, Date end) {
			
				List<DefaultScheduleEvent> scheduleEvents =
					getEventos(start,end);
				
				for (DefaultScheduleEvent defaultScheduleEvent : scheduleEvents) {
					addEvent(defaultScheduleEvent);
				}
			}
		};
		
		/*evento = new EventoTemp();*/
	}

	
	
	
	private List<DefaultScheduleEvent> getEventos(Date dataIncial, Date dataFinal) {
	
		
		Colaborador c = new Colaborador();
		c.setId(3L);
		
		List<Evento> listEventos = null;
		
		try {
			listEventos = agendaService.listarEventos(c, dataIncial, dataFinal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		List<DefaultScheduleEvent> eventos = 
				new ArrayList<DefaultScheduleEvent>();
		
		
		for (Evento evento : listEventos) {
			
				eventos.add(
					new EventoAdapter(
						evento.getTitulo(), 
						evento.getDataIncial(), 
						evento.getDataFinal(), 
						false,
						evento.getId()
					)
				);
		}
		return eventos;
	}

	
	
	
	
	
	
    public void onDataSelecionada(DateSelectEvent dateSelectEvent) {
    	eventoAdapter = 
    		new EventoAdapter(
    				null, 
    				dateSelectEvent.getDate(), 
    				dateSelectEvent.getDate(), 
    				false, 
    				null
    			);
    }  
 
	
	
	
	   
	public void onEventoSelecionado(ScheduleEntrySelectEvent selectEvent) {
		eventoAdapter = 
			(EventoAdapter) selectEvent.getScheduleEvent();
    } 
	
	
	
	
	public void onEventoMovido(ScheduleEntryMoveEvent event) {
		
		System.out.println(event);
		
/*        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());  
          
        addMessage(message);  */
    }  
    
	
	
    public void onEventoRedimensionado(ScheduleEntryResizeEvent event) {
    	
    	System.out.println(event);
    	
    	
/*        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());  
          
        addMessage(message);  */
    }	
	
	
	
	
	
	
	
	public void salvarEvento(){
		
		Colaborador c = new Colaborador();
		c.setId(3l);
		
		Agenda g = new Agenda();
		g.setId(2L);
		
		c.setAgenda(g);
		Evento e = 
				eventoAdapter.getEvento();
		
		if(e.getId() == null){
			agendaService.atualizarEvento(e);
		}else{
			agendaService.adicionarEvento(c, eventoAdapter.getEvento());
		}
		
	}
	
	
	
	
	
	
	/**
	 * 
	 * Evento adpater para o {@link Evento} com o {@link ScheduleEvent} do prime faces. 
	 * 
	 * @author rduarte
	 *
	 */
	public class EventoAdapter extends DefaultScheduleEvent{
		
		public Long idEvento;
		

		public EventoAdapter(String title, Date start, Date end, boolean allDay, Long idEvento) {
			super(title, start, end, allDay);
			this.idEvento = idEvento;		
		}


		public Evento getEvento() {
			Evento evento = 
				new Evento(
					getTitle(), 
					getStartDate(), 
					getEndDate()
				);
			
			evento.setId(getIdEvento());
			
			return evento; 
		}


		public Long getIdEvento() {
			return idEvento;
		}



		public void setIdEvento(Long idEvento) {
			this.idEvento = idEvento;
		}

		
	}
	

	
	
	
	
	
	
	//////////////////////////////////////////////
	
	
	
	public ScheduleModel getScheduleModel() {
		return scheduleModel;
	}


	public void setScheduleModel(ScheduleModel scheduleModel) {
		this.scheduleModel = scheduleModel;
	}




	public EventoAdapter getEventoAdapter() {
		return eventoAdapter;
	}


	public void setEventoAdapter(EventoAdapter eventoAdapter) {
		this.eventoAdapter = eventoAdapter;
	}

}
