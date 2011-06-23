/**
 * 
 */
package br.com.lawoffice.agenda.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Evento;
import br.com.lawoffice.persistencia.EventoDao;

/**
 * 
 * Implentação do serviço de {@link AgendaService} utilizando tecnologia EJB 3.1.
 * 
 * @author robson
 *
 */
@Stateless
@Local(AgendaServiceLocal.class)
@Remote(AgendaServiceRemote.class)
public class AgendaServiceBean implements AgendaService {

	
	@EJB
	private EventoDao enventoDao;
	
	
	@Override
	public List<Evento> listarEventos(Colaborador colaborador, Date dataIncial, Date dataFinal){
		if(colaborador == null || dataIncial == null || dataFinal == null)
			return new ArrayList<Evento>();
		if(enventoDao.localizar(Colaborador.class, colaborador) == null)
			return new ArrayList<Evento>();
		return enventoDao.getEventos(colaborador, dataIncial, dataFinal);
	}

	
	
	@Override
	public Evento adicionarEvento(Colaborador colaborador, Evento evento) {
		return null;
	}

	
	@Override
	public Evento atualizarEvento(Evento evento){
		return null;
	}

	
	@Override
	public void removerEvento(Evento evento) {
	}



	public void setEnventoDao(EventoDao enventoDao) {
		this.enventoDao = enventoDao;
	}
	
}
