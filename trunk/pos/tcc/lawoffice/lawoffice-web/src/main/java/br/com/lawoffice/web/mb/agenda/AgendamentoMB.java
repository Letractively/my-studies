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
import org.primefaces.event.ScheduleEntrySelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import br.com.lawoffice.agenda.service.AgendaServiceLocal;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Evento;
import br.com.lawoffice.web.mb.AutoCompleteMB;
import br.com.lawoffice.web.temp.EventoTemp;
import br.com.lawoffice.web.temp.EventoX;

/**
 * 
 * Manager Bean para página de /caixa/credito.xhtml
 * 
 * @author rduarte
 *
 */

@ManagedBean
@ViewScoped
public class AgendamentoMB extends AutoCompleteMB{

	
	/**
	 * 
	 */
	private ScheduleModel scheduleModel;
	
	
	
	
	
	private EventoX evento;
	
	
	
	
	
	
	@EJB
	private AgendaServiceLocal agendaService;
	
	
	
	
	
	
	@PostConstruct
	public void init(){
		
		scheduleModel = new LazyScheduleModel(){

			@Override
			public void loadEvents(Date start, Date end) {
			
				List<EventoTemp> enventos =
					getEventos(start,end);
				
				for (EventoTemp evento : enventos) {
					addEvent(evento);
				}
			}
		};
		
		evento = new EventoTemp();
	}

	
	
	
	private List<EventoTemp> getEventos(Date dataIncial, Date dataFinal) {
	
		
		Colaborador c = new Colaborador();
		c.setId(1L);
		
		List<Evento> listEventos = null;
		
		try {
			listEventos = agendaService.listarEventos(c, dataIncial, dataFinal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		List<EventoTemp> eventos = new ArrayList<EventoTemp>();
		
		
		for (Evento evento : listEventos) {
			eventos.add(
				new EventoTemp(	
					evento.getId(),	
					evento.getTitulo(), 
					evento.getDataIncial(), 
					evento.getDataFinal()
				)
			);
		}
		return eventos;
	}

	
	
	
	
	
	
	
	
	
    public void onSelectData(DateSelectEvent dateSelectEvent) {    	
    	evento = new EventoTemp(null, null, dateSelectEvent.getDate(), dateSelectEvent.getDate());
        /*event = new DefaultScheduleEvent(Math.random() + "", selectEvent.getDate(), selectEvent.getDate());  */
    }  
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void onMoveEvento(ScheduleEntryMoveEvent scheduleEntryMoveEvent) {
    	
/*        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());  
          
        addMessage(message);  */
    }  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	   
	public void onSelectEvento(ScheduleEntrySelectEvent selectEvent) {
		evento = (EventoX) selectEvent.getScheduleEvent();
    } 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void salvarEvento(ActionEvent event){
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ScheduleModel getScheduleModel() {
		return scheduleModel;
	}


	public void setScheduleModel(ScheduleModel scheduleModel) {
		this.scheduleModel = scheduleModel;
	}



	public EventoX getEvento() {
		return evento;
	}


	public void setEvento(EventoX evento) {
		this.evento = evento;
	}
}
