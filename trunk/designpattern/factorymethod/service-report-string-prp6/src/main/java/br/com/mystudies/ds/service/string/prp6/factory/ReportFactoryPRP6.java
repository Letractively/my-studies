package br.com.mystudies.ds.service.string.prp6.factory;

import java.util.HashMap;
import java.util.Map;

import br.com.mystudies.ds.service.report.ReportService;
import br.com.mystudies.ds.service.report.factory.ReportFactory;
import br.com.mystudies.ds.service.report.factory.ReportType;
import br.com.mystudies.ds.service.string.prp6.ReportAnaliticService;
import br.com.mystudies.ds.service.string.prp6.ReportCustomService;
import br.com.mystudies.ds.service.string.prp6.ReportSintaticServie;

public class ReportFactoryPRP6 implements ReportFactory {

	private Map<ReportType, Class<? extends ReportService>> reports;

	{
		reports = new HashMap<>();
		reports.put(ReportType.ANALITIC, ReportAnaliticService.class);
		reports.put(ReportType.CUSTOM, ReportCustomService.class);
		reports.put(ReportType.SINTATIC, ReportSintaticServie.class);
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
