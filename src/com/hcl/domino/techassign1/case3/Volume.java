package com.hcl.domino.techassign1.case3;

/**
 * This class defines the usage of variable scope,access modifiers,storage classes
 *@author AllaYamini
 *@version 1.8
 */
import java.util.Scanner; //importing scanner class from java.util package

public class Volume { // main class
//variable can access in whole class of Volume
	// static variable(class level scope)
	static int width = 5;

	public static void main(String[] args) { // main method
		// TODO Auto-generated method stub
		
		// Displaying the program to the user
		if (args.length == 0||args[0].equals("-h")||args[0].equals("--help")||args[0].equals("-H")||args[0].equals("--HELP")) {
			System.out.println(
					"The description of the program is:\nThe program is used for displaying the Volume using variable scope and accessmodifiers\nNeed a input value to display the details\ne.g. java Volume 15");
		} 
		// method level variable scope that can be access only in this method 
		int length = 30;
		// Declare the object and initialize with predefined standard input object
			Scanner s = new Scanner(System.in);
			System.out.print("Enter n value :"); // prints enter n value
			int n = s.nextInt(); // read n value from user
			s.close();
			System.out.println(Volume.width + " "); // No Error because variable is accessible throughout class
			System.out.println("Volume of pyramid of different height values are below"); // prints statement

			// loop level scope
			for (int height = 5; height <= n; height++) {
				int volume = (length * height * width) / 3; // calculate volume
				System.out.println("Volume of pyramid : " + volume + " where height is " + height);// prints volume for
																									// given height
				/*
				 * Volume.display(); System.out.print(Volume.width+" ");
				 */
			}

		}
	
//Storage classes 'static' keyword have been used here
	static void display() {
		System.out.print(Volume.width + " ");
		// System.out.print(Volume.length+" "); Error because accessible only up to method
		// System.out.print(Volume.height+" "); Error because accessible only up to Class

	}
}
