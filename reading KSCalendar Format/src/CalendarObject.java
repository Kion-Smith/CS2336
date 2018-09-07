import java.util.ArrayList;

public class CalendarObject
{
	private int year;
	private int month;
	private int day;
	
	ArrayList<String> Notes = new ArrayList();
	
	public CalendarObject(int y, int m,int d)
	{
		year =y;
		month =m;
		day = d;
	}
	
	//setters
	public void setYear(int y)
	{
		year =y;
	}
	public void setMonth(int m)
	{
		month =m;
	}
	public void setDay(int d)
	{
		day =d;
	}
	public void addToNotesList(String s)
	{
		Notes.add(s);
	}
	//getters
	public int getYear()
	{
		return year;
	}
	public int getMonth()
	{
		return month;
	}
	public int getDay()
	{
		return day;
	}

}
