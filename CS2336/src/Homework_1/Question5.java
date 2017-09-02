package Homework_1;

import java.util.Scanner;

public class Question5 
{
	
	/*
	 * Validate credit card numbers
	 */
	public void answer()
	{
		Scanner kb = new Scanner(System.in);//Create scanner
		System.out.println("Enter you credit card number::");
		long card = kb.nextLong();//users input for long
		kb.close();//close stream
		
		if(isValid(card))// if card is true then valid
		{
			System.out.println(card+" is valid");
		}
		else
		{
			System.out.println(card+" is invalid");
		}
	}
	
	// Return true if the card number is valid
	public static boolean isValid(long number)
	{
		int total = sumOfDoubleEvenPlace(number)+sumOfOddPlace(number);//add the total as stated by step 4
		//make sure the sum is a multiple of ten,check size is bettween 13 and 16, then check prefixes are valid
		if((total%10 == 0) && getSize(number)>=13 && getSize(number)<=16 && ( prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37) || prefixMatched(number, 6)) ) 
		{		
			return true;
		}
		return false;
	}
	 //Adds up all the Double places
	public static int sumOfDoubleEvenPlace(long number)
	{
		int sum=0;
		String cardNum = number+"";
		String temp ="";
		for(int i = getSize(number)-2;i>=0;i-=2)
		{
			temp = cardNum.charAt(i)+""; //covert to a string
			sum += getDigit(Integer.parseInt(temp)*2);
		}
		return sum;
	}
	 // if the digit is more than nine add it back to the number
	public static int getDigit(int number)
	{
		if(number<=9)
		{
			return number;
		}
		else
		{
			number =(number/10)+(number%10);// add the tens and ones place
		}
		return number;
	}
	//add all the odd places
	public static int sumOfOddPlace(long number)
	{
		int sum=0;
		String cardNum = number+"";
		String temp ="";
		for(int i = getSize(number)-1;i>=0;i-=2)
		{
			temp = cardNum.charAt(i)+""; //same as in addEvens
			sum += getDigit(Integer.parseInt(temp));
		}
		return sum;
	}
	//Check that the prefixed numbers match
	public static boolean prefixMatched(long number, int d)
	{
		if(getPrefix(number, getSize(d)) == d)// if the k return is equal to the prefix number then it is valid
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	 //Get length of card number
	public static int getSize(long d) 
	{
		String temp = d+"";//Temporally convert to string to get length function to count
		return temp.length();
	}
	//If the size of get number is greater than k then convert and return k
	public static long getPrefix(long number, int k) 
	{
		
		if(getSize(number)>k)
		{
			String temp = number+"";
			return Long.parseLong(temp.substring(0, k));//convert to long(substringed in case it needs to for a number like 37) 
		}
		return number;
	}
}
