package br.com.mystudies.scala

class BankAccount(initialBalance: Double){
	private var balance = initialBalance
	def deposit(amount: Double) = { balance += amount; balance}
	def withdraw(amount: Double) = { balance -= amount; balance}
}