
public class Node 
{
	public static String color;
	public static int value;
	public static int degree;
	
	public Node()
	{
		
	}
	
	public Node(int v, int d)
	{
		value = v;
		degree = d;
	}
	public void setColor(String c)
	{
		color=c;
	}
	public String getColor()
	{
		return color;
	}
}
