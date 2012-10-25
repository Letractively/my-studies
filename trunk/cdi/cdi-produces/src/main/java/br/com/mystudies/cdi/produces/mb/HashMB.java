package br.com.mystudies.cdi.produces.mb;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mystudies.cdi.produces.hash.Hash;
import br.com.mystudies.cdi.produces.hash.MD5;
import br.com.mystudies.cdi.produces.hash.SHA1;
import br.com.mystudies.cdi.produces.hash.SHA256;
import br.com.mystudies.cdi.produces.qualifier.Chosen;

@Named
@RequestScoped
public class HashMB {

	
	private String algoritmo = "MD5"; // DEFAULT
	
	
	private String value;
	
	
	private String valueHash;
	
	
	@Inject 
	@Chosen
	private Hash hash;
	
	
	
	public void calculeHash(){
		valueHash = hash.getHash(value);
	}



	
	@Produces 
	@Chosen
	public Hash getHash(MD5 md5, SHA1 sha1 , SHA256 sha256){
		
		switch (algoritmo) {
			case "MD5":
				return md5;
			case "SHA1":
				return sha1;
			case "SHA256":
				return sha256;
			default:
				return null;
		}		
	}
	
	
	
	
	
	
	
	/// GETS AND SETS

	public String getAlgoritmo() {
		return algoritmo;
	}


	public void setAlgoritmo(String algoritmo) {
		this.algoritmo = algoritmo;
	}

	
	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}

	
	public String getValueHash() {
		return valueHash;
	}
	
}
