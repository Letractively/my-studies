package br.com.studies.uml.dependency;

/**
 * 
 * This class have dependency with interface Report
 * 
 * @author rduarte
 * 
 * 
 * @see <a href='http://refcardz.dzone.com/assets/download/refcard/2bfde79c85c0c1ee91a91c273c36fc3d/rc112-010d-uml.pdf'>Refcard about UML</a>
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
