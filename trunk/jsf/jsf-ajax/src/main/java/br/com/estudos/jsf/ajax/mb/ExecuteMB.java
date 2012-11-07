package br.com.estudos.jsf.ajax.mb;

import javax.faces.bean.ManagedBean;

/**
 * @author rduarte
 *
 */
@ManagedBean
public class ExecuteMB {

	private String name;


	public void upperCaseName(){
		setName(name.toUpperCase());
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
