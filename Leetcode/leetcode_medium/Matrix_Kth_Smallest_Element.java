package leetcode_medium;

import java.util.Arrays;

public class Matrix_Kth_Smallest_Element {
	
	public static void main(String args[]) {
		
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		
		System.out.println(kthSmallest(matrix, 5));
		
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
