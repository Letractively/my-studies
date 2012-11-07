/**
 * 
 */
package br.com.estudos.jsf.ajax.mb;

import java.util.Date;

import javax.faces.bean.ManagedBean;

/**
 * @author rduarte
 */
@ManagedBean
public class RenderMB {

	private Date date;
	
	public void getDateNow(){
		setDateNow(new Date());
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDateNow(Date dateNow) {
		this.date = dateNow;
	}
}
