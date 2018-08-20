
package in.pkgclass.project.pkg1;



public class InClassProject1 {

 
    public static void main(String[] args) 
    {
      long time = System.currentTimeMillis();
      
      time *=.001;//seconds
      long seconds = time;
      time /= 60;//minutes;
      long minutes = time;
      time /=60;//hours
      long hours = time;
      time/=24; //days;
      long days = time;
      time/=365;//years not leap years
      time += 1970;
      long  years = time;
      
      System.out.println(time);
      
      long leap =time-1970;
      
      System.out.println(leap);
      
      int i=0;
      while(leap>4)
      {
          leap -= 4;
         // System.out.println(leap);
          i++;
          //add a fucntion days;
      }
     // System.out.println(i);
      
      while(i>0)
      {
          //days+=1;
          i--;
      }
      /////////////
     System.out.println("Month "+" Day "+days+" Year "+years+" hour "+hours+" mins "+" second "+seconds);
     /* 
     for(int x =0;x<days;x++)
     {
         int c =17191/41;
     }
*/
      int c =17191/47;
      System.out.println(c/12);
    }
}
