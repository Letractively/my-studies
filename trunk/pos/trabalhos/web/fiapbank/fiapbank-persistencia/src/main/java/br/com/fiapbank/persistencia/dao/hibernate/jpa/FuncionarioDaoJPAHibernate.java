/**
 * 
 */
package br.com.fiapbank.persistencia.dao.hibernate.jpa;

import org.hibernate.criterion.Restrictions;

import br.com.fiapbank.dominio.Funcionario;
import br.com.fiapbank.persistencia.dao.DaoException;
import br.com.fiapbank.persistencia.dao.FuncionarioDao;

/**
 * @author robson
 *
 */
public class FuncionarioDaoJPAHibernate extends GenericDaoJPAHibernate<Funcionario> implements FuncionarioDao {


	@Override
	public Funcionario getFuncionarioAutenticado(Funcionario funcionario)throws DaoException {
		try {
			return (Funcionario) getSessionHibernate().createCriteria(Funcionario.class)
				.add(Restrictions.eq("senha", funcionario.getSenha()))
				.add(Restrictions.eq("login", funcionario.getLogin()))
				.uniqueResult();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

}
