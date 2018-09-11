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

			while( (curLine =bf.readLine()) != null)
			{
				System.out.println(curLine);
				
				try
				{
					if((curLine.charAt(0)+"").equals("["))
					{
							// could put this in a date handling all string items. Could also make 2 methods for handeling string items
						String yearString =curLine.substring(curLine.indexOf("[")+1,curLine.indexOf("/"));
								
						String monthString =curLine.substring(curLine.indexOf("/")+1);
						String dayString = monthString;
						monthString = monthString.substring(0,monthString.indexOf("/"));
							
						String dataItems = dayString;
						dayString = dayString.substring(dayString.indexOf("/")+1,dayString.indexOf("]"));
								
						System.out.println("@ Output - Year = "+yearString);
						System.out.println("@ Output - Month = "+monthString);
						System.out.println("@ Output - Day = "+dayString);
							
							
							//changed idea only valid way of entering data for a month is
						clArray.add( new CalendarObject(convertStringToInt(yearString),convertStringToInt(monthString),convertStringToInt(dayString)));
						dataItems = dataItems.substring(dataItems.indexOf("{"));
							
						boolean hasRightBrace = false;
						boolean hasFirstQuote= false;
						String temp ="";
						for(int i=0;i<dataItems.length();i++)
						{
							//System.out.println("DEBUG::"+(dataItems.charAt(i)+""));
							switch( (dataItems.charAt(i)+""))
							{
								case "{":
									if(!hasRightBrace)
									{
										hasRightBrace = true;
									}
									break;
								case "\"":
									if(hasRightBrace && !hasFirstQuote)
									{
										hasFirstQuote = true;
										break;
									}
									else if(hasRightBrace && hasFirstQuote)
									{
										break;
									}
									
								default:
									temp += dataItems.charAt(i)+"";
									System.out.println("DID THIS RUN:: "+temp);
									break;
							}
						}

							
					}
					else
					{
						break;
					}
					
				}
				catch(Exception e)
				{
					System.out.println("Error");
					break;
				} //end of try catch

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
