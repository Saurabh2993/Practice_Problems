package leetcode_medium;

public class Minimum_Path_Sum {
	
	public static void main(String args[]) {
		
		int grid[][] = {{2, 1, 6, 0}, {3, 4, 10, 0}, {5, 0, 2, 4}, {4, 9, 1, 5}};
		Minimum_Path_Sum m = new Minimum_Path_Sum();
		System.out.println(m.minPathSum(grid));
		
	}
	
	
	
	public int minPathSum(int[][] grid) {
        if(grid.length == 0) {
            return 0;
        } if(grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(i == 0 && j == 0) {
                } else if(i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if(j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        
        return grid[m - 1][n - 1];
    }

}
