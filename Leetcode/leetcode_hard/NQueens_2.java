package leetcode_hard;

import java.util.List;
import java.util.ArrayList;

public class NQueens_2 {
	
	public static void main(String args[]) {
		
		int n = 8;
		NQueens_2 nq = new NQueens_2();
		
		System.out.println(nq.totalNQueens(n));
	}
	
	public int totalNQueens(int n) {
		
		Integer[] columns = new Integer[n];
		List<Integer[]> result = new ArrayList<>();
		
		placeQueens(n, 0, columns, result);
		
		return result.size();
		
	}

	private void placeQueens(int size, int row, Integer[] columns, List<Integer[]> result) {
		
		if(row == size) {
			result.add(columns.clone());
			return;
		}
		
		for(int col = 0; col < size; col ++) {
			if(checkValid(columns, row, col)) {
				columns[row] = col;
				placeQueens(size, row + 1, columns, result);
			}
		}
		
	}

	private boolean checkValid(Integer[] columns, int row, int col) {
		
		for(int row2 = 0; row2 < row; row2++) {
			
			int col2 = columns[row2];
			
//			Check if there is already a queen placed in that column
			if(col == col2) {
				return false;
			}
			
//			Check if there is a queen placed diagonally
			if(Math.abs(row - row2) == Math.abs(col - col2)) {
				return false;
			}
			
		}

		return true;
	}

}
