package br.com.mystudies.dp.creditbureau.core.parser.builder;

import java.lang.reflect.Constructor;

import br.com.mystudies.dp.creditbureau.core.parser.ParserRelatorio;
import br.com.mystudies.dp.creditbureau.core.parser.decorator.ParserBloco;

public class BuilderParser {
	
	
	private ParserRelatorio parserRelatorio;
	
	
	public BuilderParser addParser(Class<? extends ParserRelatorio> c)  {
		try {
			parserRelatorio = c.newInstance();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return this;
	}

	public BuilderParser addParserBloco(Class<? extends ParserBloco> c) {
	
		try {
			
			Constructor<? extends ParserBloco> constructor = 
					c.getConstructor(ParserRelatorio.class);

			parserRelatorio = constructor.newInstance(parserRelatorio);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return this;
	}

	
	public ParserRelatorio getParser() {
		return parserRelatorio;
	}

}
