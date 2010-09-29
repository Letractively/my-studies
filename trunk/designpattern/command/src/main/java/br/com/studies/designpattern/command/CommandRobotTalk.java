package br.com.studies.designpattern.command;



/**
 * @author robson
 *
 */
public class CommandRobotTalk implements Command{

	private Robot robot;
	
	

	public CommandRobotTalk(Robot robot){
		this.robot = robot;
	}


	@Override
	public void execute() {
		robot.talk();
	}

}
