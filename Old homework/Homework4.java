/*Kion Smith
 *kls160430
 *CS 2336 
 *
 * Homework 4
 */
import HwTime.*;
import java.util.*;

public class Homework4
{
	public static void main(String [] args)
	{
	     Scanner kb = new Scanner(System.in);
	     
	     System.out.println("Enter hour");
	     int h = hours();
	     System.out.println("Enter seconds");
	     int s = seconds();
	     
	     MilTime m = new MilTime(h, s);

	       System.out.println("Military time"+ m.getMilHours());
	       System.out.println("Hours" + m.getStandHr());
	       System.out.println("Minutes" + m.getMinutes());
	       System.out.println("Seconds" + m.getSeconds());

	       System.out.println("Enter start time hour");
	       int sh = hours();
	       System.out.println("Enter start time seconds");
	       int ss = seconds();
	       System.out.println("Enter the end time hour");
	       int es = hours();
	       System.out.println("Enter the end time second");
	       int  ess = seconds();
	       
	      TimeClock t = new TimeClock(sh, ss, es, ess);
	     
	       System.out.println("Start Time" + t.getStartMilHours());
	       System.out.println("End Time" + t.getEndMilHours());
	       System.out.println("Time Difference " + t.timeDifference());
	}
	public static int seconds()
	{	int s;
		Scanner kb = new Scanner(System.in);
		s = kb.nextInt();
		
		if(s <=0 && s >= 59)
		{
			System.out.println("Either your number was not numeric or was not within the range 0 - 59,try again");
			seconds();
		}
		
		return s;
	}
	public static int hours()
	{	int h;
		Scanner kb = new Scanner(System.in);
		h = kb.nextInt();

			
	       if(h >=0 && h <= 2359)
	       {
	    	   if(h%100 >=60 && h%100 <= 99)
	    	   {
	    		   System.out.println("Either your number was not numeric or was within the range 60 - 99 which is incorrect,try again");
	    		   hours();
	    	   }
	  
	       }
	       else
	       {
	    	   System.out.println("Either your number was not numeric or was not within the range of 0 - 2359,try again");
    		   hours();
	       }
	       
	       return h;
	}
}
