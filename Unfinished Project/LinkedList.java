package LinkList;


public class LinkedList
{
	private DoubleLinkNode head;
	private DoubleLinkNode tail;
	private int size;
	
	public LinkedList() 
	{
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	public boolean isEmpty() 
	{
		if (head == null)
		{
			return true;
			
		}	
		return false;
		
		
	}

	
	public void inserthead(DoubleLinkNode d) 
	{
		if (isEmpty())
			tail = d;
		else
			head.Prev = d;
		d.Next = head;
		head = d;
		size += 1;
	}

	
	public void inserttail(DoubleLinkNode d) 
	{
		if (isEmpty())
		{
			head = d;
		}
		else 
		{
			tail.Next = d;
			d.Prev = tail;
		}
		
		tail = d;
		size += 1;
	}

	
	public DoubleLinkNode deletehead() 
	{
		DoubleLinkNode temp = head;
		
		if (head.Next == null)
		{
			tail = null;
		}
		else
		{
			head.Next.Prev = null;
		}
		
		head = head.Next;
		size -= 1;
		return temp;
	}

	public DoubleLinkNode deletetail() 
	{
		DoubleLinkNode temp = tail;
		
		if (head.Next == null)
		{
			head = null;
		}
		else
		{
			tail.Prev.Next = null;
		}
		
		tail = tail.Prev;
		size -= 1;
		return temp;
	}
	public boolean insertAfter(String key, DoubleLinkNode d) {
		DoubleLinkNode current = head;

		while (current.currentSeat != key) {
			current = current.Next;
			if (current == null)
				return false;
		}

		if (current == tail) {
			d.Next = null;
			tail = d;
		} else {
			d.Next = current.Next;
			current.Next.Prev = d;
		}
		d.Next.Prev = current;
		current.Next = d;
		size += 1;
		return true;
	}
}

