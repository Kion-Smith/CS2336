/*NAME: Kion Smith
 * NET ID kls160430
 * NAME: Maxwell Fritz
 * NET ID maf150130
 */


import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args)throws IOException
	{
		File file1 = new File("Input.txt");
		Scanner f1 = new Scanner(file1);
		
		File file2 = new File("Output.txt");
		Scanner f2 = new Scanner(file2);
		
		Stack s = new Stack();
		
		String postFix = "";
		String temp ="";
		
	
		while(f1.hasNext())
		{
			temp = f1.next();
			switch(temp)
			{
			
			case "^":
				if(!(s.isEmpty()))
				{
					while(s.peek().equals("^"))
					{
						postFix += s.pop();
					}
					
				}
				s.push(temp);
				break;
			case "*":
				if(!(s.isEmpty()))
				{
					while(s.peek().equals("*") ||s.peek().equals("/")|| s.equals("^"))
					{
						postFix += s.pop();
					}
					
				}
				s.push(temp);
				break;
			case "/":
				if(!(s.isEmpty()))
				{
					while(s.peek().equals("*") ||s.peek().equals("/")|| s.equals("^"))
					{
						postFix += s.pop();
					}
					
				}
				s.push(temp);
				break;
			case "+":
				if(!(s.isEmpty()))
				{
					while(s.peek().equals("(") != true )
					{
						postFix += s.pop();
					}
					
				}
				s.push(temp);
				break;
			case "-":
				if(!(s.isEmpty()))
				{
					while(s.peek().equals("(") != true )
					{
						postFix += s.pop();
						if(!(s.isEmpty()))
						{
							break;
						}
					}
					
					
				}
				
				s.push(temp);
				break;
			case "(":
				s.push(temp);
				break;
			case ")":
				while(s.peek().equals("(") != true )
				{
					postFix += s.pop();
				}
				s.pop();
				break;
			default:
				postFix += temp;
				break;	
				
			}
		}
		while(!(s.isEmpty()))
		{
			postFix += s.pop();
		}
		FileWriter fw = new FileWriter(file2);
		PrintWriter pw = new PrintWriter(fw);
		pw.print(postFix);
		fw.close();
		f1.close();
		f2.close();
		 System.out.println(postFix);
	}
}
