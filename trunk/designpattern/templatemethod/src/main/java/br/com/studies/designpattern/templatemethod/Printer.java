/**
 * 
 */
package br.com.studies.designpattern.templatemethod;

/**
 * @author robson
 *
 */
public abstract class Printer {

	private Dao dao;
	
	
	public Printer(Dao dao){
		this.dao = dao;
	}



	public final void print(){
		getData().genereatePrint().printFile();
	}


	private Printer getData() {
		System.out.println(dao.getDada());
		return this;
	}
	
	protected abstract Printer genereatePrint();
	
	protected abstract Printer printFile();
}
