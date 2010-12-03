/**
 * 
 */
package br.com.lowoffice.custas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

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
@Stateful
@Local(CustasLocal.class)
@Remote(CustasRemote.class)
public class CustasBean implements Custas{


	@Override
	public List<Custa> getCustas(Map<String, Object> filtro){
		if(filtro == null)
			throw new IllegalArgumentException("filtro esta nulo");
		if(filtro.isEmpty())
			return new ArrayList<Custa>();
		
		
		// FIXME falta implementação da consulta usando criteira api devido a debito tecnico que já está sendo resolvido
		return getCusta();
	}
	
	
	
	
	
	// FIXME como já estou realizando a intregação página/mb do lançmentos
	// surgiu a necessidade agora desse cara devido o debito tecnico como mencionado acima.... 
	private List<Custa> getCusta(){
		
		List<Custa> listaCustas = new ArrayList<Custa>();
		
		Random random = new Random();
		
		
		int numeroDeCusta =  random.nextInt(10);
		
		while (numeroDeCusta >= 0){
			
			Custa c = new Custa();
			c.setValor(new BigDecimal(numeroDeCusta));
			c.setNatureza("Natureza " + numeroDeCusta);			
			listaCustas.add(c);
			
			numeroDeCusta--;
		}
		
		return listaCustas;
	}
	
	
	
	
	
	
	
	
	
	

}
