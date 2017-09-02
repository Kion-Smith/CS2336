package Homework_1;

import java.util.Scanner;

public class Question4 
{
	public void answer()
	{
		Scanner kb = new Scanner(System.in);//create scanner object
		//geting user info
		System.out.println("Enter employee's name:");
		String empName = kb.nextLine();
		
		System.out.println("Enter number of hours worked in a week");
		int hours = kb.nextInt();
		
		System.out.println("Enter hourly pay rate");
		double payRate = kb.nextDouble();
		
		System.out.println("Enter federal tax withholding rate");
		double fedralTax = kb.nextDouble();
		
		System.out.println("Enter state tax withholding rate");
		double stateTax = kb.nextDouble();
		kb.close();//close scanner
		
		System.out.println("Employee Name:"+empName);
		System.out.println("Hours Worked:"+hours);
		System.out.println("Pay Rate:$"+payRate);
		System.out.println("Gross Pay:$"+(payRate*hours) );//calc hours worked
		
		System.out.println("Deductions:");
		
		System.out.println("	Federal Withholding:"+"("+(fedralTax*100)+"%)"+(fedralTax*(payRate*hours) )  );//calc taxes
		System.out.println("	State Withholding:"+"("+(stateTax*100)+"%)"+(stateTax*(payRate*hours) ));
		System.out.println("	Total Deductions:$"+( (fedralTax*(payRate*hours)) + (stateTax*(payRate*hours))) );
		
		System.out.println("Net Pay:$"+ ((payRate*hours)-((fedralTax*(payRate*hours)) + (stateTax*(payRate*hours)))));//final amount
	}
}
