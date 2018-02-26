/**
 * @(#)Customer.java
 *
 *
 * @author 
 * @version 1.00 2017/2/15
 */


public class Customer {

	private String firstName;
	private String lastName;
	private int guestID;
	private double amountSpent;
	
	private int ounces;
	private double ouncesPrice;
	private int width;
	private int heigth;
	private double sqaureInchP;
	private int quanity;
		
    public Customer() 
    {
    	
    }
    public Customer(String fName,String lName, int gID, double as) 
    {
    	firstName = fName;
		lastName = lName;
		guestID= gID;
		amountSpent= as;
    }
    String getFirstName()
    {
    	return firstName;
    }
    String getLastName()
    {
    	return lastName;
    }
    int getGuestID()
    {
    	return guestID;
    }
 	double getAmountSpent()
 	{
 		return amountSpent;
 	}

 	 void setFirstName(String fn)
    {
    	firstName = fn;
    }
    void setLastName(String ln)
    {
    	lastName = ln;
    }
    void setGuestID(int gID)
    {
    	guestID = gID;
    }
 	void setAmountSpent(double as)
 	{
 		amountSpent = as;
 	}
 	public String toString() 
 	{
       return guestID+" " + firstName + " " + lastName + " "+ amountSpent + " ";
   }
 
}