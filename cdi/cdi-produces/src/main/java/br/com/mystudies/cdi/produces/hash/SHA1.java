package br.com.mystudies.cdi.produces.hash;

import org.apache.commons.codec.digest.DigestUtils;


public class SHA1 implements Hash {

	@Override
	public String getHash(String string) {
		return DigestUtils.sha1Hex(string);
	}
}
