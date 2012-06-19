package br.com.hotel.domain;

import java.io.Serializable;

public class Hotel implements Serializable{

	private String name;
	private int stars;



	public Hotel(String name, int stars) {
		super();
		this.name = name;
		this.stars = stars;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

}
