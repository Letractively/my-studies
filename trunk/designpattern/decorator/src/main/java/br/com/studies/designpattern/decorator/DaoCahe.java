/**
 * 
 */
package br.com.studies.designpattern.decorator;

/**
 * @author rduarte
 *
 */
public abstract class DaoCahe implements Dao {

	protected Dao dao;
	
	public DaoCahe(Dao dao){
		this.dao = dao;
	}
	
}
