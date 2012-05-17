package br.com.mystudies.ds.service.report.factory;

import br.com.mystudies.ds.service.report.ReportService;

public interface ReportFactory {

	ReportService create(ReportType reportType);
}
