package br.com.mystudies.service;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.mystudies.domain.entity.Story;
import br.com.mystudies.service.persistence.StoryDao;

@Stateless
@Remote(StoryService.class)
public class StoryServiceBean implements StoryService {

	@EJB
	private StoryDao storyDao;
	
	
	@Override
	public Story getStory(Long id) {
		// FIXME: validate parameters
		return storyDao.getStory(id);
	}

}
