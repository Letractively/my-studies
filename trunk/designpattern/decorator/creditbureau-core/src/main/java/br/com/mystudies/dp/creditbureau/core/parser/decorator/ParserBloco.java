package br.com.mystudies.dp.creditbureau.core.parser.decorator;

import br.com.mystudies.dp.creditbureau.core.b49c.Protocolo;
import br.com.mystudies.dp.creditbureau.core.model.Relatorio;
import br.com.mystudies.dp.creditbureau.core.parser.ParserRelatorio;

public abstract class ParserBloco implements ParserRelatorio {
	
	public abstract Relatorio parse(Protocolo protocolo, Object... objects);


}
