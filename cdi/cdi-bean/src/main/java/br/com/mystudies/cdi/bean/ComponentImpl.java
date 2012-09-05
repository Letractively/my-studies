package br.com.mystudies.cdi.bean;


public class ComponentImpl implements Component {

	@Override
	public String upperCase(String string) {
		return string == null ? null : string.toUpperCase();
	}

}
