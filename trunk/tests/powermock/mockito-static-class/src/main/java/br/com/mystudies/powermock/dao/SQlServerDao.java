package br.com.mystudies.powermock.dao;

public class SQlServerDao implements Dao {

	@Override
	public String find() {
		return "finding in sql server";
	}

}
