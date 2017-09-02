package Homework_1;

import java.util.Scanner;

public class Question1 
{
	/*
	 * Find if a rectangle is inside, or overlaps another
	 */
	public void answer()
	{
		Scanner kb = new Scanner(System.in);//create scanner object
		System.out.println("Enter the x for R1 :: ");
		double r1X =kb.nextDouble();//set double to input
		System.out.println("Enter the y for R1 :: ");
		double r1Y =kb.nextDouble();
		System.out.println("Enter the width for R1 :: ");
		double r1Width =kb.nextDouble();
		System.out.println("Enter the height for R1 :: ");
		double r1Height =kb.nextDouble();
		
		System.out.println("Enter the x for R2 :: ");
		double r2X =kb.nextDouble();
		System.out.println("Enter the y for R2 :: ");
		double r2Y =kb.nextDouble();
		System.out.println("Enter the width for R2 :: ");
		double r2Width =kb.nextDouble();
		System.out.println("Enter the height for R2 :: ");
		double r2Height =kb.nextDouble();
		kb.close();//close stream
		
		double distx = Math.sqrt( Math.pow((r2X-r1X),2) );//distance formula for the x
		double disty = Math.sqrt( Math.pow((r2Y-r1Y),2) );//distance formula for the y
		
		double totalWidth =(r1Width+r2Width)/2; //total width
		double totalHeight =(r1Height+r2Height)/2;//total height
		
		if(distx<totalWidth ^ disty<totalHeight)//xor total width/height is bigger than the distance
		{
			System.out.println("R2 overlaps R1");
		}
		else if(distx+totalWidth <= r1Width && disty+totalHeight <= r1Height)// if the total distance plus the width/height is still smaller than r1 width or height, it is inside the rectangle
		{
			System.out.println("R2 is inside R1");
		}
		else
		{
			System.out.print("R2 doesn't overlap R1");
		}

	}
}
