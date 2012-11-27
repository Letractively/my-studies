package br.com.mystudies.scala


object App{
  
  
  def ex2 = {
    
	  val x = Array(2, 1, 4, 3, 5, 8)
	  
	  
	  for( i <- 0 until x.length )	    
		if( i % 2 != 0){
			var y = x(i-1)
			x(i-1) = x(i) 
			x(i) = y
		}
	    
      for(i <- x )
        print(i)
    
  }
  
  def ex3 = {
		  
	   val x = Array(2, 1, 4, 3, 5, 8)
				  				  
		for( i <- 0 until x.length if i % 2 != 0 ) yield x(i) 	    
 			  
  }
  
  
  
  

  def main(args : Array[String]) {    
	  	//ex2
	  	
	  	for( x <- ex3)
	  		print(x)
	  	
  }

  
}
