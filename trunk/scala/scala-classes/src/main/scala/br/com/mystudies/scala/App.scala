package br.com.mystudies.scala
import scala.collection.mutable.ArrayBuffer


object App{

  def main(args : Array[String]) {

	val bankAccount =  new BankAccount;

	// one form to access bankAccount'methods
    bankAccount deposit 10
    bankAccount withdrow

    // another form to access bankAccount'methods
    bankAccount.deposit(10)
    bankAccount.withdrow

    print(bankAccount.total) // accessing a read-only properties in bankAccount

  }

}
