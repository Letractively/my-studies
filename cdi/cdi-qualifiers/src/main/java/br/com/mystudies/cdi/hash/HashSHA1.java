package br.com.mystudies.cdi.hash;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.mystudies.cdi.qualifier.SHA1;


@SHA1
public class HashSHA1 implements Hash {

	@Override
	public String getHash(String string) {
		return DigestUtils.sha1Hex(string);
	}
}
