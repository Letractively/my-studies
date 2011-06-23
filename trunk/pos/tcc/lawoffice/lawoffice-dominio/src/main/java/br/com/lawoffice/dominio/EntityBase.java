package br.com.lawoffice.dominio;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * 
 * Interface base para as entidades de dominio.
 * 
 * @author robson
 */
public interface EntityBase extends Serializable{

	/**
	 * 
	 * Retorna o ID da Entidade.
	 * 
	 * 
	 * @return {@link Long} - ID da Entidade.
	 */
	Long getId();
}
