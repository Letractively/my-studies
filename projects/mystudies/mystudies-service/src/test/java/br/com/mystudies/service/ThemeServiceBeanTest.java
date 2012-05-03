package br.com.mystudies.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.mystudies.domain.entity.Theme;
import br.com.mystudies.service.persistence.ThemeDao;

public class ThemeServiceBeanTest {


	@InjectMocks
	private ThemeServiceBean themeServiceBean;


	@Mock
	private ThemeDao themeDao;


	@Before
	public void setUp() throws Exception {
		themeServiceBean = new ThemeServiceBean();
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
		themeServiceBean = null;
	}


	@Test
	public void shouldGetThemeByID() {

		when(themeDao.find(any(Long.class))).thenReturn(new Theme());

		Theme theme = themeServiceBean.getTheme(1L);

		verify(themeDao).find(1L);

		assertNotNull(theme);
	}

}
