package br.com.mystudies.cdi.hash;

import br.com.mystudies.cdi.qualifier.MD5;



@MD5
public class HashMD5 implements Hash {

	@Override
	public String getHash(String string) {
		return "MD5";
	}

}
