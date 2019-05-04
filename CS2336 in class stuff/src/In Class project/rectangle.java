package General;

public class rectangle 
{
	 double width;// default access instance variables
	 double height;
	
	public rectangle()//also default
	{
		
	}
	public rectangle(double h,double w)// value constructor
	{
		setHeight(h);
		setWidth(w);
	}
	
	public double getWidth()
	{
		return width;
	}
	public double getHeight()
	{
		return height;
	}
	
	public void setWidth(double w)
	{
		//if(some rules ok then)
		width =w;
	}
	public void setHeight(double h)
	{
		//if(some rules ok then)
		height =h;
	}
}
