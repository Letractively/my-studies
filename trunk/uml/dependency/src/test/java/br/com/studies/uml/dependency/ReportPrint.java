package br.com.studies.uml.dependency;

/**
 * 
 * This class have dependency with interface Report
 * 
 * @author rduarte
 *
 */
public class ReportPrint {

	private Report report;

	public ReportPrint(Report report) {
		this.report = report;
	}

	public void printReport(){
		report.report();	
	}
}
