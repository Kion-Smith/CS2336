import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


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
			
			ArrayList<CalendarObject> clArray = new ArrayList();
			
			System.out.println("File Loaded");
			System.out.println("----------------------------");
			System.out.println("");
			
			String curLine;
			boolean lookingForBrace = false;
			boolean lookingForEndBrace = false;
			while( (curLine =bf.readLine()) != null)
			{
				System.out.println(curLine);
				
				for(int i =0; i< curLine.length();i++)
				{
				
					try
					{
						if(i==0 && (curLine.charAt(i)+"").equals("["))
						{
							// could put this in a date handling method
							String yearString =curLine.substring(curLine.indexOf("[")+1,curLine.indexOf("/"));
								
							String monthString =curLine.substring(curLine.indexOf("/")+1);
							String dayString = monthString;
							monthString = monthString.substring(0,monthString.indexOf("/"));
								
							dayString = dayString.substring(dayString.indexOf("/")+1,dayString.indexOf("]"));
								
							System.out.println("@ Output - Year = "+yearString);
							System.out.println("@ Output - Month = "+monthString);
							System.out.println("@ Output - Day = "+dayString);
							
							
							
							clArray.add( new CalendarObject(convertStringToInt(yearString),convertStringToInt(monthString),convertStringToInt(dayString)));
							
							/*Pseudo code for getting info
							 * 
							 * if has :{ } in string keep add those items
							 * else if has : but not { set looking for start brace boolean to true and then start looking for the end
							 * else return and error and break
							 */
							
							//tempary for testing
							lookingForBrace = true;
							
							
						}
						
						if(lookingForBrace &&  (curLine.charAt(i)+"").equals("{"))
						{
							System.out.println(" Start: Looking for brace > "+curLine);
							lookingForBrace = false;
							lookingForEndBrace = true;
						}
						/* problem here
						if(lookingForEndBrace &&  (curLine.contains('"'+"")) );
						{
							System.out.println(" Content: Looking for content > "+curLine);
						} */
						if(lookingForEndBrace &&  (curLine.charAt(i)+"").equals("}"))
						{
							System.out.println(" End: Looking for end > "+curLine);
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
	
	public static int convertStringToInt(String string)
	{
		try
		{
			return Integer.parseInt(string);
		}
		catch(Exception e)
		{
			return -1;
		}
		
	}
}
