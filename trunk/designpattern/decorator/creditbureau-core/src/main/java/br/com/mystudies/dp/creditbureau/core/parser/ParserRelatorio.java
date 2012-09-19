package br.com.mystudies.dp.creditbureau.core.parser;

import br.com.mystudies.dp.creditbureau.core.b49c.Protocolo;
import br.com.mystudies.dp.creditbureau.core.model.Relatorio;

public interface ParserRelatorio {

	Relatorio parse( Protocolo protocolo, Object... objects);
}
