package br.com.lawoffice.web.mb.custos;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

/**
 * @author robson
 *
 * Manager Bean para página de /custos/novo-custo.xhtml
 *
 */
@ManagedBean()
public class MBNovoLancamento {
	

	private List<String> s;
	
	public List<String> getS() {
		s = new ArrayList<String>();
		s.add("temp");
		s.add("temp");
		s.add("temp");
		s.add("temp");
		s.add("temp");
		return s;
	} 
	
	public void setS(List<String> s) {
		this.s = s;
	}
}
