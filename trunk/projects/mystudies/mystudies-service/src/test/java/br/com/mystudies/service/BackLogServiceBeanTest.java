/**
 *
 */
package br.com.mystudies.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.mystudies.domain.entity.BackLog;
import br.com.mystudies.domain.entity.Theme;
import br.com.mystudies.service.persistence.BackLogDAO;

/**
 * unit test to {@link BackLogServiceBean}
 *
 * @author Robson
 *
 */
public class BackLogServiceBeanTest {


	@InjectMocks
	private BackLogServiceBean backLogServicebean;


	@Mock
	private BackLogDAO backlogDAO;


	@Before
	public void setUp() throws Exception {
		backLogServicebean = new BackLogServiceBean();
		MockitoAnnotations.initMocks(this);
	}


	@After
	public void tearDown() throws Exception {
		backLogServicebean = null;
	}


	@Test
	public void shouldAddThemeInBackLog() {

		BackLog backLog = new BackLog();
		Theme theme = new Theme();

		when(backlogDAO.update(backLog)).thenReturn(backLog);

		backLog = backLogServicebean.addTheme(backLog, theme);

		verify(backlogDAO).update(backLog);

		assertEquals(backLog.getThemes().get(0), theme);

	}

}
