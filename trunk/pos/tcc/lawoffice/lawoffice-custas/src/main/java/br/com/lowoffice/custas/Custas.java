package br.com.lowoffice.custas;

import java.util.List;
import java.util.Map;

import br.com.lawoffice.dominio.Custa;


/**
 * Interface para o serviço de consulta e report de Lançamentos de custas
 * 
 * @author robson
 *
 */
public interface Custas{
	
	
	//TODO: documentar os valores do filtro
	/**
	 *
	 * 
	 * @param filter - mapa com o valores que serão utilizado no filtro
	 * @return {@link List<{@link Custa}>}
	 */
	public List<Custa> getCustas(Map<String, Object> filter);
}
