package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class Robot_In_Grid {
	
	public class Point {
		
		int rowIndex;
		int colIndex;
		
		public Point(int r, int c) {
			rowIndex = r;
			colIndex = c;
		}
	}
	
	public static void main(String args[]) {
		
		boolean maze[][] = {	{true, true, true, true, false },
								{false, false, false, true, true },
								{false, false, true, true, true },
								{false, false, true, false, true },
								{false, false, true, false, false },
								{false, true, true, true, true }};
		
		Robot_In_Grid r = new Robot_In_Grid();
		ArrayList<Point> answer = r.getPath(maze);
		for (Point p : answer) {
			System.out.println(p.rowIndex + "  " + p.rowIndex);
		}
		
	}
	
	public ArrayList<Point> getPath(boolean[][] maze) {
		
		if(maze == null || maze.length == 0) {
			return null;
		}
		
		ArrayList<Point> answer = new ArrayList<>();
		HashMap<Point, Boolean> cache = new HashMap<>();
		
		int lastRow = maze.length - 1;
		int lastCol = maze[0].length - 1;
		
		if(getPath(maze, lastRow, lastCol, answer, cache)) {
			return answer;
		}
		
		return null;
	}
	
	private boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashMap<Point, Boolean> cache) {
		
		if(col < 0 || row < 0) {
			return false;
		}
		
		if(!maze[row][col]) {
			return false;
		}
		
		Point p = new Point(row, col);
		if(cache.containsKey(p)) {
			return cache.get(p);
		}
		
		if((row == 0 && col == 0) 
				|| getPath(maze, row - 1, col, path, cache)
				|| getPath(maze, row, col - 1, path, cache)
				|| getPath(maze, row, col + 1, path, cache)
				|| getPath(maze, row + 1, col, path, cache)) {
			if(!path.contains(p)) {
				path.add(p);
			}
			cache.put(p, true);
			return true;
		} else {
			cache.put(p, false);
			return false;
		}
	}

}
