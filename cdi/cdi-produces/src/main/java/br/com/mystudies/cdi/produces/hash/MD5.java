package br.com.mystudies.cdi.produces.hash;

import org.apache.commons.codec.digest.DigestUtils;


public class MD5 implements Hash {

	@Override
	public String getHash(String string) {
		return DigestUtils.md5Hex(string);
	}

}
