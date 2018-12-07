public class main 
{
	public static void main(String[] args)
	{
	
		System.out.println(solution("2-4A0r7-4k",4));
	}
	
	
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
	}
}
