package br.com.lawoffice.dados;

import java.util.List;

/**
 * 
 * Serviço de Dados (CRUD)
 * 
 * TODO: esse nome não está legal , hoje é segunda e não estou inspirado
 * 
 * @author robson
 *
 */
public interface Dados {
	
	public <T> T atualizar(T t);

	
	public <T> void remover(Class<T> t, long id);
	
	// TODO: idem ao nome da interface
	public <T> T localizar(Class<T> t, long id);
	
	
	public <T> T salvar(T T);
	
	
	public <T> List<T> listar(Class<T> c);
	
}
