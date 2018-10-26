package LinkList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Main //Alter to work with linked lists

{
	 public static void Print(char[][] arr) { //prints array to console with formatting
	        System.out.print(" ");
	   for(int i=1; i<=arr[0].length; i++) {
	       System.out.print(i % 10 + " ");
	        }

	        for(int i=0; i<arr.length; i++){
	            System.out.print("\n"+(i+1)+ " ");
	            for(int j=0; j<arr[0].length; j++)
	                System.out.print(arr[i][j] + " ");
	        }
	        System.out.print("\n\n");
	    }

	    public static void seating(char[][]arr)throws IOException{ //seats person
	        Print(arr);
	   Scanner s = new Scanner(System.in);
	        boolean empty = true;
	        boolean bad = true;
	        int size = 0, seat = 0, row = 0;
	        while(bad){//loop to get in bounds row
	            System.out.println("Which row number would you like to sit in?");
	            row = s.nextInt() - 1;
	            if(row > -1 && row < arr.length)
	                bad = false;
	        }
	        bad = true;
	        while(bad)//loop to get in bounds seat
	        {
	            System.out.println("Which starting seat number would you like?");
	            seat = s.nextInt() - 1;
	            if(seat > -1 && seat<arr[0].length)
	                bad = false;
	        }
	        bad = true;
	        while(bad){//loop to get in bounds # of ppl
	            System.out.println("How many tickets would you like?");
	            size = s.nextInt();
	            if(size>0)
	                bad = false;
	        }
	      
	        if (size + seat > arr[0].length || row > arr.length)//if out of bounds, get out of program
	            empty = false;
	        else{
	            for (int i = 0; i < size; i++){//check if the seating the person gave is good or not
	                if (arr[row][seat + i] == '.'){
	                    empty = false;
	                    break;
	                }
	            }
	        }
	        if(empty){//if the seating given is correct, reserve and leave
	            for (int i = 0; i < size; i++)
	                arr[row][seat + i] = '.';
	        }
	        else{ //else if new seats needed, check row
	            empty = true;
	            if(size < arr[0].length){
	                int i = ((arr[0].length)>>1) - 1;//gets middle
	                for (int q=0; q < arr[0].length; q++) {//loops through the row
	                    int index = i + ( q% 2 == 0 ? q/2 : -(q/2+1));//calculates index going forward and backwards using tertiary statement
	                    System.out.println(i + "   " + (index+1) + "   init:" /*+arr[row][index]*/);
	                    if (size + index <= arr[0].length && index > -1){//if in bounds
	                        if(index - size < 0){//if in bottom half and going left isnt an option, check spot and all to the right
	                            for (int k = 0; k < size; k++){
	                                if (arr[row][index + k] == '.'){
	                                    empty = false;
	                                    break;
	                                }
	                                empty = true;
	                            }
	                            if (empty == false)//if period found, go to next index
	                                continue;
	                        }
	                        else{//if in upper half
	                            for (int k = 0; k < size; k++){//loop through the line
	                                if (arr[row][index + k] == '.'){
	                                    empty = false;
	                                    break;
	                                }
	                                if (arr[row][index + k] == '#' && index-size > 0){//if in bounds, check spots to the left for the wanted seats from index
	                                    for(int check = 0; check < size; check++){
	                                        if (arr[row][index + k - check] != '#'){
	                                            empty = false;
	                                            break;
	                                        }
	                                        empty = true;
	                                    }
	                                }
	                                else
	                                    empty = false;
	                                if(k+1 >= size){//if at the end of the loop and the set of open seats were found, empty = true
	                                    empty = true;
	                                    break;
	                                }
	                                if (empty == true){//adjust index to match seating chart
	                                    index = index - size + k + 1;
	                                    break;
	                                }
	                            }
	                        }
	                        if(empty){//ask if they want the seats you found
	                            System.out.println("\nThe seat you asked for does not allow for your party to fit in the row\nHow about seat: " + (index+1) + "\nY\\N?: ");
	                            char y = (char) System.in.read();
	                            if(y == 'Y'){
	                                for (int j = 0; j < size; j++)
	                                    arr[row][index + j] = '.';
	                            }
	                            break;
	                        }
	                    }
	                  
	                }

	            }
	        }
	        Print(arr);
	    }
	  
	    public static int output(File file, char[][] A1)throws IOException{//writes to file
	        OutputStream print = new FileOutputStream(file);
	        for (int i = 0; i < A1.length; i++) {//loops through the array and prints it all to the file
	            for (int j = 0; j < A1[0].length; j++) {
	                print.write(A1[i][j]);
	            }
	            print.write('\r');
	            print.write('\n');
	        }
	             
	        int r = 0;//calculate the number of seats reserved
	        for (int i = 0; i < A1.length; i++) {
	            for (int j = 0; j < A1[0].length; j++) {
	                if (A1[i][j] == '.')
	                    r++;
	            }
	        }
	        return r;//return seats reserved
	    }
	    public static void input(File file, char[][] arr)throws IOException {//get the input and fill the double array
	        Scanner t = new Scanner(file);
	        int c = 0;
	        String line;
	        while(t.hasNext()){
	            line = t.nextLine();
	            for(int i = 0; i < line.length(); i++)
	                    arr[c][i] = line.charAt(i);
	            c++;
	        }
	    }
	  

	    public static void main(String[] args) throws IOException 
	    {
	    	LinkedList ll = new LinkedList();
	    	
	    	ll.
	    	/*
	        int count = 0;
	        String line = "";
	        File file1 = new File("A1base.txt");
	        File file2 = new File("A2base.txt");
	        File file3 = new File("A3base.txt");
	        Scanner s = new Scanner(file1);
	      
	        while (s.hasNextLine()){//get number of rows for file 1
	            line = s.nextLine();
	            count++;
	        }
	        char[][] A1 = new char[count][line.length()];

	        count = 0;
	        Scanner s2 = new Scanner(file2);
	        while (s2.hasNextLine()){ //get number of rows for file 2
	            line = s2.nextLine();
	            count++;
	        }
	        char[][] A2 = new char[count][line.length()];

	        count = 0;
	        Scanner s3 = new Scanner(file3);
	        while (s3.hasNextLine()){ //get number of rows for file 3
	            line = s3.nextLine();
	            count++;
	        }
	        char[][] A3 = new char[count][line.length()];

	        input(file1, A1);
	        input(file2, A2);
	        input(file3, A3);
	      
	        Scanner cin = new Scanner(System.in);
	        boolean ui = true;
	   
	        while(ui){//UI system for seating people
	            System.out.print("1. Auditorium 1\n2. Auditorium 2\n3. Auditorium 3\n4. Exit\n");
	            switch(cin.nextInt()){
	                case 1: seating(A1);
	                         break;
	                case 2: seating(A2);
	                         break;
	                case 3: seating(A3);
	                         break;
	                case 4: ui = false;
	                         break;
	                default: System.out.println("Incorrect input");
	                         break;
	            }
	        }
	    int r1 = output(file1, A1);//get the seats reserved amount
	    int r2 = output(file2, A2);
	    int r3 = output(file3, A3);

	    //Print 4 lines displaying columns of the names, seats reserved, seats open, and total ticket sales for each auditorium and the total overall.
	    System.out.print("\nAuditorium: Reserved Open Sales");

	    System.out.print("\nAuditorium 1: " + r1 + "       " + ((A1.length * A1[0].length) - r1) + "    $" + (r1 * 7) + "   ");
	    System.out.print("\nAuditorium 2: " + r2 + "       " + ((A2.length * A2[0].length) - r2) + "    $" + (r2 * 7) + "   ");
	    System.out.print("\nAuditorium 3: " + r3 + "       " + ((A3.length * A3[0].length) - r3) + "    $" + (r3 * 7) + "   ");

	    System.out.print("\nTotal:        " + (r1+r2+r3) + "      " + (((A3.length * A3[0].length) - r3)+((A2.length * A2[0].length) - r2)+((A1.length * A1[0].length) - r1))+ "   $" + (r1+r2+r3)*7 + "   ");*/
	    }

	}

