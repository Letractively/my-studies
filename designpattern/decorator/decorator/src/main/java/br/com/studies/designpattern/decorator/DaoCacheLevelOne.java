/**
 * 
 */
package br.com.studies.designpattern.decorator;

/**
 * @author rduarte
 *
 */
public class DaoCacheLevelOne extends DaoCahe {


	
	public DaoCacheLevelOne(Dao dao) {
		super(dao);
	}

	
	public String getData(){
		return dao.getData() + " add object cache level one ";
	}

}
