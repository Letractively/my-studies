package br.com.mystudies.service;

import br.com.mystudies.domain.entity.Sprint;

public interface SprintService {

	boolean containsSprintInRun();

	Sprint create(Sprint sprint);

	Sprint getCurrentSprint();

}
