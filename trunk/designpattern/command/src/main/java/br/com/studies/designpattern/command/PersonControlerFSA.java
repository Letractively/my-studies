/**
 * 
 */
package br.com.studies.designpattern.command;

/**
 * @author robson
 *
 */
public class PersonControlerFSA implements PersonControler{
	
	
	private BrazlianControlerRemote remote;
	
	
	public PersonControlerFSA(){
		
		Robot robot = new RobotFSA();
		
		remote = new BrazlianControlerRemote( 
					new CommandRobotTalk(robot), 
					new CommandRobotWalk(robot)
				);
	}

	@Override
	public void makeRobotWalk() {
		remote.andar();

	}

	@Override
	public void makeRobotTalk() {
		remote.falar();
	}

}
