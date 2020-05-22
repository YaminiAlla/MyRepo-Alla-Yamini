package com.hcl.domino.techassign2.case2;

import java.util.Scanner;

public class TwoDArrayDiagonal {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		String[][] s = new String[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int prev = arr[0][0];

		for (int i = 0; i < n; i++) {
			s[i][0] = prev + "";
			for (int j = 1; j < n; j++) {
				if (i == j) {
					if (arr[i][j] == prev) {
						s[i][j] = "*";
					} else {
						s[i][j] = arr[i][j] + "";
						prev = arr[i][j];
					}
				} else {
					s[i][j] = arr[i][j] + "";
				}
			}
		}

		prev = arr[0][m - 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i + j == (m - 1) && i != 0) {
					if (arr[i][j] == prev) {
						s[i][j] = "* ";
					} else {
						s[i][j] = arr[i][j] + " ";
						prev = arr[i][j];
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(s[i][j] + " ");
			}
			System.out.println();
		}
	}

}
