package br.com.mystutides.java.format;

import java.text.MessageFormat;
import java.util.Locale;

public class MessageFormatBuilder {

	private Object[] values;

	private String message;

	private Locale locale;


	public MessageFormatBuilder addMessage(String message) {
		this.message = message;
		return this;
	}

	public MessageFormatBuilder addLocale(Locale locale) {
		this.locale = locale;
		return this;
	}


	public MessageFormatBuilder addFormatElement(int i, FormatType formatType, FormatStyle formatStyle) {
		message = message.replace(Integer.toString(i), i + "," + formatType.toString().toLowerCase() + "," + formatStyle.toString().toLowerCase());
		return this;
	}

	public MessageFormatBuilder addValues(Object... valeus) {
		this.values = valeus;
		return this;
	}

	public String formatMessage() {
		MessageFormat messageFormat = new MessageFormat(message,locale);
		return messageFormat.format(values);
	}

}
