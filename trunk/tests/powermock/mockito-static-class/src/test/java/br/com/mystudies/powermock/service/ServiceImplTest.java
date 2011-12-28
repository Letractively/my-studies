package br.com.mystudies.powermock.service;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.com.mystudies.powermock.dao.Dao;
import br.com.mystudies.powermock.dao.FactoryDao;
import br.com.mystudies.powermock.dao.MySqlDao;
import br.com.mystudies.powermock.dao.SGDB;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FactoryDao.class})
public class ServiceImplTest {

	private ServiceImpl serviceImpl;
	
	@Before
	public void setUp() throws Exception {
		serviceImpl = new ServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		serviceImpl = null;
	}

	@Test
	public void testFind() {
		assertEquals("finding in mysql", serviceImpl.find(SGDB.MYSQL));
	}
	
	
	@Test
	public void testFindMockDaoFactory() {
		
		mockStatic(FactoryDao.class);
	
		Dao dao = Mockito.mock(MySqlDao.class);
		
		Mockito.when(dao.find()).thenReturn("mocking the finding in mysql ");
		
		Mockito.when(FactoryDao.create(SGDB.MYSQL)).thenReturn(dao);
		
		assertEquals("mocking the finding in mysql ", serviceImpl.find(SGDB.MYSQL));

	}	

	
	
}
