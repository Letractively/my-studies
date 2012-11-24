package br.com.mystudies.service.statistically;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.mystudies.domain.entity.Sprint;
import br.com.mystudies.service.persistence.SprintDao;

public class StatisticallyServiceBeanTest {

	
	@InjectMocks
	private StatisticallyServiceBean statisticallyService;

	@Mock
	private SprintDao sprintDao;
	
	
	@Before
	public void setUp() throws Exception {
		statisticallyService = new StatisticallyServiceBean();
		initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
		statisticallyService = null;
	}

	@Test
	public void shouldReturnAverageOfPointsBySprints() {
		
		// 1 - media de pontos por sprint
		
	
		when(sprintDao.listAll()).thenReturn(getSprints());
		
		
		List<Temp> temps = 
				statisticallyService.get();

		
		verify(sprintDao).listAll();
		
		
		assertTrue(temps.size() == 5);
		
		assertEquals(new Long(40), temps.get(0).getAverage());
		assertEquals(new Long(22), temps.get(1).getAverage());
		assertEquals(new Long(32), temps.get(2).getAverage());
		assertEquals(new Long(34), temps.get(3).getAverage());
		assertEquals(new Long(36), temps.get(4).getAverage());
		
		
	}

	
	
	private List<Sprint> getSprints() {
		List<Sprint> sprints = new ArrayList<>();
		Sprint sprint = new Sprint();
		sprint.setDonePoints(40l);
		sprint.setId(1l);
		sprints.add(sprint);
		
		sprint = new Sprint();
		sprint.setDonePoints(5l);
		sprint.setId(2l);
		sprints.add(sprint);

		sprint = new Sprint();
		sprint.setDonePoints(52l);
		sprint.setId(3l);
		sprints.add(sprint);
		
		sprint = new Sprint();
		sprint.setDonePoints(39l);
		sprint.setId(4l);
		sprints.add(sprint);
		
		
		sprint = new Sprint();
		sprint.setDonePoints(47l);
		sprint.setId(5l);
		sprints.add(sprint);
		
		return sprints;
	}
	
	
	
	
	// preciso agora !
	// 2 - total de pontos no backlog no sprint
	// 3 - total de sprints necessarios para fechar o backlog atual do sprint...

}
