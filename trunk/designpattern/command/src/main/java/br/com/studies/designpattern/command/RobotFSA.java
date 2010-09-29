/**
 * 
 */
package br.com.studies.designpattern.command;

/**
 * @author robson
 *
 */
public class RobotFSA implements Robot {


	@Override
	public void walk() {
		System.out.println("Robot made in FSA is walking");
	}


	@Override
	public void talk(){
		System.out.println("Robot made in FSA is talking");
	}

}
