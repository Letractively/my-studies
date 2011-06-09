package br.com.lawoffice.agenda.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Evento;



@Stateless
@Local(EventoDAO.class)
public class EventoDAOBean implements EventoDAO {

	
	@Override
	public List<Evento> listarEventos(Colaborador colaborador, Date dataIncial, Date dataFinal){
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Evento adicionarEvento(Colaborador colaborador, Evento evento){
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Evento atualizarEvento(Evento evento) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void removerEvento(Evento evento) {
		// TODO Auto-generated method stub
	}

}
