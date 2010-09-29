/**
 * 
 */
package br.com.studies.designpattern.command;

/**
 * @author robson
 *
 */
public class BrazlianControlerRemote {

	private Command commandAndar;
	private Command commandFalar;

	
	public BrazlianControlerRemote(Command commandAndar, Command commandFalar) {
		this.commandAndar = commandAndar;
		this.commandFalar = commandFalar;
	}

	public void andar(){
		commandAndar.execute();
	}
	
	
	public void falar(){
		commandFalar.execute();
	}
		
}
