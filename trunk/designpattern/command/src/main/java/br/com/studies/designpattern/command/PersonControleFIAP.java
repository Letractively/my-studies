/**
 * 
 */
package br.com.studies.designpattern.command;

/**
 * @author robson
 *
 */
public class PersonControleFIAP implements PersonControler {

	
	private BrazlianControlerRemote remote;
	
	
	
	public PersonControleFIAP() {
		Robot robot = new RobotFIAP();
		remote = new BrazlianControlerRemote( 
				new CommandRobotTalk(robot),
				new CommandRobotWalk(robot)
			);
	}

	@Override
	public void makeRobotWalk(){
		remote.andar();
	}

	@Override
	public void makeRobotTalk() {
		remote.falar();
	}

}
