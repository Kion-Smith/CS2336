package General;

public class Testing 
{
	/**/
	public static void main (String [] args)
	{
		int i;
		for (i=0; i<10; i++);//still runs just dosen't print out all if <= would print 11 instead of 10,
		{					//yes I am right
		  System.out.println("i is " + i);
		}
	}/*
	//////////////////////////////////////////////////////////////
	public static void main(String[] args) 
	{
	    System.out.println(max(1, 2));  //error dosen't know which method to use because 2 could also be a double, so its and ambiguous error
	}
	
	  public static double max(int num1, double num2) 
	  { 
	    if (num1 > num2)
	      return num1;
	    else
	      return num2;
	  }
	  
	  public static double max(double num1, int num2) 
	  {
	    if (num1 > num2)
	      return num1;
	    else
	      return num2;     
	  }
	  */
	/*
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4,5,6,7,8,9};
		int[] anotherArray = new int[11];
		
		
		System.arraycopy(array, 0, anotherArray, 0, array.length);
		for(int i =0;i<anotherArray.length-1;i++)
		{
			System.out.println(anotherArray[i]);
		}
	}
	*/
	
}
