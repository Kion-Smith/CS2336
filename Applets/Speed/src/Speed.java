/**
 * @(#)Speed.java
 *
 * Speed Applet application
 *
 * @author 
 * @version 1.00 2014/1/21
 */
 
import java.awt.*;
import java.applet.*;

public class Speed extends Applet {
	int x;
	int change;
	
	public void init() {
		
		change=-15;
	}

	public void paint(Graphics g) {
		
		Image background = getImage(getDocumentBase(),"Stadium.JPG");
		Image car3 = getImage(getDocumentBase(),"car3.JPG");
		Image car2 = getImage(getDocumentBase(),"car2.JPG");
		Image car1 = getImage(getDocumentBase(),"car1.JPG");
	int x = 1;	
		
	int a = 660;
	
	int b = 660;
			
	int c = 660;	
	
		

	while(x==1)	
	{
	
	int y = (int)(Math.random()*3)+1;
	g.drawImage(background,0,0,this);		
	g.drawImage(car1,a,275,this);
	g.drawImage(car2,b,405,this);
	g.drawImage(car3,c,520,this);
	
	
	if (y == 1)
	{
	
		a = a-5;
	}
	
	if (y == 2)
	{
	
		b = b-5;
	}
	if (y == 3)
	{
	
		c = c-5;
	}
	
		if (a==60 && c>60 && b>60)
	{
	
	g.drawString("Red Has Won!",350,50);
	g.drawString("Red Has Won!",350,50);
	g.drawString("Red Has Won!",350,50);
	g.drawString("Red Has Won!",350,50);
	x++;
	
	
	}
	
	if  (b==60 && c>60 && a>60)
	{
	
	g.drawString("Orange Has Won!",350,50);
	g.drawString("Orange Has Won!",350,50);
	g.drawString("Orange Has Won!",350,50);
	g.drawString("Orange Has Won!",350,50);
	x++;
	}		
		
	if  (c==60 && a>60 && b>60)
	{
	
	g.drawString("Blue Has Won!",350,50);
	g.drawString("Blue Has Won!",350,50);
	g.drawString("Blue Has Won!",350,50);
	g.drawString("Blue Has Won!",350,50);
	x++;
	
	
	}
	
	
	
	
	for(int r = 0; r<10000000; r++);
	
	}
		}
		
		
		
		
		
		
		
		
	}
