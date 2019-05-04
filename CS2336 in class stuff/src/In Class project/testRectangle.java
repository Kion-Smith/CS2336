package General;

public class testRectangle 
{
	public static void main(String [] args)
	{
		rectangle r1 = new rectangle();// if no default constructor but a value constructor exist it fails
		rectangle r2 = new rectangle(3.5,4.6);// with no value constructor fails
	}
}
