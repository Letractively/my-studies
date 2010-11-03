package br.com.estudos.primefaces.autocomplete;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AutoCompleteMB {
	
	private String name;
	
	private Person person;
	
	public List<String> simpleAutoComplete(String startNames){		
		return AutoCompleteHelper.getNames(startNames);
	}
	
	public List<Person> beanAutoComplete(String startNames){		
		return AutoCompleteHelper.getPersons(startNames);
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
