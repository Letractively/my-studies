/**
 * 
 */
package br.com.fiapbank.persistencia.dao.hibernate.jpa;

import org.hibernate.criterion.Restrictions;

import br.com.fiapbank.dominio.Conta;
import br.com.fiapbank.persistencia.dao.ContaDao;
import br.com.fiapbank.persistencia.dao.DaoException;

/**
 * @author robson
 *
 */
public class ContaDaoJPAHibernate extends GenericDaoJPAHibernate<Conta> implements ContaDao {


	@Override
	public Conta getContaAutenticada(Conta conta) throws DaoException {
		try {
			return (Conta) getSessionHibernate()
			.createCriteria(Conta.class)
				.add( Restrictions.eq("numero", conta.getNumero() ))
				.add( Restrictions.eq("numeroAgencia", conta.getNumeroAgencia()))
				.add( Restrictions.eq("senha", conta.getSenha()))
				.add( Restrictions.eq("fraseSecreta", conta.getFraseSecreta()))
				.uniqueResult();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}


	@Override
	public Conta getContaPorNumeroAgencia(Conta conta) throws DaoException{
		try {
			if(conta == null)
				throw new IllegalArgumentException("Conta nulla");
			return (Conta) getSessionHibernate()
						.createCriteria(Conta.class)
							.add( Restrictions.eq("numero", conta.getNumero() ))
							.add( Restrictions.eq("numeroAgencia", conta.getNumeroAgencia()))
							.uniqueResult();
											
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}
