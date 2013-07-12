
package br.com.mystudies.scala.app


import br.com.mystudies.scala.animals.Fish
import br.com.mystudies.scala.animals.Amphibian
import br.com.mystudies.scala.animals.Mammal
import br.com.mystudies.scala.bank.CheckingAccount

object Main extends App {

	val ca = new CheckingAccount(3)

	println(ca deposit(-1))
	println(ca deposit(2))

	println(ca withdraw(-1))
	println(ca withdraw(2))

	
	val cod = new Fish("cod", "salinity")
	val frog = new Amphibian("frog", "green")
	val human = new Mammal("Robson", 1.82)
	
	println(cod)
	println(frog)
	println(human)
		
}