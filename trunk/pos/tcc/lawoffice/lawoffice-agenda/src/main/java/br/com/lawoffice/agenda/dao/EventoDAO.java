package br.com.lawoffice.agenda.dao;

import java.util.Date;
import java.util.List;

import br.com.lawoffice.dominio.Colaborador;
import br.com.lawoffice.dominio.Evento;

/**
 * 
 * Interface DAO para o {@link Evento}.
 * 
 * 
 * @author robson
 *
 */
public interface EventoDAO {

	List<Evento> listarEventos(Colaborador colaborador, Date dataIncial, Date dataFinal);
	
	Evento adicionarEvento(Colaborador colaborador, Evento evento);
	
	
	Evento atualizarEvento(Evento evento);
	
	
	void removerEvento(Evento evento);
}
