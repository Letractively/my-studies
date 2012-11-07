package br.com.estudos.jsf.ajax.mb;

import javax.faces.bean.ManagedBean;

/**
 * @author rduarte
 *
 */
@ManagedBean
public class ExecuteFormMB {
	
	private String firstName;
	 
	private String lastName;

	private String fullName;
	
	
	public void upperCaseFullName(){
		setFullName(
				firstName.toUpperCase() + 
				" " + 
				lastName.toUpperCase()
			);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firsName) {
		this.firstName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
