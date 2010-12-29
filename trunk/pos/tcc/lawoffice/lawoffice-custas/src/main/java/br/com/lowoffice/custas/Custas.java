package br.com.lowoffice.custas;

import java.util.Date;
import java.util.List;
import java.util.Map;

import br.com.lawoffice.dominio.Custa;


/**
 * Interface para o serviço de custas
 * 
 * <br><br>
 * 
 * Forncendo o serviço de pesquisa de lançamentos ( custas )
 * 
 * <br> <br>
 * 
 * @author robson
 *
 */
public interface Custas{
	
	public List<Custa> getCustasPorDataCliente(Date dataInicial, Date dataFinal, Long idCliente);
}
