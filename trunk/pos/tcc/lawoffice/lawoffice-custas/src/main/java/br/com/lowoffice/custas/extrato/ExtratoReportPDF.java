/**
 * 
 */
package br.com.lowoffice.custas.extrato;

import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.lawoffice.dominio.Custa;

/**
 * 
 * Implementação do {@link ExtratoReport} para geração de PDF.
 * 
 * @author robson
 *
 */
public class ExtratoReportPDF implements ExtratoReport {


	@Override
	public byte[] gerarExtrato(List<Custa> listaCustas){
		
		JRBeanCollectionDataSource jrBeanCollectionDataSource =
			new JRBeanCollectionDataSource(listaCustas);
		
		
    	JasperPrint jasperPrint;
    	
		try {
			jasperPrint = JasperFillManager.fillReport(
    				this.getClass().getResourceAsStream("/jasper/extrato-custas.jasper"), 
    				null, 
    			jrBeanCollectionDataSource);
		
			return JasperExportManager.exportReportToPdf(jasperPrint);
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
