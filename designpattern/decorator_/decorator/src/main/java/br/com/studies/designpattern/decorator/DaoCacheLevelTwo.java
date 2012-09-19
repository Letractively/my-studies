/**
 * 
 */
package br.com.studies.designpattern.decorator;


/**
 * @author rduarte
 *
 */
public class DaoCacheLevelTwo extends DaoCahe {
	
	/**
	 * @param dao
	 */
	public DaoCacheLevelTwo(Dao dao) {
		super(dao);
	}

	public String getData(){		
		return dao.getData() + " add object cache level two "; 
	}
}
