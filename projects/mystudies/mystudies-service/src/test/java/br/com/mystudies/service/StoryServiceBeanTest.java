package br.com.mystudies.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.mystudies.domain.entity.Story;
import br.com.mystudies.service.persistence.StoryDao;

public class StoryServiceBeanTest {

	
	@InjectMocks
	private StoryServiceBean storyServiceBean;
	
	
	@Mock
	private StoryDao storyDao;
	
	
	@Before
	public void setUp() throws Exception {
		storyServiceBean = new StoryServiceBean();
		initMocks(this);
	}

	
	@After
	public void tearDown() throws Exception {
		storyServiceBean = null;
	}

	
	@Test
	public void shouldGetThemeByID() {
		
		when(storyDao.getStory(any(Long.class))).thenReturn(new Story());
		
		Story story = storyServiceBean.getStory(1L);
		
		verify(storyDao).getStory(1L);
		
		assertNotNull(story);
	}

}
