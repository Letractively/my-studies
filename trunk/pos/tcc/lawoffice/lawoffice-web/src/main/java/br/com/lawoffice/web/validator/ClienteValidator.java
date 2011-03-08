/**
 * 
 */
package br.com.lawoffice.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author rduarte
 *
 */
@FacesValidator("clienteValidator")
public class ClienteValidator implements Validator {


	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object cliente) throws ValidatorException {
		if(cliente == null){	
			throw new ValidatorException(
				 new FacesMessage(
							FacesMessage.SEVERITY_ERROR, 
							"Existem campos obrigatórios sem preenchimento..: ", 
							"O Cliente é obrigatório" // TODO: internacionlização no livro jsf tem um esquema ver em bundles ( para todo validators )
				));
		}
	}
}
