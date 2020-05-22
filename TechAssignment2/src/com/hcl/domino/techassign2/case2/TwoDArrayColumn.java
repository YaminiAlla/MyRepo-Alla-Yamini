package com.hcl.domino.techassign2.case2;
import java.util.Scanner;
public class TwoDArrayColumn {
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

		int prev;

		for (int j = 0; j < n; j++) {
			prev = arr[0][j];
			s[0][j] = prev + "";
			for (int i = 1; i < m; i++) {
				if (arr[i][j] == prev) {
					s[i][j] = "*";
				} else {
					s[i][j] = arr[i][j] + "";
					prev = arr[i][j];
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(s[i][j] + "  ");
			}
			System.out.println();
		}
	}

}
