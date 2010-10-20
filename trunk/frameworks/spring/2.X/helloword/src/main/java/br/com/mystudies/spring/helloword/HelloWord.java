/**
 * 
 */
package br.com.mystudies.spring.helloword;

/**
 * @author rduarte
 *
 */
public class HelloWord{

	private String message;

	public void display(){
		System.out.println(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}
