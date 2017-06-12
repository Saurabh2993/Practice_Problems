package ctci_easy;

import java.util.ArrayList;
import java.util.List;

public class Zero_Matrix {
	
	public static void main(String args[]) {
		
		int[][] matrix = {{1, 1, 0}, {1, 1, 1}, {1, 0, 1}};
		
		createZeroMatrix(matrix);
		
	}

//	O(1) space approach
	private static void createZeroMatrix(int[][] matrix) {
		
		boolean first_row_zero = false;
		boolean first_col_zero = false;
		
//		Checking if first row and/or first col has a zero
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				first_col_zero = true;
				break;
			}
		}
		
		for (int j = 0; j < matrix[0].length; j++) {
			if(matrix[0][j] == 0) {
				first_row_zero = true;
				break;
			}
		}
		
//		Setting corresponding first element of row or column to zero if any inner row or column has a zero 
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
//		Setting inner rows to zero based on values set in above step
		for (int i = 1; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}
		
//		Setting inner cols to zero based on values set in above step
		for (int j = 1; j < matrix[0].length; j++) {
			if(matrix[0][j] == 0) {
				nullifyColumn(matrix, j);
			}
		}
		
//		Setting first row and/or first column to zero based on boolean values
		if(first_col_zero) nullifyColumn(matrix, 0);
		if(first_row_zero) nullifyRow(matrix, 0);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static void nullifyColumn(int[][] matrix, int j) {
//		Set elements in column i to zero
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][j] = 0;
		}
	}

	private static void nullifyRow(int[][] matrix, int i) {
//		Set elements in row i to zero 
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[i][j] = 0;
		}
		
	}

	
//	O(M*N) space approach
/*	public static void createZeroMatrix(int[][] matrix) {
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		List<Integer> zero_rows = new ArrayList<>();
		List<Integer> zero_cols = new ArrayList<>();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					zero_cols.add(j);
					zero_rows.add(i);
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(zero_rows.contains(i) || zero_cols.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}*/
	
	

}
