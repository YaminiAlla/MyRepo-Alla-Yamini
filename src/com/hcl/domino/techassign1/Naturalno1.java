package com.hcl.domino.techassign1;
import java.util.Scanner; //importing scanner class from java.util package

/**
 * The program is used to find the sum of squares of the number.
 * 
 * @author AllaYamini
 * @version 1.8
 */
public class Naturalno1 { // main class
	/**
	 * This is the method used for calculating the squares. This takes an int
	 * parameter given by the user. 
	 * @return int
	 */
	public static int sumsquare(int n)// static method
	{
		return n * (n + 1) * (2 * n + 1) / 6;// formula for sum of squares of first n natural numbers
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n; // initialize input variable
		Scanner s = new Scanner(System.in); // Declare the object and initialize with predefined standard input object
		System.out.print("input : "); // printing input
		n = s.nextInt();
		s.close();
		System.out.print("output : " + sumsquare(n)); // printing output
	}
}
