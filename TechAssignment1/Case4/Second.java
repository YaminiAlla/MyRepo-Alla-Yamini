package com.hcl.domino;

import com.hcl.domino.techassign1.FirstAccess;
/**
 * This class extends the main class i.e,Second extends FirstAccess class which is in
 * other package 
 *
 */
class Second extends FirstAccess {
	public static void main(String[] args) {
	//Displaying the program to user
		System.out.println("Usage of the program\n The program is used to illustrate the access specifiers\n eg java Second");
		Second s = new Second(); //creating object to Second class
		FirstAccess fa=new FirstAccess();  //creating object to FirstAccess class
		System.out.println(fa.b + " " + fa.cube1(110)); //calling public method by using object
		System.out.println(s.c + " " + s.cube2(120));  //calling protected method by using object
	}
}
