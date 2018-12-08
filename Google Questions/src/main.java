import java.util.ArrayList;

public class main 
{
	public static void main(String[] args)
	{
	
		//int A[] = {10,13,12,14,15};
	//	solution(A);
		
		int S[] = {1,2,6,5,3};
		int E[] = {5,5,7,6,8};
		
		solution(S,E);
	}
	
	 public static int solution(int[] A) 
	 {
		 int count =0;
		 
		 for(int i =0;i<A.length;i++)
		 {
			 if(i%2 == 0)
			 {
				 if(A[i]<A[i+2] )
				 {
					 
				 }
				
			 }
			 else
			 {
				 if(A[i]>A[i+2])
				 {
					 
				 }
				 else 
				 {
					 
				 }
			 }
		 }
	        // write your code in Java SE 8
		 return count;
	  }
	 
	 public static int solution(int[] S, int[] E) 
	 {
	      int maxCount =0;
	      
	        
	      for(int i =0;i<S.length-1;i++)
	      {
	    	 for(int j =0;j<S.length-i-1;j++)
	    	 {
	    		 if(S[j]>S[j+1])
	    		 {
	    			 int temp = S[j];
	    			 S[j] = S[j+1];
	    			 S[j+1] = temp;
	    			 
	    			 temp = E[j];
	    			 E[j] = E[j+1];
	    			 E[j+1] = temp;
	    			 
	    		 }
	    	 }
	      }
	      
	   
	     int count =0;
	      for(int i =0;i<S.length;i++)
	      {
	    	  if(maxCount<count)
	    	  {
	    		maxCount = count;  
	    	  }
	    	  else
	    	  {
	    		  count =0;
	    	  }
	    	  
	    	  for(int j =0;j<S.length;j++)
	    	  {
	    		  if( (E[i] == E[j] && S[i] >S[j]) || (E[i] >E[j] && S[i] >S[j])  && ! (S[i]>S[j]))
	    		  {
	    			 count++;
	    		  }
	    	  }
	    	  
	    	 
	      }
	      
	      System.out.println(maxCount);
	      
		 return maxCount;
	 }
	 
	
	 
	
	 ///
	
	//System.out.println(solution("2-4A0r7-4k",4));
	//one solution
	/*
	public static String solution(String S, int K)
	{
		String temp = "";
		int count =0;
		
		for(int i =S.length()-1;i>-1;i--)
		{
			if(!(S.charAt(i)+"").equals("-"))
			{
				temp += S.charAt(i);
				count++;
				
			}
			
			if( count == K)
			{
				temp += "-";
				count=0;
			}
		}
		
		String R ="";
		for(int j = temp.length()-1;j>-1;j--)
		{
		
			R += temp.charAt(j);
			
		}

		if(R.startsWith("-"))
		{
			R = R.substring(1);
		}
	
		
		
		return R;
	}*/
}
