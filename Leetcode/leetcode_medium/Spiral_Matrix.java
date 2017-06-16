package leetcode_medium;

public class Spiral_Matrix {
	
	public static void main(String args[]) {
		
		generateMatrix(1);
		
		
	}
	
	public static int[][] generateMatrix(int n) {
		
		int answer[][] = new int[n][n];
		int direction = 1;
		int num = 1;
		int x = 0;
		int y = 0;
		int layer = 0;
		
		while(num <= n * n) {
			switch (direction) {
			case 1:
				answer[x][y] = num;
				if(y == n - 1 - layer) {
					direction = 2;
					x++;
				} else {
					y++;
				}
				break;

			case 2:
				answer[x][y] = num;
				if(x == n - 1 - layer) {
					direction = 3;
					y--;
				} else {
					x++;
				}
				break;
			
			case 3:
				answer[x][y] = num;
				if(y == layer) {
					direction = 4;
					x--;
				} else {
					y--;
				}
				break;
				
			case 4:
				answer[x][y] = num;
				if(x == layer + 1) {
					direction = 1;
					layer++;
					y++;
				} else {
					x--;
				}
				break;
			}
			num++;
		}
		
//		for (int i = 0; i < answer.length; i++) {
//			for (int j = 0; j < answer.length; j++) {
//				System.out.print(answer[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		return answer;
	}

}
