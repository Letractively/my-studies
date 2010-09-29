package br.com.studies.designpattern.facade;

/**
 * @author robson
 *
 */
public class FacadeSystens {

	public void executeSystemOne(){
		new SystemOne().operationSystemOne();
	}
	
	public void executeSystemTwo(){
		new SystemTwo().operationSystemTwo();
	}
	
	public void executeSystemThree(){
		new SystemThree().operationSystemThree();
	}
}
