public class Stack 
{
	public Node top;
	public int size;
	
	public class Node 
	{
        String phrase;
        public Node next;
    }
    public boolean isEmpty() 
    {
        return top == null;
    }
    public void push(String phrase) 
    {
        Node temp = top;
        
        top = new Node();
        top.phrase = phrase;
        top.next = temp;
        
        size++;
    }

    public String pop() 
    {	
    	String phrase ="";
        phrase = top.phrase;  
       
        top = top.next;            
        size--;
        
        return phrase;                  
    }

    public String peek() 
    {
       return top.phrase;
    }
}
