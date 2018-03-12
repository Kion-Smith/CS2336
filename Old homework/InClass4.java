//Margaret Vakulenko mxv151930
//Anna Doran amd141030
//Kion Smith kls160430
package inclass4;
import java.util.*;
public class InClass4 {

    public static void main(String[] args) 
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a number ::");
        int number = kb.nextInt();
        Number n = new Number();
       // n = new Number();
        if(n.valid(number)==true)
        {         String x = "";
         
         int[] numArray = {1111,1222,1333,1444,1555,1666,1777,1888,1999,2000};
         
         if(search(numArray,number,0)==true)
         {
             System.out.println("`sdkjfh'");
             binary(number);
         }
         else
         {
             System.out.println(number);
             reverse(number,x);
             System.out.println(x);
         }
         
        }
           
                
        
        
    }
    public static boolean search(int[] x,int y,int z)
    {
       
       if(x[z] == y)
       {
           return true;
       }
       else if(z == x.length-1)
       {
           return false;
       } 
       //System.out.println(x+","+y+","+z);
       search(x,y,z+1);
        return false;
     
    }
    public static String reverse(int x,String y)
    {
        
       if(x<10)
       {
           y += x;
           return y;
       }
       else
       {
           y += x%10;
           reverse(x/10,y);  
       }
        return "";
    }
    public static void binary(int x)
    {
        if(x==0||x==1)
        {
            System.out.println(x);
     
        }
        else
        {
            int temp=x;
            while(x!=0 || x!=1)
            {
                x/=2;
            }
            System.out.print(x);
            binary(temp%2);
        }
    }
    
private class Number {
   
    private int number;
    
    Number() {
        number=0;
    }
    private boolean valid(int x) {
        if (x < 0) {
            System.out.println("Cannot be negative.");
            return false;
        }
        else
            return true;
    }
}    
    
}



