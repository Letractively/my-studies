package br.com.mystudies.ds.service.string.b49c.factory;

import java.util.HashMap;
import java.util.Map;

import br.com.mystudies.ds.service.report.ReportService;
import br.com.mystudies.ds.service.report.factory.ReportFactory;
import br.com.mystudies.ds.service.report.factory.ReportType;
import br.com.mystudies.ds.service.string.b49c.ReportAnaliticService;
import br.com.mystudies.ds.service.string.b49c.ReportCustomService;
import br.com.mystudies.ds.service.string.b49c.ReportSintaticService;

public class ReportFactoryB49C implements ReportFactory {


	private Map<ReportType, Class<? extends ReportService>> reports;

	{
		reports = new HashMap<>();
		reports.put(ReportType.ANALITIC, ReportAnaliticService.class);
		reports.put(ReportType.CUSTOM, ReportCustomService.class);
		reports.put(ReportType.SINTATIC, ReportSintaticService.class);
	}



	@Override
	public ReportService create(ReportType reportType) {
		Class<? extends ReportService> c = reports.get(reportType);
		if(c != null){
			try {
				return c.newInstance();
			} catch (InstantiationException | IllegalAccessException exception) {
				exception.printStackTrace();
			}
		}
		return null;
	}

}
