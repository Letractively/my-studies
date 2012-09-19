package br.com.mystudies.dp.creditbureau.core.service;

import br.com.mystudies.dp.creditbureau.core.b49c.B49CRepositorio;
import br.com.mystudies.dp.creditbureau.core.model.Relatorio;
import br.com.mystudies.dp.creditbureau.core.parser.ParserRelatorio;
import br.com.mystudies.dp.creditbureau.core.parser.ParserRelatorioAnalitico;
import br.com.mystudies.dp.creditbureau.core.parser.builder.BuilderParser;
import br.com.mystudies.dp.creditbureau.core.parser.decorator.ParserBlocoA;
import br.com.mystudies.dp.creditbureau.core.parser.decorator.ParserBlocoB;
import br.com.mystudies.dp.creditbureau.core.parser.decorator.ParserBlocoC;

public class RelatorioAnaliticoService implements RelatorioService {

	@Override
	public Relatorio getRelatorio() {
		ParserRelatorio ps = 
				new BuilderParser()
						.addParser(ParserRelatorioAnalitico.class)
						.addParserBloco(ParserBlocoA.class)
						.addParserBloco(ParserBlocoB.class)
						.addParserBloco(ParserBlocoC.class)
						.getParser();
		

		return ps.parse(new B49CRepositorio().consultar());
	}

}
