/**
 * 
 */
package br.com.mystudies.spring.ioc;

/**
 * @author rduarte
 *
 */
public class ReportXML implements Report {

	@Override
	public byte[] getReport() {
		return "Report in XML".getBytes();
	}
}
