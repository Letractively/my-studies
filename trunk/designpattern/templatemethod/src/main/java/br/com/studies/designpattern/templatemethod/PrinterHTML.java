/**
 * 
 */
package br.com.studies.designpattern.templatemethod;

/**
 * @author robson
 *
 */
public class PrinterHTML extends Printer {

	/**
	 * @param dao
	 */
	public PrinterHTML(Dao dao) {
		super(dao);
	}


	@Override
	protected Printer genereatePrint(){
		System.out.println(" Generating HTLM file ");
		return this;
	}

	@Override
	protected Printer printFile(){
		System.out.println(" printing HTLM file ");
		return this;
	}

}
