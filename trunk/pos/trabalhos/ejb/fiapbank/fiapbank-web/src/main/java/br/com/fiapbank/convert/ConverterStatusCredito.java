/**
 * 
 */
package br.com.fiapbank.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.fiapbank.dominio.entidade.StatusCredito;

/**
 * @author robson.oliveira
 *
 */
public class ConverterStatusCredito implements Converter {


	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (value.equals("Aprovado"))
			return StatusCredito.APROVADO;
		else if (value.equals("Rejeitado"))
			return StatusCredito.REJEITADO;		
		else
			return StatusCredito.SUJEITO_A_APROVACAO;
	}


	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		
		StatusCredito sc = Enum.valueOf(StatusCredito.class, value.toString());
		
		switch (sc) {
			case APROVADO:
				return "Aprovado";
			case REJEITADO:
				return "Rejeitado";				
			default:
				return "Sujeito a Aprovacao";
		}
	}
}
