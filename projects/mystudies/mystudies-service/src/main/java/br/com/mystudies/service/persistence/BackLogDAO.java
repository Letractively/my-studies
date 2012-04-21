package br.com.mystudies.service.persistence;

import br.com.mystudies.domain.entity.BackLog;

/**
 * DAO to {@link BackLog}
 *
 * @author Robson
 */
public interface BackLogDAO {

	/**
	 * update the {@link BackLog}
	 *
	 * @param backLog - that will is update.
	 * @return {@link BackLog} updated.
	 */
	BackLog update(BackLog backLog);


}
