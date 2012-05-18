package br.com.mystudies.ds.client;

import br.com.mystudies.ds.domain.Report;
import br.com.mystudies.ds.service.report.ReportService;
import br.com.mystudies.ds.service.report.factory.ReportFactory;
import br.com.mystudies.ds.service.report.factory.ReportType;
import br.com.mystudies.ds.service.string.b49c.factory.ReportFactoryB49C;
import br.com.mystudies.ds.service.string.prp6.factory.ReportFactoryPRP6;

public class Client {

	public static void main(String[] args) {


		// module b49c
		ReportFactory reportFactory = new ReportFactoryB49C();

		ReportService reportService =
				reportFactory.create(ReportType.ANALITIC);

		reportService.getReport();


		// module prp6
		reportFactory = new ReportFactoryPRP6();

		reportService = reportFactory.create(ReportType.ANALITIC);

		reportService.getReport();

	}
}
