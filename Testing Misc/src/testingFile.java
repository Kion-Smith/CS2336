
 import java.awt.event.ActionListener;
import java.util.Comparator;
public class testingFile implements Comparator
{
	String testName;
	int value;
	public static void main(String [] args)
	{
		System.out.println( (new testingFile().equals(new testingFile("name",4))));
		System.out.println( (new testingFile().equals(new testingFile())));
	}
	public testingFile(String s, int x)
	{
		 testName = s;
		 value = x;
	}
	public testingFile()
	{
		 testName = "This is a test";
		 value = 4;
	}
	public testingFile eqauls(testingFile s)
	{
		return s;
	}
	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
}
