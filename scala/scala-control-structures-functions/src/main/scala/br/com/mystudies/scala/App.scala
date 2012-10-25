package br.com.mystudies.scala



object App {

  def signum( n: Int )  = { if (n > 0) 1 else if (n < 0) -1 else 0 }

  def main(args : Array[String]) {
    println( signum(1) )
    println( signum(-1) )
    println( signum(0) )
  }

}
