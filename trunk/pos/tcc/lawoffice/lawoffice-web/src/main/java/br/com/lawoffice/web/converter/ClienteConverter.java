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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import br.com.lawoffice.dados.DadosLocal;
import br.com.lawoffice.dominio.Cliente;

/**
 * 
 * TODO: terminar a programação conforme exemplo do prime faces
 * 
 * Faces Converter para o {@link Cliente}
 * 
 * @author robson
 *
 */
@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter {


	@EJB
	private DadosLocal dadosLocal;
	
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String clienteID) {
		  
		try {
			Context context = new InitialContext();
			dadosLocal = (DadosLocal) context.lookup("lawoffice-ear/DadosBean/local");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(NumberUtils.isNumber(clienteID))		
			return dadosLocal.localizar(Cliente.class, Long.valueOf(clienteID));
		else
			return null;
		
	}


	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return ((Cliente) arg2).getId().toString();
	}

}
