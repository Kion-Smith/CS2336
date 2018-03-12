/*
 Names Kion Smith, Matthew Kunjummen
  Net Id kls160430, mtk160030
Class: CS 2336-003
*/
//package inclass2;


public class Circle2D
{
    private double x;
    private double y;
    
    private double radius;
    
    public Circle2D()
    {
        x =0;
        y=0;
        radius=1;
    }
     public Circle2D(double newX,double newY,double r)
    {
        x = newX;
        y =newY;
       radius =r;
       
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public double getRadius()
    {
        return radius;
    }
    
    public double getArea()
    {
        return Math.pow(radius ,2)*Math.PI;
    }
    public double getPerm()
    {
        return 2* Math.PI * radius;
    }
   
    public boolean contains(double x,double y)
    {
        if(dist(x, y) <= radius)
        {
            return true;
        }
        return false;
    }                
    public boolean contains(Circle2D c)
    {
        if(c.dist(x, y)+c.getRadius() <= radius)
        {
            return true;
        }
        return false;
    }
    public boolean overlaps(Circle2D c)
    {
        if(c.dist(x, y) <= radius + c.getRadius())
        {
            return true;
        }
        return false;
    }
    public double dist(double otherx, double othery)
    {
        return Math.sqrt(Math.pow(otherx - x, 2) + Math.pow(othery - y, 2));
    }
}