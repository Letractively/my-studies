/**
 * 
 */
package br.com.studies.designpattern.command;

/**
 * @author robson
 *
 */
public class CommandRobotWalk implements Command {


	private Robot robot;
	
	
	
	
	public CommandRobotWalk(Robot robot) {
		this.robot = robot;
	}




	@Override
	public void execute(){
		robot.walk();
	}

	
	
}
