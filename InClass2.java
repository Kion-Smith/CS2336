/*
 Names Kion Smith, Matthew Kunjummen
  Net Id kls160430, mtk160030
Class: CS 2336-003
*/
//package inclass2;


public class InClass2 {

    
    public static void main(String[] args) 
    {
       Circle2D c1 = new Circle2D(2,2,5.5);
       
       System.out.println("The area of circle 1:: "+c1.getArea());
       System.out.println("The perimter of circle 1::"+c1.getPerm());
       
       System.out.println("Cirle one contains 3,3:: "+c1.contains(3,3));
       System.out.println("Cirle one overlaps 4,5 with radius 10.5:: "+c1.overlaps(new Circle2D(4,5,10.5)));
       System.out.println("Cirle one contains 3,5 with radius 2.3:: "+c1.contains(new Circle2D(3,5,2.3)));
       
    }
    
    
}
