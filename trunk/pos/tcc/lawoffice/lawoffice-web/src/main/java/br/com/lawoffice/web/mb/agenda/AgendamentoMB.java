/**
 * 
 */
package br.com.lawoffice.web.mb.agenda;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

/**
 * 
 * Manager Bean para página de /caixa/credito.xhtml
 * 
 * @author rduarte
 *
 *
 */

@ManagedBean
public class AgendamentoMB {

	
	private ScheduleModel scheduleModel;
	
	
	@PostConstruct
	public void init(){
		
		scheduleModel = new DefaultScheduleModel();
		
		scheduleModel.addEvent(new DefaultScheduleEvent("temp", new Date(), new Date()));
	}


	public ScheduleModel getScheduleModel() {
		return scheduleModel;
	}


	public void setScheduleModel(ScheduleModel scheduleModel) {
		this.scheduleModel = scheduleModel;
	}
	

}
