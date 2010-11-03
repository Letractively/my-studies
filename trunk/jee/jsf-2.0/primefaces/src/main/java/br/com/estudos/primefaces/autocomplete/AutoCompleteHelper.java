package br.com.estudos.primefaces.autocomplete;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rduarte
 *
 */
public class AutoCompleteHelper{

	private static List<String> names;
	
	private static List<Person> persons;
	
	
	// basic Brazilian list names
	static{
		names = new ArrayList<String>();		
		names.add("Ana Mara");
		names.add("Ana Paula");
		names.add("Beatriz");
		names.add("Bianca");
		names.add("Carlos");
		names.add("Caio");
		names.add("Dainel");
		names.add("Daniela");
		names.add("Evandro");
		names.add("Everaldo");
		names.add("Fabio");
		names.add("Fabiola");
		names.add("Fabiola");
		names.add("Gabriel");
		names.add("Grasiele");
		names.add("Humberto");
		names.add("Helio");
		names.add("Ivan");
		names.add("Irene");
		names.add("Joaquin");
		names.add("Joana");
		names.add("Leandro");
		names.add("Leonardo");
		names.add("Marcio");
		names.add("Marcia");
		names.add("Natanael");
		names.add("Nicole");
		names.add("Otavio");
		names.add("Paula");
		names.add("Paolo");
		names.add("Robson");
		names.add("Roberto");
		names.add("Sandro");
		names.add("Sandra");
		names.add("Thiago");
		names.add("Tatiana");
		
	}
	
	
	// basic Brazilian persons
	static{
		persons = new ArrayList<Person>();
		persons.add( new Person(1, "Ana Mara"));
		persons.add( new Person(2,"Ana Paula"));
		persons.add( new Person(3,"Beatriz"));
		persons.add( new Person(4,"Bianca"));
		persons.add( new Person(5,"Carlos"));
		persons.add( new Person(6,"Caio"));
		persons.add( new Person(7,"Dainel"));
		persons.add( new Person(8,"Daniela"));
		persons.add( new Person(9,"Evandro"));
		persons.add( new Person(10,"Everaldo"));
		persons.add( new Person(11,"Fabio"));
		persons.add( new Person(12,"Fabiola"));
		persons.add( new Person(13,"Fabiola"));
		persons.add( new Person(14,"Gabriel"));
		persons.add( new Person(15,"Grasiele"));
		persons.add( new Person(16,"Humberto"));
		persons.add( new Person(17,"Helio"));
		persons.add( new Person(18,"Ivan"));
		persons.add( new Person(19,"Irene"));
		persons.add( new Person(20,"Joaquin"));
		persons.add( new Person(21,"Joana"));
		persons.add( new Person(22,"Leandro"));
		persons.add( new Person(23,"Leonardo"));
		persons.add( new Person(24,"Marcio"));
		persons.add( new Person(25,"Marcia"));
		persons.add( new Person(26,"Natanael"));
		persons.add( new Person(27,"Nicole"));
		persons.add( new Person(28,"Otavio"));
		persons.add( new Person(29,"Paula"));
		persons.add( new Person(30,"Paolo"));
		persons.add( new Person(31,"Robson"));
		persons.add( new Person(32,"Roberto"));
		persons.add( new Person(33,"Sandro"));
		persons.add( new Person(34,"Sandra"));
		persons.add( new Person(35,"Thiago"));
		persons.add( new Person(36,"Tatiana"));
		
	}
	
	

	
	public static List<String> getNames(String startName){
		List<String> namesFound = new ArrayList<String>();
		for (String name : names)
			if(name.startsWith(startName))
				namesFound.add(name);
		return namesFound;
		
	}
	
	
	public static List<Person> getPersons(String startName){
		List<Person> personsFound = new ArrayList<Person>();
		for (Person person : persons)
			if(person.getName().startsWith(startName))
				personsFound.add(person);
		return personsFound;
	}
	
	
}
