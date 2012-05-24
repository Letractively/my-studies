package br.com.mystudies.service;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.mystudies.domain.entity.Sprint;
import br.com.mystudies.domain.enun.SprintStatus;

@Stateless
@Remote(SprintService.class)
public class SprintServiceBean implements SprintService{

	
	@EJB
	private SprintDao sprintDao;
	
	
	@Override
	public boolean containsSprintInRun() {
		
		Sprint sprint = 
				sprintDao.findSprintByStatus(SprintStatus.RUNNING);
		
		if(sprint != null){
			return true;
		}
				
		return false;
	}


	
	@Override
	public Sprint create(Sprint sprint) {
		
		if(containsSprintInRun())
			throw new IllegalStateException("Contains sprint in running");
		
		// FIXME: validate parameters
		
		return sprintDao.persist(sprint);
	}



	@Override
	public Sprint getCurrentSprint() {		
		return sprintDao.findSprintByStatus(SprintStatus.RUNNING);
	}
	
	
}
