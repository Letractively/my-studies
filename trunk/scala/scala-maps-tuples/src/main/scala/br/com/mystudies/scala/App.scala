package br.com.mystudies.scala
import scala.collection.mutable.Map


object App {

  def applyDiscount(map: Map[String,Double]) = {
  	  for((k,v) <- map)
  	    map(k) = v - v * 0.1

  	    map
  }


  def main(args : Array[String]) {
  	  print(applyDiscount( Map( "pc" -> 20.0, "tv" -> 30.0 , "dvd" -> 10.0 , "cd" -> 5.0 ) ))
  }

}
