

public class preferredCustomer extends Customer
{

	private int discountPercentage;
	
    public preferredCustomer() 
    {
    	
    }
    public preferredCustomer(String fn, String ln,int gID,double as,int dp) 
    {
    	super(fn,ln,gID,as);
    	discountPercentage = dp;
    }
    int getDiscountPercentage()
 	{
 		return discountPercentage;
 	}
 	void setDiscountPercentage(int dp)
 	{
 		discountPercentage = dp;
 	}
 	public String toString() {
       return super.toString()+" "+discountPercentage+"%";
   }
    
    
}