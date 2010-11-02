package br.com.mystudies.spring.setter.injection;

/**
 * @author rduarte
 *
 */
public class User {
	
	private String name;
	private String age;
	private String country;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", country=" + country + "]";
	}
		
}
