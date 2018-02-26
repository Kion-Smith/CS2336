/*Kion Smith
 *kls160430
 *CS 2336 - 003
 *
 * Homework 4 PAGE 2*/
 
package HwTime;

abstract public class Time 
{

	private int hours;
	private int minutes;
	private int seconds;
	
	public Time()
	{
		
	}
	public Time(int h, int m, int s)
	{

		hours = h;
		minutes = m;
		seconds = s;

	}
	public int getHours() 
	{
		return hours;
	}
	public int getMinutes() 	
	{
		return minutes;
	}
	public int getSeconds() 
	{
		return seconds;
	}
	
	public void setHours(int h) 
	{
		hours = h;
	}
	public void setMinutes(int m)
	{
		 minutes = m;
	}
	
	public void setSeconds(int s) 
	{
		seconds = s;
	}

}
