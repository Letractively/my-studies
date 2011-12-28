package br.com.mystudies.powermock.dao;

public class FactoryDao {

	public static Dao create(SGDB sgdb){
		switch (sgdb) {
		case MYSQL:
			return new MySqlDao();
		case ORACLE:
			return new OracleDao();
		case SQL_SERVER:
			return new SQlServerDao();
		default:
			return null;
		}
	}
}
