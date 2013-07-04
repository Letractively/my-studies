
package br.com.mystudies.scala.app

import br.com.mystudies.scala.BankAccount
import br.com.mystudies.scala.CheckingAccount

object Main extends App {

	val ca = new CheckingAccount(3)

	println(ca deposit(-1))
	println(ca deposit(2))

	println(ca withdraw(-1))
	println(ca withdraw(2))

}