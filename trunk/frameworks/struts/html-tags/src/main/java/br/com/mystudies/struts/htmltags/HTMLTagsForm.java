/**
 * 
 */
package br.com.mystudies.struts.htmltags;

import org.apache.struts.action.ActionForm;

/**
 * @author rduarte
 *
 */
public class HTMLTagsForm extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String sexo;

	/**
	 * Metodo get do atributo sexo.
	 *
	 * @return sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * Metodo set do atributo sexo.
	 *
	 * @param sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
