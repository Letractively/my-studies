package br.com.mystudies.javasete.projectcoin;

public class SwitchWithString {

	public String getString(String letter) {
		
		if(letter == null)
			throw new IllegalArgumentException();
		
		letter = letter.toUpperCase();
		
		switch (letter) {
			case "A":
				return "Ana";
			case "R":
				return "Robson";				
			default:
				return "Don't have name with this letter " + letter;
		}
	}
}
