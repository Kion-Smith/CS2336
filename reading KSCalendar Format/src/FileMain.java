import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class FileMain 
{
	public static void main(String [] args)
	{
		
	
		try 
		{
			File myFile = new File("TestCal.ksc");
			
			if(!myFile.exists())
			{
				myFile.createNewFile();
			}
			
			BufferedReader bf = new BufferedReader(new FileReader(myFile));
			
			System.out.println("File Loaded");
			System.out.println("----------------------------");
			System.out.println("");
			
			String curLine;
			while( (curLine =bf.readLine()) != null)
			{
				System.out.println(curLine);
				
				for(int i =0; i< curLine.length();i++)
				{
				
					try
					{
						if(i==0 && (curLine.charAt(i)+"").equals("["))
						{
							String yearString =curLine.substring(curLine.indexOf("[")+1,curLine.indexOf("/"));
								
							String monthString =curLine.substring(curLine.indexOf("/")+1);
							String dayString = monthString;
							monthString = monthString.substring(0,monthString.indexOf("/"));
								
							dayString = dayString.substring(dayString.indexOf("/")+1,dayString.indexOf("]"));
								
							System.out.println("@ Output - Year = "+yearString);
							System.out.println("@ Output - Month = "+monthString);
							System.out.println("@ Output - Day = "+dayString);
							
							if(curLine.contains(":{"))
							{
								
								//get content from the line
							}
							else
							{
								break;
							}
							
						}
						else if(curLine.contains("{"))
						{
							//check to see if anything is on cur line, if not iterate
						}
					}
					catch(Exception e)
					{
						break;
					}

					
				}//end for
				
				
			}//end while

			
		} 
		catch (Exception e) 
		{
			System.out.println("File Not Found");
		}
		
	}
}
