package br.com.mystudies.cdi.hash;

import br.com.mystudies.cdi.qualifier.SHA1;


@SHA1
public class HashSHA1 implements Hash {

	@Override
	public String getHash(String string) {
		return "sha1";
	}
}
