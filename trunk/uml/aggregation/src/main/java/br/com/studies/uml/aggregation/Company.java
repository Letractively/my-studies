package br.com.studies.uml.aggregation;

/**
 * 
 * This class is container of relation , so when the container is destroyed , the content are not. 
 * 
 * @author rduarte
 *
 * @see <a href='http://refcardz.dzone.com/assets/download/refcard/2bfde79c85c0c1ee91a91c273c36fc3d/rc112-010d-uml.pdf'>Refcard about UML</a>
 *
 */
public class Company {

	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
