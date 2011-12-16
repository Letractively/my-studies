package br.com.mystudies.javaseven.projectcoin;

import br.com.mystudies.javaseven.projectcoin.exception.ExceptionCheckedOne;
import br.com.mystudies.javaseven.projectcoin.exception.ExceptionCheckedTwo;

public class MultiCatch {

	public void execute(Object object, Object object2) throws ExceptionCheckedOne, ExceptionCheckedTwo {	
		try {
			verifyOne(object);
			verifyTwo(object2);
		} catch (ExceptionCheckedOne | ExceptionCheckedTwo e) {
			throw e;
		}
	}

	private void verifyOne(Object object) throws ExceptionCheckedOne{
		if(object == null)
			throw new ExceptionCheckedOne();
	}

	private void verifyTwo(Object object) throws ExceptionCheckedTwo {
		if(object == null)
			throw new ExceptionCheckedTwo();
	}
	
}
