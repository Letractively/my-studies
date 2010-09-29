/**
 * 
 */
package br.com.studies.designpattern.templatemethod;

/**
 * @author robson
 *
 */
public class FileTXTDao implements Dao {


	@Override
	public Object getDada() {
		return new String(" Geting data in file TXT ");
	}

}
