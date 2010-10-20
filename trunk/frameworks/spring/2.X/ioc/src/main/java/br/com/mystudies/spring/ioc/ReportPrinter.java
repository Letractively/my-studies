/**
 * 
 */
package br.com.mystudies.spring.ioc;

/**
 * @author rduarte
 *
 */
public class ReportPrinter{

	
	private Report report;

	
	public void printReport(){
		System.out.println(new String(report.getReport()));
	}
	
	
	public void setReport(Report report) {
		this.report = report;
	}
}
