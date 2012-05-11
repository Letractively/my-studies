package br.com.mystudies.service;

import br.com.mystudies.domain.entity.Sprint;
import br.com.mystudies.domain.enun.SprintStatus;

public interface SprintDao {

	Sprint findSprintByStatus(SprintStatus running);

}
