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
							
						boolean isBetweenBrace = false;
						boolean isBetweenQuote = false;
						boolean isEndOfString = false;
						
						String temp ="";
						for(int i=0;i<dataItems.length();i++)
						{
							
							switch( (dataItems.charAt(i)+""))
							{
								case "{":
									if(!isBetweenBrace && !isBetweenQuote)
									{
										isBetweenBrace = true;
									}
									break;
									
								case "}":
									if(isEndOfString)
									{
										//save this to a linked list  of Calendar objects, and if no errors are raised will push all of this to the array storing calender dates
										System.out.println("DID THIS RUN:: "+temp);
										
										temp = "";
										isEndOfString=false;
									}
									else if(isBetweenBrace && !isBetweenQuote)
									{
										isBetweenBrace = false;
									}
									
								
									break;
									
								case "\"":
									if(isBetweenBrace && !isBetweenQuote)
									{
										isBetweenQuote = true;
										
									}
									else if(isBetweenBrace && isBetweenQuote)
									{
										
										isBetweenQuote = false;
										
										//
									}
									break;
									
								case ";":
									
									if(!isBetweenQuote)
									{
										
										isEndOfString = true;
									}
									break;
									
								default:
									if(isEndOfString)
									{
										temp += dataItems.charAt(i)+"";
										System.out.println("DID THIS RUN:: "+temp);
										
										temp = "";
										isEndOfString=false;
									}
									else if(isBetweenBrace && isBetweenQuote)
									{
										temp += dataItems.charAt(i)+"";
									}
									
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
