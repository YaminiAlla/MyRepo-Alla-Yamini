package com.hcl.domino.techassign1;

//import java.util.Scanner; //importing scanner class from java.util package
/**
 * The program is used to find the sum of squares of the number.
 * 
 * @author AllaYamini
 * @version 1.8
 */
public class Naturalno { // main class
	/**
	 * This is the method used for calculating the squares. This takes an int
	 * parameter given by the user. This method checks for negative numbers as well.
	 * 
	 * @return int
	 */
	public static int SumSquare(int n)// static method
	{
		int out = 0;

		// checking for negative number
		if (n < 0) {
			System.out.println("Number can't be negative\n");
		}

		// calculating the sum of the squares for given number
		else {
			return n * (n + 1) * (2 * n + 1) / 6;// formula for sum of squares of first n natural numbers
			//return (n * (n + 1) / 2) * (2 * n + 1) / 3; 
		}
		return out;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Displaying the program to the user
		if (args.length == 0) {
			System.out.println(
					"The description of the program is:\nThe program is used for caluclating the sum of squares\nNeed a input value to calculate the sum of sqaures\ne.g. java Naturalno 4");
		} else {
			
			try {
				//int n; // initialize input variable
				//Scanner s = new Scanner(System.in); // Declare the object and initialize with predefined standard input
												// object
				int n=Integer.parseInt(args[0]);
				

				System.out.println("input :  "+args[0]); // printing input
				//n = s.nextInt();
				//s.close();		
				System.out.println("output : " + SumSquare(n)); // printing output
			} catch (Exception e) {
				System.out.println("Invalid input");
			}
		}
	}
}
