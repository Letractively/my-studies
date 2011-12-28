package br.com.mystudies.powermock.dao;

public class OracleDao implements Dao {

	@Override
	public String find() {
		return "finding in oracle";
	}

}
