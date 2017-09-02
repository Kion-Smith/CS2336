package Homework_1;

import java.util.Scanner;

public class Question2 
{
	/*
	 * Create random lotto number and verify with user input
	 */
	public void answer()
	{
		Scanner kb = new Scanner(System.in);//scanner object
		int lottoNum = 101+(int)(Math.random()*(1000-101));//random num from 100 - 999
		System.out.println("Enter a 3 digit number");
		int input = kb.nextInt();//save user input
		kb.close();//close scanner
		
		int digit3 = input /100;//hundreds
		int digit2 = (input %100)/10;//tens
		int digit1 = input %10;//ones
		
		int lottoNum1 = lottoNum/100;//same as above
		int lottoNum2 = (lottoNum%100)/10;
		int lottoNum3 = lottoNum%10;
		
		
		System.out.println("The lotto number was "+lottoNum+". Your number was "+input);
		if(input == lottoNum)// if they are the same number run this
		{
			System.out.println("All in order,you won $10,000 ");
		}
		//If checking each possibility and only works if all are right
		else if( (digit1 == lottoNum1 ||digit2 == lottoNum1 ||digit3 == lottoNum1 )&&(digit1 == lottoNum2 ||digit2 == lottoNum2 ||digit3 == lottoNum3 )&&(digit1 == lottoNum3 ||digit2 == lottoNum3 ||digit3 == lottoNum3 ) )
		{
			System.out.println("3 matches not in order,you won $3,000 ");
		}
		//check for if any are right
		else if(digit1 == lottoNum1 ||digit2 == lottoNum1 ||digit3 == lottoNum1||digit1 == lottoNum2 ||digit2 == lottoNum2 ||digit3 == lottoNum3|| digit1 == lottoNum3 ||digit2 == lottoNum3 ||digit3 == lottoNum3 )
		{
			System.out.println("At least 1 match,you won $1,000 ");
		}
		else
		{
			System.out.println("Not a single match, you win nothing");
		}
		
	
		
		
	}
}
