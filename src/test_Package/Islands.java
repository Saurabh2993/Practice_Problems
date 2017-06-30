package test_Package;

import java.util.LinkedList;
import java.util.Queue;

public class Islands {
	
	public static void main(String args[]) {
		
		int [][] binaryMatrix = { 	{0,    1,    0,    1,    0},
                         			{0,    0,    1,    1,    1},
                 					{1,    0,    0,    1,    0},
             						{0,    1,    1,    0,    0},
             						{1,    0,    1,    0,    1} };
		
		Islands i = new Islands();
		System.out.println(i.getNumberOfIslands(binaryMatrix));
		
	}
	
	public int getNumberOfIslands(int[][] binaryMatrix) {
		
		int count = 0;
		int rows = binaryMatrix.length;
		int cols = binaryMatrix[0].length;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				
				if(binaryMatrix[i][j] == 1) {
					count++;
					markIsland(binaryMatrix, rows, cols, i, j);
				}
			}
		}
		
		return count;
	}
	
	public void markIsland(int[][] binaryMatrix, int rows, int cols, int i, int j) {
		
		
		Queue<Integer[]> island_area = new LinkedList<>();
		Integer index[] = {i, j};
		
		island_area.add(index);
		
		while(!island_area.isEmpty()) {
			index = island_area.remove();
			int x = index[0];
			int y = index[1];
			
			if(binaryMatrix[x][y] == 1) {
				binaryMatrix[x][y] = -1;
				ifValidPush(island_area, rows, cols, x + 1, y);
				ifValidPush(island_area, rows, cols, x - 1, y);
				ifValidPush(island_area, rows, cols, x, y + 1);
				ifValidPush(island_area, rows, cols, x, y - 1);
				
			}
		}
	}
	
	public void ifValidPush(Queue<Integer []> island_area, int rows, int cols, int x, int y) {
		if(x >= 0 && x < rows && y >= 0 && y < cols) {
			Integer index[] = {x, y};
			island_area.add(index);
		}
	}

}
