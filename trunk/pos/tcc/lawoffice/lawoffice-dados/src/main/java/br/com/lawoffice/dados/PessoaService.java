package br.com.lawoffice.dados;

import java.util.List;

import br.com.lawoffice.dominio.Pessoa;

/**
 * 
 * Interface de servico de dados cadastrais para {@link Pessoa} do escritorio.
 * 
 * @author robson
 *
 */
public interface PessoaService {

	public <T extends Pessoa> List<T> listarPorNome(Class<T> c,  String nome);
	
	public <T extends Pessoa> T atualizar(T t);
	
	public <T extends Pessoa> void remover(Class<T> c, T t);
	
	public <T extends Pessoa> T localizar(Class<T> c, T t);
	
	public <T extends Pessoa> T salvar(T t);
	
	public <T extends Pessoa> List<T> listar(Class<T> c);
}
