import java.util.*;
import java.io.*;


public class Main 
{
	
 public static Customer[] c;
 public static preferredCustomer[] pc;
 
 String customerFileName = "customers.dat";
 String preferredCustomerFileName = "preferred.dat";
 String transactionFileName = "orders.dat";
 
 
    public static void main(String [] args)throws IOException, FileNotFoundException
    {
    	Main m = new Main();
    	m.readCustomerFiles();
    	m.readPreferredCustomerFiles();
    	m.readOrders();
    	m.printToFile();
    }
    public void readCustomerFiles()throws FileNotFoundException
    {
    	int customerAmount =0;
    	Scanner sc = new Scanner(new File(customerFileName));
    	while(sc.hasNextLine())
    	{
    		 String temp = sc.nextLine();
    		 customerAmount++;		
    	}
    	sc.close();
    	
    	 c = new Customer[customerAmount];
    	 
    	 Scanner sc1 = new Scanner(new File(customerFileName));
    	 
    	 for(int i =0;i<customerAmount;i++ )
    	 {
    	 		if(sc1.hasNextLine())
    	 		{
    	 			
    	 			int id = sc1.nextInt();
    	 			String fname = sc1.next();
    	 			String lname = sc1.next();
    	 			double money = sc1.nextDouble();
    	 			
    	 			c[i] = new Customer(fname,lname,id,money);	
    				 
    	 		}    	 		
    	 }
    	 sc1.close();
    }
    public void readPreferredCustomerFiles()throws IOException
    {
    	
    	try
    	{	
    		int preCustomerAmount =0;
    		Scanner sc = new Scanner(new File(preferredCustomerFileName));
    		while(sc.hasNextLine())
    		{
    			 String temp = sc.nextLine();
    			 preCustomerAmount++;		
    		}
    		sc.close();
    		pc = new preferredCustomer[preCustomerAmount];
    	 
    	 Scanner sc1 = new Scanner(new File(preferredCustomerFileName));
    	 
    	 for(int i =0;i<preCustomerAmount;i++ )
    	 {
    	 		if(sc1.hasNextLine())
    	 		{
    	 			
    	 			int id = sc1.nextInt();
    	 			String fname = sc1.next();
    	 			String lname = sc1.next();
    	 			double money = sc1.nextDouble();
    	 			
    	 			String discountString = sc1.next();
    	 			discountString=discountString.replace("%","");
    	 			int discount = Integer.parseInt(discountString);
    	 			
    	 			pc[i] = new preferredCustomer(fname,lname,id,money,discount);	
    				 
    	 		}
    	 		
    	 }
    	 sc1.close();
    	}
    	catch(FileNotFoundException e) 
    	{
				File f = new File(preferredCustomerFileName);
				f.createNewFile();	
    	}
    }
    public void writeData()throws FileNotFoundException
    {
    	
    
    	int count=0;
    	
    	for(int i =0;i<c.length;i++)
    	{
    		if(c[i].getAmountSpent() >=150)
    		{
    			count++;
    		}
    	}
    	if(pc == null)
    	{
    		pc = new preferredCustomer[0];
    	}
    	
    	int p = (pc.length+count)-1;
    	
    	Customer[] tempCus = new Customer[c.length-count];
    	
    	preferredCustomer[] tempPre = new preferredCustomer[pc.length+count];
    	preferredCustomer	t = new preferredCustomer();
    	 
    	for(int l =0;l<pc.length;l++)
    	{
    		tempPre[l] = new preferredCustomer(pc[l].getFirstName(),pc[l].getLastName(),pc[l].getGuestID(),pc[l].getAmountSpent(),pc[l].getDiscountPercentage());
    	}
    	
    	int k =0;
    	for(int j =0; j<c.length;j++)
    	{
    		
    		if(c[j].getAmountSpent() >= 150)
    		{
    			tempPre[p] = new preferredCustomer(c[j].getFirstName(),c[j].getLastName(),c[j].getGuestID(),c[j].getAmountSpent(),5);
    		}
    		else
    		{
    			tempCus[k] = c[j];
    			k++; 
    		}
    		
    	}
    	for(int x =0;x<tempPre.length;x++)
    	{
    		if(tempPre[x].getAmountSpent() >=150 && tempPre[x].getAmountSpent() <200)
    		{
    			tempPre[x].setDiscountPercentage(5);
    		}
    		else if(tempPre[x].getAmountSpent() >=200 &&tempPre[x].getAmountSpent() <350)
    		{
    			tempPre[x].setDiscountPercentage(7);
    		}
    		else if(tempPre[x].getAmountSpent() >=350 )
    		{
    			tempPre[x].setDiscountPercentage(10);
    		}
    	}
    	
	    
	    c = tempCus;
	    pc = tempPre;	
	
		    
	   

    }
    public void readOrders()throws FileNotFoundException
    {
    	int orderCount =0;
    	Scanner sc = new Scanner(new File(transactionFileName));
    	while(sc.hasNextLine())
    	{
    		 String temp = sc.nextLine();
    		 orderCount++;		
    	}
    	sc.close();
    	 
    	 Scanner sc1 = new Scanner(new File(transactionFileName));
    	 
    	 for(int i =0;i<orderCount;i++)
    	 {
    	 	boolean  hasRun=false;
    	 		if(sc1.hasNextLine())
    	 		{
    	 			
    	 			int ID = sc1.nextInt();
    	 			double radius = sc1.nextDouble();
    	 			double height = sc1.nextDouble();
    	 			double ounces = sc1.nextDouble();
    	 			double ouncePrice = sc1.nextDouble();
    	 			double sqInchPrice = sc1.nextDouble();
    	 			int  quanity = sc1.nextInt();
    	 			
    	 			for(int j=0;j<c.length;j++)
    	 			{
    	 				if(c[j].getGuestID()== ID && hasRun != true)
    	 				{
    	 				
    	 					double priceofOunces= calcOunces(ounces,ouncePrice);
    	 					double priceOfDesign=calcSurfaceArea(sqInchPrice,radius,height);	
    	 				
    	 					double total = (priceOfDesign + priceofOunces)* quanity;
    	 					
    	 					total = Math.round(total *100);
    	 					total = total/100;

    	 					c[j].setAmountSpent(c[j].getAmountSpent() + total);
    	 					

    	 					hasRun = true;
    	 					writeData();
    	 				}
    	 			}
    	 			for(int j=0;j<pc.length;j++)
    	 			{
    	 				if(pc[j].getGuestID()== ID &&hasRun != true)
    	 				{
    	 				
    	 					double priceofOunces= calcOunces(ounces,ouncePrice);
    	 					double priceOfDesign=calcSurfaceArea(sqInchPrice,radius,height);	
    	 				
    	 					double total = (priceOfDesign + priceofOunces);
    	 					double percent = total * (pc[j].getDiscountPercentage()/100);
    	 					
    	 					total = total - percent;
    	 					total = total*quanity;
    	 					total = Math.round(total *100);
    	 					total = total/100;
    	 					
    	 					pc[j].setAmountSpent(pc[j].getAmountSpent()+total);
    	 					
    	 					hasRun = true;
    	 					writeData();
    	 					
    	 				}
    	 			} 
    	 		}
    	 		
    	 }
    	 sc1.close();
    }
    
    public double calcSurfaceArea(double price,double r,double h)
    {
    	
    	return ((2*Math.PI*r*h)+(2*Math.PI*Math.pow(r,2)))*price;
    }
    public double calcOunces(double oz,double ozPrice)
    {
    	return (oz*ozPrice);
    }
   public void printToFile() throws IOException
   {
   	 FileWriter fw1 = new FileWriter(customerFileName);
   	 PrintWriter pw1 = new PrintWriter(fw1);
   	 for(int i =0;i<c.length;i++)
   	 {
   	 	pw1.println(c[i].toString());
   	 }
   	 fw1.close();
   	 pw1.close();
   	 
   	 FileWriter fw2 = new FileWriter(preferredCustomerFileName);
   	 PrintWriter pw2 = new PrintWriter(fw2);
   	 for(int i =0;i<pc.length;i++)
   	 {
   	 	pw2.println(pc[i].toString());
   	 }
   	 fw2.close();
   	 pw2.close();
   }
}