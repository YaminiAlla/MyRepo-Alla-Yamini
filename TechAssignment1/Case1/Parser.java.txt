package com.hcl.domino.techassign1;

/**
 * This class is created for checking the data type and size of the input given
 * by the user. The size and data type are defined by using some methods in
 * java.lang package.
 * 
 * @author AllaYamini
 * @version 1.8
 */

public class Parser {
	public static void main(String[] args) {

		// Displaying the program to the user.
		if (args.length == 0) {
			System.out.println(
					"The description of the program is :\n\nThe program is used to find the datatype and size of the input\nNeed an input value to determine\ne.g. java Main 1 A Sss 0.15");
		} else {
			for (int n = 0; n < args.length; n++) {
				// Retrieving the first character from the array elements
				char c = args[n].charAt(0);

				// checking the character for alphabet and string
				if (Character.isAlphabetic(c) && args[n].length() > 1) {
					System.out.println(args[n] + " String " + args[n].getBytes().length);
				}

				// checking the alphabet for character
				else if (args[n].length() == 1) {
					System.out.println(args[n] + " Character  " + (Character.BYTES));
				}

				// checking for number
				else {
					IsNumber(args[n]);
				}
			}
		}
	}

	/**
	 * This is the method used for checking for number data type i.e,
	 * int,float/double. The method takes string as a parameter and checks for the
	 * datatype. Exceptional Handling mechanism is used to check the data type.[]
	 * some methods from java.lang package are used for converting the string to the
	 * primitive data type i.e, Integer.parseInt().
	 * 
	 * @return null
	 */
	static void IsNumber(String str) {
		try {

			// checking for integer data type
			int a = Integer.parseInt(str); // converts string to integer
			System.out.println(a + " Integer " + Integer.SIZE / 8); // prints Integer

			//System.out.println(Integer.parseInt(str) + " integer " + (Integer.BYTES));
			
		} catch (Exception e1) {
			try {

				// checking for float data type
				float b = Float.parseFloat(str); // converts string to float
				System.out.println(b + " Float/double " + Float.SIZE / 8); // prints Float/double

				//System.out.println(Float.parseFloat(str) + " Float " + (Float.BYTES));
				
			} catch (Exception e2) {
				try {

					// checking for float/double data type
					float b = Float.parseFloat(str); // converts string to float
					System.out.println(b + " Float/double " + Float.SIZE / 8); // prints Float/double

					//System.out.println(Float.parseFloat(str) + " Float/double " + (Float.BYTES));
					
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
