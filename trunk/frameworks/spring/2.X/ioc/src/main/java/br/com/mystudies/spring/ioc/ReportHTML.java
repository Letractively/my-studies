/**
 * 
 */
package br.com.mystudies.spring.ioc;

/**
 * @author rduarte
 *
 */
public class ReportHTML implements Report {

	@Override
	public byte[] getReport() {
		return "Report in HTML".getBytes();
	}

}
