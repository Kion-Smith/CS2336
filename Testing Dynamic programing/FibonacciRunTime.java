

import java.util.Scanner;

public class FibonacciRunTime 
{
	long startTime =0;
	long endTime =0;
	
	long elapsedDyn=0;
	long elapsedRec =0;
	
	public void runtimes()
	{
		System.out.println("Enter the index of the fib sequence");
		Scanner kb = new Scanner(System.in);
		int input = kb.nextInt();
		boolean isNumeric =false;
		try
		{
			Integer.parseInt(input+"");
			isNumeric = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(isNumeric)
		{
			startTime =System.nanoTime();
			recusive(input);
			endTime =System.nanoTime();
			elapsedRec = endTime - startTime;
			
			startTime =System.nanoTime();
			dynamic(input);
			endTime =System.nanoTime();
			elapsedDyn = endTime - startTime;
			
			System.out.println("Recursion took "+elapsedRec);
			System.out.println("Dynamic took "+elapsedDyn);
		}
		else
		{
			System.out.println("You did not enter a valid number");
		}
		
	}
	
	public int recusive(int index)
	{
		
		if(index<=1)//returning 1 and 0
		{
			return index;
		}
		return recusive(index-1)+recusive(index-2);
	}
	
	public int dynamic(int input)
	{
		int f[] = new int[input+1];
		f[0]=0;
		f[1]=1;
		
		for(int i =2;i<=input;i++)
		{
			f[i] = f[i-1] + f[i-2];
		}
		
		return f[input];
	}
	
}
