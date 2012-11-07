package br.com.estudos.jsf.ajax.mb;

import javax.faces.bean.ManagedBean;

/**
 * @author rduarte
 *
 */
@ManagedBean
public class OneventMB {

	private String name;
	
	public void upperCaseName()throws Exception{
		Thread.sleep(5000);
		setName(name.toUpperCase());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
