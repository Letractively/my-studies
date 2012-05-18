package br.com.mystudies.ds.service.string.b49c;

import br.com.mystudies.ds.domain.Report;
import br.com.mystudies.ds.service.report.ReportService;

public class ReportCustomService implements ReportService{

	@Override
	public Report getReport() {
		System.out.println("Custom Report by module B49C");
		return new Report();
	}

}
