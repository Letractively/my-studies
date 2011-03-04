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
import javax.validation.ValidationException;

/**
 * @author rduarte
 *
 */
@FacesValidator("valorValidator")
public class ValorValidator implements Validator {


	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object valor) throws ValidatorException {
		System.out.println(valor);
	}
}
