package br.com.mystudies.service;

import br.com.mystudies.domain.entity.Sprint;
import br.com.mystudies.domain.entity.Story;

public interface SprintService {

	boolean containsSprintInRun();

	Sprint create(Sprint sprint);

	Sprint getCurrentSprint();

	Sprint addStoryInSprint(Story story);

}
