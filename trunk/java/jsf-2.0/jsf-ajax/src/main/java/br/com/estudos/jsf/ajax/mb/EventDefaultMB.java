package br.com.estudos.jsf.ajax.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

/**
 * @author rduarte
 *
 */
@ManagedBean
public class EventDefaultMB {
	
	private String youIs;
	
	public void soccerTimeChoose(ValueChangeEvent event){
		if(event.getNewValue().equals("Corinthians"))
			setYouIs("Man");
		else if(event.getNewValue().equals("Santos"))
			setYouIs("Mermaid");
		else if(event.getNewValue().equals("Palmeiras"))
			setYouIs("Pig");
		else if(event.getNewValue().equals("São Paulo"))
			setYouIs("Bambi");
	}

	public String getYouIs() {
		return youIs;
	}

	public void setYouIs(String youIs) {
		this.youIs = youIs;
	}
	
}
