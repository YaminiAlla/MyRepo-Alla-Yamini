package com.hcl.domino.techassign1.case4;

/**
 * This class illustrates the difference between access specifiers
 * 
 * @author AllaYamini
 * @version 1.8
 */
public class FirstAccess { // main class
	private int a = 100; // initialize variables in private access
	public int b = 150; // initialize variables in public access
	protected int c = 200; // initialize variables in protected access

	/**
	 * This private method is used within class only
	 * 
	 * @param a
	 * @return
	 */

	private int cube(int a) // can be invoked in this package only because access specifier is private
	{
		return a * a * a; // volume of cube is a3
	}

	/**
	 * This public is used in anywhere
	 * 
	 * @param b
	 * @return
	 */

	public int cube1(int b) // can access in this and other package also
	{
		return b * b * b;
	}

	/**
	 * This protected method is used within package and subclass in other package
	 * 
	 * @param x
	 * @return
	 */

	protected int cube2(int c) // can access in this and other package also
	{
		return c * c * c;
	}

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		// Displaying the program to user
		if (args.length == 0 || args[0].equals("-h") || args[0].equals("--help") || args[0].equals("-H")
				|| args[0].equals("--HELP")) {
			System.out.println(
					"Usage of the program\n The program is used to illustrate the access specifiers\n eg java FirstAccess ");
		} else {

			FirstAccess fa = new FirstAccess(); // creating object to class

			// calling private method by using object
			System.out.println(fa.a + " " + fa.cube(100)); // object of constructor invokes here
			// calling public method by using object
			System.out.println(fa.b + " " + fa.cube1(101)); 
			// calling protected method by using object
			System.out.println(fa.c + " " + fa.cube2(102)); 
		}
	}
}
