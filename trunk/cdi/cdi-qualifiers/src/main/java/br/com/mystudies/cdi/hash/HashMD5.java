package br.com.mystudies.cdi.hash;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.mystudies.cdi.qualifier.MD5;



@MD5
public class HashMD5 implements Hash {

	@Override
	public String getHash(String string) {
		return DigestUtils.md5Hex(string);
	}

}
