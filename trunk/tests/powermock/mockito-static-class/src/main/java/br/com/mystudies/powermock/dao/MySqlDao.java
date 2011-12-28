package br.com.mystudies.powermock.dao;

public class MySqlDao implements Dao {

	@Override
	public String find() {
		return "finding in mysql";
	}

}
