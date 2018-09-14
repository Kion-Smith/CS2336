import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Scanner;


public class FileMain 
{
	public static void main(String [] args)
	{
		
		//going to sort when inserting a new date
		File myFile = new File("TestCal.ksc");
		LinkedList<CalendarObject> calendarList = new LinkedList();
		boolean hasThrownError = false;
		try 
		{
			
			
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
				//System.out.println(curLine);
				
				try
				{
					if((curLine.charAt(0)+"").equals("["))
					{
	
						String yearString =curLine.substring(curLine.indexOf("[")+1,curLine.indexOf("/"));
								
						String monthString =curLine.substring(curLine.indexOf("/")+1);
						String dayString = monthString;
						monthString = monthString.substring(0,monthString.indexOf("/"));
							
						String dataItems = dayString;
						dayString = dayString.substring(dayString.indexOf("/")+1,dayString.indexOf("]"));
								
						CalendarObject tempObject = new CalendarObject(convertStringToInt(yearString),convertStringToInt(monthString),convertStringToInt(dayString));
						
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
										
										tempObject.addToNotesList(temp);
										calendarList.add(tempObject);
										
										
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
										
										tempObject.addToNotesList(temp);
										temp = "";
										isEndOfString=false;
									}
									else if(isBetweenBrace && isBetweenQuote)
									{
										temp += dataItems.charAt(i)+"";
									}
									
									break;
									
							}// end of swith	
								
						}// end of for
						
					}
							
				}
				catch(Exception e)
				{
					hasThrownError = true;
					System.out.println("Error");
					break;
				} //end of try catch

			}//end while

			
		} 
		catch (Exception e) 
		{
			System.out.println("File Not Found");
		}
		
		if(!hasThrownError)
		{
			for(int i =0;i<calendarList.size();i++)
			{
				System.out.println(i+" at "+calendarList.get(i).toString());
			}
		}
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a date");
		try
		{
			int year = kb.nextInt();
			int month = kb.nextInt();
			int day = kb.nextInt();
			
			CalendarObject tempObj = new CalendarObject(year,month,day);
			tempObj = addStringToData(tempObj);
			
			calendarList.add(tempObj);
		}
		catch(Exception e)
		{
			
		}
		
		try 
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(myFile));
			for(int i=0;i<calendarList.size();i++)
			{
				System.out.println(calendarList.get(i).toString() +"YYYYEEEEEET");
				bw.write(calendarList.get(i).toString());
				bw.newLine();
			}
			
			bw.close();
			
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Error in writing");
		}
		//could potential save time by checking each item, but
		
		
		

	}
	
	public static CalendarObject addStringToData(CalendarObject obj)
	{
		System.out.println("Enter a string");
		
		Scanner kb = new Scanner(System.in);
		String temp = kb.nextLine();
		
		obj.addToNotesList(temp);
		System.out.println("Would you like to add another string");
		temp = kb.nextLine();
		
		if(temp.equals("y"))
		{
			return addStringToData(obj);
		}
		
		System.out.println(obj.toString());
		
		return obj;

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
