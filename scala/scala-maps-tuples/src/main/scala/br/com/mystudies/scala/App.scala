package br.com.mystudies.scala
import scala.collection.mutable.Map
import scala.io.Source
import scala.collection.mutable.HashMap
import scala.collection.immutable.TreeMap
import scala.collection.mutable.LinkedHashMap



object App {

  def applyDiscount(map: Map[String,Double]) = {
  	  for((k,v) <- map)
  	    map(k) = v - v * 0.1

  	    map
  }


  def getWeekDay(day: Int) = {
    val weekdays = LinkedHashMap( 1 -> "Monday", 2 -> "Tuesday", 3 -> "Wednesday", 4 -> "Thursday",  5 -> "Friday", 6 -> "Sartuday", 7 -> "Sunday" )
    weekdays(day)
  }
  
  
  def main(args : Array[String]) {
    
  	  println(applyDiscount( Map( "pc" -> 20.0, "tv" -> 30.0 , "dvd" -> 10.0 , "cd" -> 5.0 ) ))


  	  val map = new HashMap[String,Int]

  	  val words =  Source.fromFile("words.txt")


  	  for( word <- words getLines ){
  	    map put( word , 1  )
  	  }

  	  println(map)
  	  println(map size)
  	  println(map toMap ) // immutable map
      println(TreeMap(map.toMap.toArray:_*) ) // mutable map to immutable map to sorted map ( immutable then  ) but I travled in (  :_* )I taked example in stackoverflow.
      println(getWeekDay(1))
      println(getWeekDay(2))
      
  	  

  }

  
}
