package br.com.estudos.primefaces.autocomplete;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AutoCompleteMB {
	
	private String name;
	
	public List<String> simpleAutoComplete(String query){
		
		List<String> names = new ArrayList<String>();
		
		names.add("Robson");
		names.add("Robson");
		names.add("Robson");
		names.add("Robson");
		
		return names;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
