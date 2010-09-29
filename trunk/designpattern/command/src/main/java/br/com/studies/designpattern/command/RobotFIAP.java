package br.com.studies.designpattern.command;

/**
 * @author robson
 *
 */
public class RobotFIAP implements Robot {

	@Override
	public void walk() {
		System.out.println("Robot made in FIAP is walking");
	}


	@Override
	public void talk(){
		System.out.println("Robot made in FIAP is talking");
	}

}
