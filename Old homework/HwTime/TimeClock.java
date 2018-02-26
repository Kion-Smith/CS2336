/*Kion Smith
 *kls160430
 *CS 2336 - 003
 *
 * Homework 4 PAGE 4*/
package HwTime;

public class TimeClock extends MilTime
{
	private int milHours;

	 private int seconds;

	  

	   public TimeClock(int startMilHours, int startSeconds, int endMiltime, int endSecondsTime) {

	       super(startMilHours, startSeconds);

	       milHours = endMiltime;
	       seconds = endSecondsTime;

	   }

	   public int getEndMilHours() 
	   {

	       return milHours;
	   }

	   public int getEndSeconds()
	   {
	       return seconds;
	   }
	   public int getStartSeconds() 
	   {
	       return getSeconds();
	   }  
	   public int getStartMilHours() 
	   {
	       return getMilHours();
	   }
	   public void setEndMilHours(int mh) 
	   {
	      milHours = mh;
	   }

	   public void setEndSeconds(int s) 
	   {
	       seconds =s;
	   }
	   public void setStartMilHours(int mh) 
	   {
	       super.setMilHours(mh);
	   }

	   public void setStartSeconds(int s) 
	   {
	       super.setSeconds(s);
	   }

	   public double timeDifference()
	   {
	       return (getEndMilHours() - getStartMilHours())/100;

	   }
}
