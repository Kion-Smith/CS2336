package Homework_2;

import java.util.Scanner;

public class HW2Quesstion1 
{
	int[] userArray;
	public void answer()
	{
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a lenght of list ");
		int length = kb.nextInt();
		
		userArray = new int[length];
		
		for(int i=0;i<length;i++)
		{
			if(i!=0)
			{
				System.out.println("Enter the "+(i+1)+" element");
				userArray[i] = kb.nextInt();
			}
			else
			{
				System.out.println("Enter the partition");
				userArray[0] = kb.nextInt();
			}
		}
		
		partition(userArray);
		
		for(int i=0;i<userArray.length;i++)
		{
			System.out.print(userArray[i] +" ");
		}
	}
	public static int partition(int[] list)
	{
		int partLoc =0;
		
		for(int i =list.length-1;i>partLoc;)
		{
			if(list[partLoc]>list[partLoc+1])
			{
				int temp = list[partLoc];
				list[partLoc] = list[partLoc+1];
				list[partLoc+1] = temp;
				partLoc++;
			}
			else
			{
				int temp = list[i];
				list[i] = list[partLoc+1];
				list[partLoc+1] = temp;
				i--;
			}
		}
		return partLoc;
	}
}
