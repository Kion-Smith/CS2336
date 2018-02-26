
/*Kion Smith
 *kls160430
 *CS 2336 - 003
 *
 * Homework 4  PAGE 3*/
package HwTime;

public class MilTime extends Time 
{
	 private int milHours;

	  public MilTime()
	  {
		  milHours = (super.getHours()+12)*100+super.getMinutes();
	  }
	  public MilTime(int mh, int s) 
	  {

		  int hours=0;
		  int minutes=0;
		  
		  milHours = mh;
		  
		  if (mh >= 1200) 
		  {
		  hours = ((mh - 1200) / 100);
		  }
		  else
		  {
		  hours = (mh / 100);
		  }
		  minutes = (mh - (hours * 100));
		  if (hours == 0)
		  hours = 12;
		  
		super.setHours(hours);
		super.setMinutes(minutes);
	    super.setSeconds(s);

	   }
	  public int getMilHours()
	  {
		  return milHours;
	  }
	  public int getStandHr()
	  {
	       return getHours();
	  }
	  public void setMilHours(int mh) 
	  {
		 milHours = mh;
	  }
	  

}
