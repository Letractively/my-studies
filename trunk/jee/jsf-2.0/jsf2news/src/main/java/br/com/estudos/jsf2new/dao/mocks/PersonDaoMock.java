package br.com.estudos.jsf2new.dao.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.estudos.jsf2new.dao.PersonDao;
import br.com.estudos.jsf2new.entity.Person;

public class PersonDaoMock implements PersonDao {

	@Override
	public List<Person> getPersons(){
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(2, "Ana Mara"));		
		persons.add(new Person(4, "Antonio"));
		persons.add(new Person(3, "Cibele"));
		persons.add(new Person(1, "Robson"));
		return persons;
	}

}
