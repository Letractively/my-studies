/**
 * 
 */
package br.com.lowoffice.custas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.lawoffice.dominio.Custa;

/**
 * 
 * Implementação para o serviço de Custas
 * 
 * 
 * @author robson
 * @see Custas
 *
 */
public class CustasBean implements Custas {


	@Override
	public List<Custa> getCustas(Map<String, Object> filter){
		if(filter == null)
			throw new IllegalArgumentException("filter esta nulo");
		if(filter.isEmpty())
			return new ArrayList<Custa>();
		
		return null;
	}

}
