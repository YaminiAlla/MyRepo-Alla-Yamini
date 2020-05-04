package com.hcl.domino.techassign1.case1;

/**
 * This class is created for checking the data type and size of the input given
 * by the user. The size and data type are defined by using some methods in
 * java.lang package.
 * 
 * @author AllaYamini
 * @version 1.8
 */

public class Parser1 {
	public static void main(String[] args) {
		/**
		 * This is the method used for checking for number data type i.e,
		 * int,float/double. The method takes string as a parameter and checks for the
		 * datatype. Exceptional Handling mechanism is used to check the data type.[]
		 * some methods from java.lang package are used for converting the string to the
		 * primitive data type i.e, Integer.parseInt().
		 */

		// Displaying the program to the user.
		if (args.length == 0||args[0].equals("-h")||args[0].equals("--help")||args[0].equals("-H")||args[0].equals("--HELP")) {
			System.out.println(
					"The description of the program is :\n\nThe program is used to find the datatype and size of the input\nNeed a input value to determine it\ne.g. java Main 1 A Sss 0.15");
		} else {
			// Ingeneral java has 8 primitive datatypes,sizeof command is not worked in Java
			for (int n = 0; n < args.length; n++) {
				try {
					int a = Integer.parseInt(args[n]); // converts string to integer
					System.out.println(a + " Integer " + Integer.SIZE / 8); // prints Integer
				} catch (NumberFormatException ne) {
					try {
						float b = Float.parseFloat(args[n]); // converts string to float
						System.out.println(b + " Float/double " + Float.SIZE / 8); // prints Float/double
					} catch (Exception e) {
						if (args[n].length() == 1) {
							System.out.println(args[n] + " Char " + Character.SIZE / 8); // prints Character
						} else {
							System.out.println(args[n] + " String " + args[n].length()); // prints String
							// String is non-primitive datatype so default size is not specified here.
						}
					}
				}
			}
		}
	}
}