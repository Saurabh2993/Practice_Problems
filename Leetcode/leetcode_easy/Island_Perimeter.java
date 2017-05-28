package leetcode_easy;

public class Island_Perimeter {
	
	public static void main(String args[]) {
		
		int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
		
		int ans = islandPerimeter(grid);
		System.out.println(ans);
		
	}
	
	public static int islandPerimeter(int[][] grid) {
		
		int perimeter = 0;
		int n = grid.length;
		int m = grid[0].length;
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				
				if(grid[i][j] == 1) {
					
					perimeter += 4;
					
					if(i > 0 && grid[i - 1][j] == 1) {
						perimeter -= 2;
					}
					if(j > 0 && grid[i][j - 1] == 1) {
						perimeter -= 2;
					}
				}
			}
		}

		return perimeter;
	}
}