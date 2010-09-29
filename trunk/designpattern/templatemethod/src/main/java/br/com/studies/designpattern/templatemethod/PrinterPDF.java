/**
 * 
 */
package br.com.studies.designpattern.templatemethod;

/**
 * @author robson
 *
 */
public class PrinterPDF extends Printer{
	/**
	 * @param dao
	 */
	public PrinterPDF(Dao dao) {
		super(dao);
	}

	@Override
	protected Printer genereatePrint(){
		System.out.println(" Generating PDF file ");
		return this;
	}

	@Override
	protected Printer printFile(){
		System.out.println(" printing PDF file ");
		return this;
	}

}
