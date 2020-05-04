package com.hcl.domino.techassign1.case6;

import java.util.Arrays;

/**
 * This class illustrates the shallow and deep copy of the object and
 * constructor overloading.
 */

public class ShallowDeepCopy {

	// Declaring the variables as integer and character with private access modifier
	private int values;
	private char[] characters = new char[20];

	/**
	 * This is the default constructor
	 */
	ShallowDeepCopy() {
		System.out.println("This is a default constructor");
	}

	/**
	 * This is the Parameterized constructor
	 * 
	 * @param value
	 */
	ShallowDeepCopy(int value) {
		this.values = value;
		System.out.println("This is overloaded constructor with integer value ");
	}

	/**
	 * This is the Parameterized constructor
	 * 
	 * @param values
	 */
	ShallowDeepCopy(char[] values) {
		characters = new char[values.length];
		for (int i = 0; i < characters.length; i++) {
			characters[i] = values[i];
		}
		System.out.println("This is overloaded constructor with character value ");
	}

	/**
	 * This is the Parameterized constructor
	 * 
	 * @param value ,values
	 */
	ShallowDeepCopy(int value, char[] values) {
		this.characters = values;
		this.values = value;
		System.out.println("This is overloaded constructor with integer,character values");
	}

	/**
	 * This is a method which is used to display the integer and character values
	 * 
	 * @return null
	 */
	public void display() {
		System.out.println("The integer value is: " + values + "\nThe character values are: " + Arrays.toString(characters));
	}

	public static void main(String[] args) {
		// Displaying the program to the user
		if (args.length == 0||args[0].equals("-h")||args[0].equals("--help")||args[0].equals("-H")||args[0].equals("--HELP")) {
			System.out.println(
					"The description of the program\nThe program is used for displaying the values\nNeed input value to display\ne.g. java ShallowDeepCopy 2");
		} else {
			char C[] = { 'a', 'b', 'c', 'd', 'e' };

			ShallowDeepCopy sdc = new ShallowDeepCopy();
			try {
				ShallowDeepCopy sdc1 = new ShallowDeepCopy(Integer.parseInt(args[0]));
				sdc1.characters = C;
				sdc1.display();

				// deep copying
				System.out.println("Deep copy");
				ShallowDeepCopy sdc2 = new ShallowDeepCopy(C);
				sdc2.values = 15;
				sdc2.display();
				C[0] = 'y';
				sdc2.display();

				// shallow copying
				System.out.println("Shallow copy");
				ShallowDeepCopy sdc3 = new ShallowDeepCopy(45, C);
				sdc3.display();
			} catch (Exception e) {
				System.out.println("Invalid input");
			}
		}

	}
}