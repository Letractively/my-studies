/**
 * 
 */
package br.com.studies.struts.helloword;

import org.apache.struts.action.ActionForm;

/**
 * @author rduarte
 *
 */
public class HelloWordActionForm extends ActionForm {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8517675426765876376L;
	
	
	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
