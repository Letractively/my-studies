package br.com.mystudies.cdi.hash;

import br.com.mystudies.cdi.qualifier.SHA256;


@SHA256
public class HashSHA256 implements Hash {

	@Override
	public String getHash(String string) {
		return "sha256";
	}
}
