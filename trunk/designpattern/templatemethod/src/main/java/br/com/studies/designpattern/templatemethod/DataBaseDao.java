/**
 * 
 */
package br.com.studies.designpattern.templatemethod;

/**
 * @author robson
 *
 */
public class DataBaseDao implements Dao {

	@Override
	public Object getDada() {
		return new String(" Geting data in data base ");
	}

}
