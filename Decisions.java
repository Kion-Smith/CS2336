/**
 * @(#)Decisions.java
 *
 *
 * @author 
 * @version 1.00 2010/2/19
 */


public class Decisions 
{
	public static void main ( String [] args )
	{
		int x = 50, y = 40;    //just so we have something to work with
		
		
		//simple ifs just like in Jerro
			//use this to check simple conditions
			
		if ( x > 50 )
		{
	
		  System. out.println("Got Here!");
		  System. out.println("Got Here!");
		}
		if ( x > 55 )
		  System. out.println("You did not get Here!");

		
		
		
		//if else just like in Jerro  
			//use this to check 
		if ( x > 40 ) 
		  System.out.println("Bingo");
		else
	      System.out.println("Failure");
		  
		  
		  
		  
		//else if just like in Jeroooooooo
		  //use this when you need to check an entire list of conditions and only one must be chosen
		  //BECAREFUL how you arrange them --- it is like a sieve
		 if( x > 60 &&  y < 100 ) 
		 	System.out.println("Stopped at level one");
		 else if ( x > 50 )
		    System.out.println("Stopped at level two");
		 else if( x > 40 )
		  	System.out.println("Stopped at level three");
		 else
		 	System.out.println("You made it completely through"); 	
		  	
		  	
		  String word  = "abcdefg";
		  String word2 = "ABCDEFG";	
		  	
		  
		  if( word.equals( word2.toLowerCase() ) )
		  	System.out.println("Got innnnn");
		  	
	}

    
}