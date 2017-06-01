package leetcode_medium;

import java.util.Arrays;

public class Matrix_Kth_Smallest_Element {
	
	public static void main(String args[]) {
		
		int[][] matrix = {{ 1,  5,  9}, {10, 11, 13}, {12, 13, 15}};
		
		System.out.println(kthSmallest(matrix, 8));
		
	}
	
	public static int kthSmallest(int[][] matrix, int k) {
		
		int[] nums = new int [matrix.length * matrix[0].length]; 
		
		int x = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				nums[x] = matrix[i][j];
				x++;
			}
		}
		
		Arrays.sort(nums);
    		
		
		return nums[k - 1];
		
    }

}
