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

    println(bankAccount.total) // accessing a read-only properties in bankAccount


    val time1 = new Time(20,21,24)
    val time2 = new Time(20,21,23)

    println(time1 before time2)

  }

}
