package Homework_1;

import java.util.Scanner;

public class Question3
{
	public void answer()
	{
		Scanner kb = new Scanner(System.in);//create scanner object
		System.out.println("Enter you SNN with hyphens seperating numbers");
		String input = kb.nextLine();//get input
		kb.close();//close scanner
		String template ="DDD-DD-DDDD";//Template used to check size
		boolean isValid =true;
		if(input.length() == template.length())
		{
			try// if it can covert to an int its valid if not its not
			{
				String hold = input;// temporary string for substringing
				hold = hold.substring(0,3) + hold.substring(4,6)+hold.substring(7);//Substring for numbers only
				int temp = Integer.parseInt(hold);//convert to int
			}
			catch(Exception e)
			{
				isValid = false;
			}
		}
		else
		{
			isValid = false;
		}
		
		if(isValid)// if valid print is valid
		{
			System.out.println(input+" is a valid social security number");
		}
		else
		{
			System.out.println(input+" is an invalid social security number");
		}
	
		
	}
}
