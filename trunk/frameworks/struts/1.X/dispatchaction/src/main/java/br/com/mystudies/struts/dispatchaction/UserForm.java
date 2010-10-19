/**
 * 
 */
package br.com.mystudies.struts.dispatchaction;

import org.apache.struts.action.ActionForm;

/**
 * @author rduarte
 *
 */
public class UserForm extends ActionForm{
	
	private static final long serialVersionUID = 170668537510415979L;
	
	
	private String message;

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
