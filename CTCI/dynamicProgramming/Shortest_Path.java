package dynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path {
	
	public static void main(String args[]) {
		
		int matrix[][] = {	{0, 0, 0, 0, 1 },
							{1, 1, 1, 0, 0 },
							{1, 1, 0, 0, 0 },
							{1, 1, 0, 1, 0 },
							{1, 1, 0, 1, 1 },
							{1, 0, 0, 0, 0 }};

		Shortest_Path s = new Shortest_Path();
		System.out.println(s.findShortestPathLength(matrix));
	}
	
	boolean visited[][];
	public int findShortestPathLength(int [][] matrix) {
		
		if(matrix == null || matrix.length == 0) {
			return 0;
		}
		
		int n = matrix.length;
		int m = matrix[0].length;
		
		if(matrix[0][0] == 1 || matrix[n - 1][m - 1] == 1) {
			return -1;
		}
		
		visited = new boolean[n][m];
		int len = 0;
		Queue<int[]> q = new LinkedList<>();
		int c[] = {0, 0};
		visited[0][0] = true;
		
		q.add(c);
		q.add(null);
		int temp[] = {0, 0};
		
		while(q.size() != 1) {
			temp = q.remove();
			if(temp == null) {
				len++;
				q.add(null);
				continue;
			}
//			System.out.println(temp[0] + "  " + temp[1]);
			if(temp[0] == n - 1 && temp[1] == m - 1) {
				len++;
				break;
			}
			
			checkAndAdd(matrix, q, temp[0] + 1, temp[1], n, m);
			checkAndAdd(matrix, q, temp[0] - 1, temp[1], n, m);
			checkAndAdd(matrix, q, temp[0], temp[1] + 1, n, m);
			checkAndAdd(matrix, q, temp[0], temp[1] - 1, n, m);
			
		}
		
		if(temp[0] == n - 1 && temp[1] == m - 1)
			return len;
		else
			return -1;
	}

	private void checkAndAdd(int[][] matrix, Queue<int[]> q, int i, int j, int m, int n) {
//		System.out.println(i + " " + n + " " + j + " " + m);
		if(i >= 0 && i < m && j >= 0 && j < n) {
			if(!visited[i][j] && matrix[i][j] == 0) {
				visited[i][j] = true;
				int[] temp = {i, j};
				q.add(temp);
			}
		}
	}
}
