package br.com.mystudies.rmi.service;

import java.io.Serializable;

public class Produto implements Serializable{

	private String nome;
	private Integer numero;
	

	public Produto(String nome, Integer numero) {
		super();
		this.nome = nome;
		this.numero = numero;
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
	
	
}
