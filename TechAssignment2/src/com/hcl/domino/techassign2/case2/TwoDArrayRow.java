package com.hcl.domino.techassign2.case2;

/**
 * Given a matrix of size M*N with only 0s and 1s, provide the options to perform the following
 * [options like row wise,column wise,diagonal]
 * @author AllaYamini
 * @version 1.8
 */

import java.util.Scanner;

public class TwoDArrayRow {

	public static void main(String[] args) {

		// Displaying the program to the user.
		if (args.length == 0 || args[0].equals("-h") || args[0].equals("--help") || args[0].equals("-H")
				|| args[0].equals("--HELP")) {
			System.out.println(
					"The description of the program is :\n\nGiven a matrix of size M*N with only 0s and 1s, provide the options to perform the following\nNeed a input value to determine it\ne.g. java TwoDArray 4 4");
		// System.out.println("select an option \n1.Row wise 2.Column wise 3.Diagonal wise");
		} else {
			Scanner sc = new Scanner(System.in);
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[][] arr = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int prev;
// Row wise processing of the numbers to replace the repeating number by only one representation of the same number and remaining spaces to be filled by ‘*’
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i][0] + " ");
				prev = arr[i][0];
				for (int j = 1; j < n; j++) {
					if (arr[i][j] == prev) {
						System.out.print("* ");
					} else {
						System.out.print(arr[i][j] + " ");
						prev = arr[i][j];
					}
				}
				System.out.println();
			}
		}
		
		
	}
}