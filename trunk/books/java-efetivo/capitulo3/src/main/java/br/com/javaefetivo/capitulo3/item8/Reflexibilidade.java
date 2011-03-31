package br.com.javaefetivo.capitulo3.item8;

/**
 * 1° requisito que ao sobrepor o método equals , vide página 32 e 33
 * 
 * @author robson
 *
 */
public class Reflexibilidade {

	@Override
	public boolean equals(Object object){
		return this == object; // dado x != de nullo x.equals(x) deve ser true
	}
}
