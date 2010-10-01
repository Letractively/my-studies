package br.com.estudos.jsf2new.dao;

import java.util.List;

import br.com.estudos.jsf2new.entity.Person;

/**
 * @author rduarte
 *
 */
public interface PersonDao {

	public List<Person> getPersons();
}
