package br.com.mystudies.scala

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {

  	override def deposit(amount: Double) = {
  		if (amount > 1)
  		  super.deposit(amount)
  		else
  		  amount
  	}

  	override def withdraw(amount: Double) = {
  		if (amount > 1)
  			super.withdraw(amount)
  			else
  				amount
  	}
}