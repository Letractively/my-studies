package br.com.mystudies.scala
import scala.collection.mutable.Map
import scala.io.Source
import scala.collection.mutable.HashMap


object App {

  def applyDiscount(map: Map[String,Double]) = {
  	  for((k,v) <- map)
  	    map(k) = v - v * 0.1

  	    map
  }


  def main(args : Array[String]) {
  	  print(applyDiscount( Map( "pc" -> 20.0, "tv" -> 30.0 , "dvd" -> 10.0 , "cd" -> 5.0 ) ))


  	  val map = new HashMap[String,Int]

  	  val words =  Source.fromFile("words.txt")


  	  for( word <- words getLines ){
  	    map put( word , 1  )
  	  }

  	  println(map)
  	  println(map size)

  }

}
