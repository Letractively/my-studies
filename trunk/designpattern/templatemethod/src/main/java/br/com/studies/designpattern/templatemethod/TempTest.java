package br.com.studies.designpattern.templatemethod;

public class TempTest {

	public static void main(String[] args) {
		
		Printer printer = new PrinterPDF( new DataBaseDao() );
		
		printer.print();
		
		printer = new PrinterHTML(new FileTXTDao());
		
		printer.print();
		
	}
}
