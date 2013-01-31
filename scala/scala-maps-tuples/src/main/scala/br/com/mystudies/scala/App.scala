package br.com.mystudies.scala
import scala.collection.mutable.Map
import scala.io.Source
import scala.collection.mutable.HashMap
import scala.collection.immutable.TreeMap
import scala.collection.mutable.LinkedHashMap
import scala.sys.SystemProperties



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


  def printSystemProperties(){
	 for((k,v) <- new SystemProperties().toMap){
	   println(k + " | " + v )
	 }
  }


  def minMax(values: Array[Int]) = {
    Map("Max" -> values.max, "Min" -> values.min )
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
      printSystemProperties
      print(minMax(Array(2, 1, 4, -10, 3, 5, 8, 100)))

  }


}
