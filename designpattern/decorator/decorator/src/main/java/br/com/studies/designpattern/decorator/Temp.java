package br.com.studies.designpattern.decorator;

public class Temp {

	public static void main(String[] args){
		Dao dao = new DaoCacheLevelOne( new DaoCacheLevelTwo ( new XMLDao()));		
		System.out.println(dao.getData());		
	}
}
