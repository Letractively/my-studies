package br.com.mystudies.dp.creditbureau.core.test;

import br.com.mystudies.dp.creditbureau.core.model.Relatorio;
import br.com.mystudies.dp.creditbureau.core.service.RelatorioAnaliticoService;
import br.com.mystudies.dp.creditbureau.core.service.RelatorioService;
import br.com.mystudies.dp.creditbureau.core.service.RelatorioSinteticoService;

public class Main {

	public static void main(String[] args) {
		
		
		RelatorioService relatorioService = new RelatorioSinteticoService();
		
		Relatorio relatorio = relatorioService.getRelatorio();
		
		System.out.println(relatorio);
		
		relatorioService = new RelatorioAnaliticoService();
		
		relatorio = relatorioService.getRelatorio();
		
		System.out.println(relatorio);
		
	}
}
