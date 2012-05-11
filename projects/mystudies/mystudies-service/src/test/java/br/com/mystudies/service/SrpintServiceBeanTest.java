package br.com.mystudies.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.mystudies.domain.entity.Sprint;
import br.com.mystudies.domain.enun.SprintStatus;

public class SrpintServiceBeanTest {

	@InjectMocks
	private SprintServiceBean sprintServicebean;
	
	@Mock
	private SprintDao sprintDao;

	@Before
	public void setUp() throws Exception {
		sprintServicebean = new SprintServiceBean();
		initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
		sprintServicebean = null;
	}

	@Test
	public void shouldReturnTrueWhileContainsSprintInRun() {
		
		when(sprintDao.findSprintByStatus(SprintStatus.RUNNING)).thenReturn(new Sprint());
		
		boolean containsSprintInRun = sprintServicebean.containsSprintInRun();
		
		verify(sprintDao).findSprintByStatus(SprintStatus.RUNNING);
		
		assertTrue(containsSprintInRun);		
	}
	
	
	
	@Test
	public void shouldReturnFalseWhileDontContainsSprintInRun() {
		
		when(sprintDao.findSprintByStatus(SprintStatus.RUNNING)).thenReturn(null);
		
		boolean containsSprintInRun = sprintServicebean.containsSprintInRun();
		
		verify(sprintDao).findSprintByStatus(SprintStatus.RUNNING);
		
		assertFalse(containsSprintInRun);		
	}

}
