package br.com.lawoffice.dados;

import java.util.List;

import br.com.lawoffice.dominio.Pessoa;

/**
 * 
 * TODO: javadoc 
 * 
 * @author robson
 *
 */
public interface DadosPessoa {

	public <T extends Pessoa> List<T> listarPorNome(Class<T> c,  String nome);
}
