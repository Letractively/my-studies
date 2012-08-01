package br.com.mystutides.java.format;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FormatTest {


	private MessageFormatBuilder formatBuilder;


	@Before
	public void setUp() throws Exception {
		formatBuilder = new MessageFormatBuilder();
	}


	@After
	public void tearDown() throws Exception {
		formatBuilder = null;
	}


	@Test
	public void testForBrazilianLocale() {

		Date date = new Date();


		String s = formatBuilder
					.addMessage("{0} do saldo de {1} em {2} = {3}")
					.addLocale(new Locale("pt", "BR"))
					.addFormatElement(0, FormatType.NUMBER, FormatStyle.PERCENT)
					.addFormatElement(1, FormatType.NUMBER, FormatStyle.CURRENCY)
					.addFormatElement(2, FormatType.DATE, FormatStyle.SHORT)
					.addFormatElement(3, FormatType.NUMBER, FormatStyle.CURRENCY)
					.addValues(.10, 100, date, 10)
					.formatMessage();



		assertEquals("10% do saldo de R$ 100,00 em " + new SimpleDateFormat("dd/MM/yy").format(date) + " = R$ 10,00", s );
	}

	@Test
	public void testForAmericanLocale() {

		Date date = new Date();


		String s = formatBuilder
				.addMessage("{0} do saldo de {1} em {2} = {3}")
				.addLocale(Locale.US)
				.addFormatElement(0, FormatType.NUMBER, FormatStyle.PERCENT)
				.addFormatElement(1, FormatType.NUMBER, FormatStyle.CURRENCY)
				.addFormatElement(2, FormatType.DATE, FormatStyle.SHORT)
				.addFormatElement(3, FormatType.NUMBER, FormatStyle.CURRENCY)
				.addValues(.10, 100, date, 10)
				.formatMessage();



		assertEquals("10% do saldo de $100.00 em " + new SimpleDateFormat("M/d/yy").format(date) + " = $10.00", s );
	}

}
