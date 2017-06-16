package leetcode_medium;

import java.util.Arrays;

public class Perfect_Squares {
	
	public static void main(String[] args) {
		
		int n = 22;
		System.out.println(numSquares(n));
		
	}
	
	public static int numSquares(int n) {
		
		int[] min_squares = new int[n + 1];
		Arrays.fill(min_squares, Integer.MAX_VALUE);
		min_squares[0] = 0;
		
		for (int i = 1; i < min_squares.length; i++) {
			int min = Integer.MAX_VALUE;
			int j = 1;
			while (i - j * j >= 0) {
				min = Math.min(min, min_squares[i - j * j] + 1);
				j++;
			}
			min_squares[i] = min;
//			System.out.println(min_squares[i]);
		}
		
		return min_squares[n];
	}

}
