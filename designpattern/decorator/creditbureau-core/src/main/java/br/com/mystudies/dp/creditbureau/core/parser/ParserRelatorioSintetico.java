package br.com.mystudies.dp.creditbureau.core.parser;

import br.com.mystudies.dp.creditbureau.core.b49c.Protocolo;
import br.com.mystudies.dp.creditbureau.core.model.Relatorio;

public class ParserRelatorioSintetico implements ParserRelatorio {

	
	
	
	@Override
	public Relatorio parse(Protocolo protocolo, Object... objects) {
		Relatorio relatorio = new Relatorio();
		relatorio.relatorio = " Relatorio Sintetico > ";		
		return relatorio;
	}

}
