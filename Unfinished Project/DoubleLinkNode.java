package LinkList;

public class DoubleLinkNode extends Node
{  
	DoubleLinkNode Next;
	DoubleLinkNode Prev;
	
	String currentSeat;
	
	public DoubleLinkNode(DoubleLinkNode n,DoubleLinkNode p,String cS)
	{
		Next =n;
		Prev =p;
		
		currentSeat =cS;
	}
	public String getcurrentSeat()
	{
		return currentSeat;
	}
	public void setcurrentSeat(String s)
	{
		currentSeat =s;
	}


} 
