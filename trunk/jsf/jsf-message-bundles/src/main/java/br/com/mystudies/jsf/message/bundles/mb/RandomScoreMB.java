package br.com.mystudies.jsf.message.bundles.mb;

import java.util.Random;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class RandomScoreMB {

	private Random random;

	public RandomScoreMB() {
		random = new Random();
	}
	
	
	public int getScore(){
		return random.nextInt(10);
	}
	
}
