package br.com.mystudies.jsf.composite.transacao;

public class Transacao {

	public String nome;

	
	public Transacao() {
		super();
	}


	public Transacao(String nome) {
		super();
		this.nome = nome;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
