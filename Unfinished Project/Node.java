package LinkList;


public abstract class Node
{
	int row;
	int seat;
	
	public Node()
	{
		
	}
	public Node(int r ,int s)
	{
		row = r;
		seat = s;
	}
	public int getRow()
	{
		return row;
	}
	public int getSeat()
	{
		return seat;
	}
	public void setRow(int r)
	{
		row =r;
	}
	public void setSeat(int s)
	{
		seat =s;
	}
    
}