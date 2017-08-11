package leetcode_medium;

public class Range_Sum_2D {
	
	public static void main(String args[]) {
		
		int[][] matrix = {
		                  {3, 0, 1, 4, 2},
		                  {5, 6, 3, 2, 1},
		                  {1, 2, 0, 1, 5},
		                  {4, 1, 0, 1, 7},
		                  {1, 0, 3, 0, 5}
		                  };
		
		NumMatrix n = new NumMatrix(matrix);
		System.out.println(n.sumRegion(2, 1, 4, 3));
		
	}
}

class NumMatrix {
	
	int dp[][];
	
	public NumMatrix(int[][] matrix) {
        
		int m = matrix.length;
		int n = matrix[0].length;
		
		dp = new int[m + 1][n + 1];
		
		for(int i = 0; i < m; i ++) {
			for(int j = 0; j < n; j++) {
				dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] + matrix[i][j] - dp[i][j];
			}
		}
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}