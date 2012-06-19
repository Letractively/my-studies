package br.com.hotel.integration;

import java.io.Serializable;

public class HotelIntegrationFilter implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int stars;
	private String destino; // TODO: em english




	public HotelIntegrationFilter(int stars, String destino) {
		super();
		this.stars = stars;
		this.destino = destino;
	}


	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
}
