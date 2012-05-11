package br.com.mystudies.service;

import br.com.mystudies.domain.entity.Sprint;
import br.com.mystudies.domain.enun.SprintStatus;

public class SprintServiceBean implements SprintService{

	
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
	
}
