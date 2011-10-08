package br.com.mystudies.jsf.composite.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ConsultaMB {

	private String transacao;

	private boolean featureUm;
	private boolean featureDois;
	
	public void consultar(){
		System.out.println(transacao);
		System.out.println(featureUm);
		System.out.println(featureDois);
		
	}
	
	
	public String getTransacao() {
		return transacao;
	}

	public void setTransacao(String transacao) {
		this.transacao = transacao;
	}


	public boolean isFeatureUm() {
		return featureUm;
	}


	public void setFeatureUm(boolean featureUm) {
		this.featureUm = featureUm;
	}


	public boolean isFeatureDois() {
		return featureDois;
	}


	public void setFeatureDois(boolean featureDois) {
		this.featureDois = featureDois;
	}
	
}
