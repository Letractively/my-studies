/**
 * 
 */
package br.com.fiapbank.persistencia.dao.hibernate.jpa;

import java.util.List;

import br.com.fiapbank.dominio.EntidadeBase;
import br.com.fiapbank.persistencia.dao.DaoException;
import br.com.fiapbank.persistencia.dao.GenericaDao;



/**
 * @author robson.oliveira
 *
 * @param <T>
 */
public  class GenericDaoJPAHibernate<T extends EntidadeBase> extends BaseDaoJPAHibernate implements GenericaDao<T>{


	@Override
	public void delete( T t ) throws DaoException{
		try {			
			begin(); 
			getEntityManager().remove(find(t));
			commit();			
		} catch (Exception e){			
			rollback();			
			throw new DaoException(e);			
		}finally{			
			close();
		}		
	}
	
	

	@Override
	@SuppressWarnings("unchecked")
	public T find( T t ) throws DaoException{		
		try {			
			return (T) getEntityManager().find(t.getClass(),t.getId());				
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}



	@Override
	public T insert( T t) throws DaoException{		
		try {			
			begin();
			getEntityManager().persist(t);
			commit();
			return t;						
		} catch (Exception e) {
			rollback();
			throw new DaoException(e);			
		}finally{			
			close();
		}		
	}



	@Override
	public T update(T t) throws DaoException{		
		try {
			begin();
			t = getEntityManager().merge(t);
			commit();
			return t;
		} catch (Exception e) {
			rollback();
			throw new DaoException(e);			
		}finally{			
			close();
		}
	}		
}
