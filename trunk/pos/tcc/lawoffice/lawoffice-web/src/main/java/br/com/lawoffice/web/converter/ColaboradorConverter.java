/**
 * 
 */
package br.com.lawoffice.web.converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.lang.math.NumberUtils;

import br.com.lawoffice.dados.DadosLocal;
import br.com.lawoffice.dominio.Cliente;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Pessoa;

/**
 * TODO: terminar a programação conforme exemplo do prime faces
 * 
 * Faces Converter para o {@link Colaborador}
 * 
 * @author robson
 *
 */
@FacesConverter("colaboradorConverter")
public class ColaboradorConverter implements Converter {


	@EJB
	private DadosLocal dadosLocal;
	
	
	
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String colaboradorID) {
		
		try {
			Context context = new InitialContext();
			dadosLocal = (DadosLocal) context.lookup("lawoffice-ear/DadosBean/local");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(NumberUtils.isNumber(colaboradorID))		
			return dadosLocal.localizar(Colaborador.class, Long.valueOf(colaboradorID));
		else
			return null;
		
	}


	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object colaborador) {
		return ((Colaborador) colaborador).getId().toString();
	}

}
