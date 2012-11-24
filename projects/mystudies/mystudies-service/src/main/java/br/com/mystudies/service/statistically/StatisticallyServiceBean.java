package br.com.mystudies.service.statistically;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import br.com.mystudies.domain.entity.Sprint;
import br.com.mystudies.service.persistence.SprintDao;

public class StatisticallyServiceBean {

	
	
	@EJB
	private SprintDao sprintDao;
	
	
	public List<Temp> get() {

		
		List<Sprint> sprints = sprintDao.listAll();
		
		return calculeAverage(sprints);
		

	}


	
	private List<Temp> calculeAverage(List<Sprint> sprints) {
		
		long x = 0;
		
		List<Temp> temps = new ArrayList<>();
			
		for (Sprint sprint : sprints) {
			
			x += sprint.getDonePoints();
			
			Temp temp = new Temp();
			temp.setAverage( x / sprint.getId());
			
			temps.add(temp);
		}
		
		
		
		return temps;
	}

	
	
	
	
}
