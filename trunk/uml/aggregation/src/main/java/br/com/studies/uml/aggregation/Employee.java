/**
 * 
 */
package br.com.studies.uml.aggregation;

/**
 * This class is content of relation, so when the content is destroyed, the container are not.
 * 
 * @author rduarte
 * 
 * @see <a href='http://refcardz.dzone.com/assets/download/refcard/2bfde79c85c0c1ee91a91c273c36fc3d/rc112-010d-uml.pdf'>Refcard about UML</a>
 *
 */
public class Employee {

	private Company company;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}
