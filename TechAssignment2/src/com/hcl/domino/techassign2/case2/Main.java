package com.hcl.domino.techassign2.case2;

import java.util.Scanner;

/**
 * This class performs operations for finding the sequence of repeated numbers
 * column-wise, row-wise and diagonal wise.
 */
public class Main {
	/**
	 * This method reads the elements into the matrix
	 * 
	 * @return mat
	 */
	public static int[][] readMatrix(int M, int N) {
		int i, j, temp;
		Scanner in = null;
		int[][] mat = new int[0][];
		try {
			in = new Scanner(System.in);
			mat = new int[M][N];
			System.out.println("Enter the elements of the binary matrix");
			for (i = 0; i < M; i++) {
				for (j = 0; j < N; j++) {
					temp = in.nextInt();
					if (temp == 0 || temp == 1) {
						mat[i][j] = temp;
					} else {
						throw new Exception();
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Exception Occurred Please enter 0 and 1 only");
		} finally {
			return mat;
		}
	}

	/**
	 * This method processes the row elements in the array.
	 * 
	 * @param mat
	 * @return null
	 */
	public static void modifymatr(int mat[][], int M, int N) {
		int ospos = -1, oendpos = -1, zspos = -1, zendpos = -1, ocount = 0, zcount = 0;
		int mm = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 1; j < N; j++) {
				if (mat[i][j] == 1 && mat[i][j - 1] == 1) {
					if (ocount == 0) {
						ospos = j;
						oendpos = j;
						ocount++;
					} else {
						oendpos++;
						ocount++;
					}
				} else if (mat[i][j] == 0 && mat[i][j - 1] == 0) {
					if (zcount == 0) {
						zspos = j;
						zendpos = j;
						zcount++;
					} else {
						zendpos++;
						zcount++;
					}
				}
			}
			int c = 0;
			if (zcount > 0 || ocount > 0) {
				for (int j = 0; j < N; j++) {
					if (zcount > 0) {
						if (j >= zspos && j <= zendpos)
							c++;
						else
							System.out.print("" + mat[i][j] + " ");
					} else if (ocount > 0) {
						if (j >= ospos && j <= oendpos)
							c++;
						else
							System.out.print("" + mat[i][j] + " ");
					} else {
						System.out.print("" + mat[i][j] + " ");
					}
				}
				for (int j = 0; j < c; j++) {
					System.out.print("* ");
				}
			} else {
				for (int j = 0; j < N; j++) {
					System.out.print("" + mat[i][j] + " ");
				}
				mm++;
			}
			System.out.println();
			ospos = -1;
			oendpos = -1;
			zspos = -1;
			zendpos = -1;
			ocount = 0;
			zcount = 0;
		}
		if (mm == M) {

			System.out.println("No Repeated elements in the matrix");
		}
	}

	/**
	 * This method is used for processing the column elements in the matrix
	 * 
	 * @param matrix
	 * @return null
	 */
	public static void modifymatc(int mat[][], int M, int N) {
		int ospos = -1, oendpos = -1, zspos = -1, zendpos = -1, ocount = 0, zcount = 0;
		String transpose[][] = new String[100][100];
		int mm = 0;
		int tp1;
		int tp2 = 0;
		for (int i = 0; i < M; i++) {
			tp1 = i;
			tp2 = 0;
			for (int j = 1; j < N; j++) {
				if (mat[i][j] == 1 && mat[i][j - 1] == 1) {
					if (ocount == 0) {
						ospos = j;
						oendpos = j;
						ocount++;
					} else {
						oendpos++;
						ocount++;
					}
				} else if (mat[i][j] == 0 && mat[i][j - 1] == 0) {
					if (zcount == 0) {
						zspos = j;
						zendpos = j;
						zcount++;
					} else {
						zendpos++;
						zcount++;
					}
				}
			}
			int c = 0;

			if (zcount > 0 || ocount > 0) {
				for (int j = 0; j < N; j++) {
					if (zcount > 0) {
						if (j >= zspos && j <= zendpos)
							c++;
						else {
							// System.out.print(""+mat[i][j]+" ");
							transpose[tp1][tp2] = String.valueOf(mat[i][j]);
							// System.out.print(transpose[tp1][tp2]);
							tp2++;
						}
					} else if (ocount > 0) {
						if (j >= ospos && j <= oendpos)
							c++;
						else {
							// System.out.print(""+mat[i][j]+" ");
							transpose[tp1][tp2] = String.valueOf(mat[i][j]);
							// System.out.print(transpose[tp1][tp2]);
							tp2++;
						}
					} else {
						// System.out.print(""+mat[i][j]+" ");
						transpose[tp1][tp2] = String.valueOf(mat[i][j]);
						// System.out.print(transpose[tp1][tp2]);
						tp2++;
					}
				}
				for (int j = 0; j < c; j++) {
					// System.out.print("* ");
					transpose[tp1][tp2] = "*";
					// System.out.print(transpose[tp1][tp2]);
					tp2++;
				}
			} else {
				for (int j = 0; j < N; j++) {
					// System.out.print(""+mat[i][j]+" ");
					transpose[tp1][tp2] = String.valueOf(mat[i][j]);
					// System.out.print(transpose[tp1][tp2]);
					tp2++;
				}
				mm++;
			}
			// System.out.println(tp1);
			ospos = -1;
			oendpos = -1;
			zspos = -1;
			zendpos = -1;
			ocount = 0;
			zcount = 0;
		}
		String transpose1[][] = new String[M][N];
		for (int i1 = 0; i1 < M; i1++) {
			for (int j1 = 0; j1 < N; j1++) {
				transpose1[i1][j1] = transpose[j1][i1];
			}
		}
		for (int i1 = 0; i1 < M; i1++) {
			for (int j1 = 0; j1 < N; j1++) {
				System.out.print(transpose1[i1][j1] + " ");
			}
			System.out.println();
		}
		if (mm == M) {
			System.out.println("No Repeated Elements in the matrix");
		}

	}

	public static void main(String[] args) {
		int M, N, i, j, temp;
		int option;
		int mat[][];
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			System.out.println("Enter the no.of rows in the matrix");
			M = in.nextInt();
			System.out.println("Enter the no.of columns in the matrix");
			N = in.nextInt();
			mat = readMatrix(M, N);
			do {
				System.out.println(
						"Select an option for processing the matrix\\n1.Row processing\\n2.Column Processing\\n3.Diagonal Processing \\n 4.exit");
				option = in.nextInt();
				switch (option) {
				case 1:
					modifymatr(mat, M, N);
					break;
				case 2:
					int transpose[][] = new int[M][N];
					for (int i1 = 0; i1 < M; i1++) {
						for (int j1 = 0; j1 < N; j1++) {
							transpose[i1][j1] = mat[j1][i1];
						}
					}
					modifymatc(transpose, M, N);
					break;
				case 3:
					System.out.println("Implement the diagonals code Here");
					break;
				case 4:
					break;
				default:
					System.out.println("Please enter correct option");
				}
			} while (option != 4);

		} catch (Exception e) {
			System.out.println("Exception Occurred Please enter 0 and 1 only " + e);
		} finally {
			in.close();
		}
	}
}