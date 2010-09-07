package br.com.fiapbank.persistencia.dao.hibernate.temp;

import br.com.fiapbank.dominio.Cargo;
import br.com.fiapbank.dominio.Conta;
import br.com.fiapbank.dominio.Funcionario;
import br.com.fiapbank.dominio.TipoDeConta;
import br.com.fiapbank.persistencia.dao.ContaDao;
import br.com.fiapbank.persistencia.dao.DaoException;
import br.com.fiapbank.persistencia.dao.FuncionarioDao;
import br.com.fiapbank.persistencia.dao.db.DBManager;
import br.com.fiapbank.persistencia.dao.db.DBManagerException;
import br.com.fiapbank.persistencia.dao.db.DBManagerJPA;
import br.com.fiapbank.persistencia.dao.hibernate.jpa.ContaDaoJPAHibernate;
import br.com.fiapbank.persistencia.dao.hibernate.jpa.FuncionarioDaoJPAHibernate;

public class Temp {

	//TODO: remover pacote e classe depois
	
	public static void main(String[] args) throws DBManagerException, DaoException {
		
		
		DBManager dbManager = new DBManagerJPA();
		
		dbManager.init();
	
		FuncionarioDao dao = new FuncionarioDaoJPAHibernate();
	
		Funcionario funcionario = new Funcionario();
		
		funcionario.setCargo(Cargo.CAIXA);
		funcionario.setLogin("caixa");
		funcionario.setSenha("caixa");
		
		dao.insert(funcionario);
	}
}
