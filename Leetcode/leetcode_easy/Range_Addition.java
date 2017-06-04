package leetcode_easy;

public class Range_Addition {
	
	public static void main(String args[]) {
		
		int m = 18;
		int n = 3;
		int[][] ops = {{16,1},{14,3},{14,2},{4,1},{10,1},{11,1},{8,3},{16,2},{13,1},{8,3},{2,2},{9,1},{3,1},{2,2},{6,3}};
		
		System.out.println(maxCount(m, n, ops));
		
	}
	
	public static int maxCount(int m, int n, int[][] ops) {
		
		if(ops.length == 0)
			return m * n;
		
		int min_1 = Integer.MAX_VALUE;
		int min_2 = Integer.MAX_VALUE;
		for (int i = 0; i < ops.length; i++) {
			if(ops[i][0] < min_1)
				min_1 = ops[i][0];
			if(ops[i][1] < min_2)
				min_2 = ops[i][1];
			
		}
		return min_1 * min_2;
	}

}
