package br.com.estudos.jsf2new.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.estudos.jsf2new.dao.PersonDao;
import br.com.estudos.jsf2new.dao.mocks.PersonDaoMock;
import br.com.estudos.jsf2new.entity.Person;

/**
 * @author rduarte
 *
 */
@ManagedBean
public class SelectionTagMB{
	
	private int PersonId;
	
	private PersonDao personDao;
	
	@PostConstruct
	public void init(){
		personDao = new PersonDaoMock();
	}
	
	public List<Person> getPersons() {
		return personDao.getPersons();
	}

	public int getPersonId() {
		return PersonId;
	}

	public void setPersonId(int personId) {
		PersonId = personId;
	}
	
}
