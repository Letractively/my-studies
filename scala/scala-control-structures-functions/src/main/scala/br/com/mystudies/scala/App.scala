package br.com.mystudies.scala



object App {

  def signum( n: Int )  = { if (n > 0) 1 else if (n < 0) -1 else 0 }

  def unit() = {}

  def loop(n: Int) = {for(i <- 1 to n){print(i)} }


  def main(args : Array[String]) {
    println( signum(10) )
    println( signum(-10) )
    println( signum(0) )
    println( unit() )
    loop(10)
  }

}
