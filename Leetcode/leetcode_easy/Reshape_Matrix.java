package leetcode_easy;

public class Reshape_Matrix {
	
	public static void main(String args[]) {
		
		int[][] nums = {{1, 2}, {3, 4}};
		int r = 1;
		int c = 4;
		
		int[][] ans = matrixReshape(nums, r, c);
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		
		int n = nums.length;
		int m = nums[0].length;
		
		if(n * m != r * c) {
			
			return nums;
			
		}
//		else {
//			
//			int[] values = new int[r * c];
//			int pointer = 0;
//			
//			for (int i = 0; i < nums.length; i++) {
//				for (int j = 0; j < nums[0].length; j++) {
//					values[pointer] = nums[i][j];
//					pointer ++;
//				}
//			}
//			
//			int[][] result_matrix = new int[r][c];
//			pointer = 0;
//			
//			for (int i = 0; i < r; i++) {
//				for (int j = 0; j < c; j++) {
//					result_matrix[i][j] = values[pointer];
//					pointer ++;
//				}
//			}
//			
//			return result_matrix;
//			
//		}
		
		else {
			
			int[][] result_matrix = new int[r][c];
			for (int i = 0; i < r * c; i++) {
				result_matrix[i / c][i % c] = nums[i / m][i % m];
			}
			
			return result_matrix;

		}
	}
}
