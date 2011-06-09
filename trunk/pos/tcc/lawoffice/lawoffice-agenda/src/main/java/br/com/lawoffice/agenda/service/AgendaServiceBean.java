/**
 * 
 */
package br.com.lawoffice.agenda.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.commons.lang.time.DateUtils;

import br.com.lawoffice.agenda.dao.EventoDAO;
import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Evento;

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
	private EventoDAO eventoDAO;
	
	
	
	@Override
	public List<Evento> listarEventos(Colaborador colaborador, Date dataIncial, Date dataFinal){
		if(dataIncial == null || dataFinal == null)
			return new ArrayList<Evento>();
		return eventoDAO.listarEventos(colaborador, dataIncial, dataFinal);
	}

	
	
	@Override
	public Evento adicionarEvento(Colaborador colaborador, Evento evento) {
		return eventoDAO.adicionarEvento(colaborador, evento);
	}

	
	@Override
	public Evento atualizarEvento(Evento evento){
		return eventoDAO.atualizarEvento(evento);
	}

	
	@Override
	public void removerEvento(Evento evento) {
		eventoDAO.removerEvento(evento);
	}	
}
