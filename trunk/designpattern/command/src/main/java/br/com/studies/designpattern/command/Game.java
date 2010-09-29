package br.com.studies.designpattern.command;

/**
 * @author robson
 *
 */
public class Game {

	public static void main(String[] args) {
		
		
		PersonControler pcFIAP = new PersonControleFIAP();
		
		PersonControler pcFSA = new PersonControlerFSA();
		
		
		pcFIAP.makeRobotWalk();
		pcFSA.makeRobotWalk();
		
		pcFIAP.makeRobotTalk();
		pcFSA.makeRobotTalk();
	}
}
