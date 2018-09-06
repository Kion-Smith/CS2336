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
				
				
			}

			
		} 
		catch (Exception e) 
		{
			System.out.println("File Not Found");
		}
		
	}
}
