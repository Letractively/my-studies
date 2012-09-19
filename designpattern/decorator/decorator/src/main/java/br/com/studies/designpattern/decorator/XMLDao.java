/**
 * 
 */
package br.com.studies.designpattern.decorator;

/**
 * @author rduarte
 *
 */
public class XMLDao implements Dao {

	public String getData() {
		return new String("Data get Xml");
	}

}
