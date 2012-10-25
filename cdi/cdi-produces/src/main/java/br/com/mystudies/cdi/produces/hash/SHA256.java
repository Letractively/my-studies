package br.com.mystudies.cdi.produces.hash;

import org.apache.commons.codec.digest.DigestUtils;


public class SHA256 implements Hash {

	@Override
	public String getHash(String string) {
		return DigestUtils.sha256Hex(string);
	}
}
