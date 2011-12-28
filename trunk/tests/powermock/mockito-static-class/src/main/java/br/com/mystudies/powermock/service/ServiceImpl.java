package br.com.mystudies.powermock.service;

import br.com.mystudies.powermock.dao.Dao;
import br.com.mystudies.powermock.dao.FactoryDao;
import br.com.mystudies.powermock.dao.SGDB;

public class ServiceImpl implements Service {

	@Override
	public String find(SGDB sgdb) {
		Dao dao = FactoryDao.create(sgdb);
		return dao.find();
	}

	
}
