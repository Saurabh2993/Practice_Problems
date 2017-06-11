package leetcode_easy;

public class Climbing_Stairs {
	
	public static void main(String args[]) {
		
		System.out.println(climbStairs(5));
		
	}
	
	public static int climbStairs(int n) {
		
		if(n == 0 || n == 1 || n == 2)
			return n;
		
		int a = 1;
		int b = 1;
		int result = 0;
		int count = 2;
		while(count != n + 1) {
			result = a + b;
			b = a;
			a = result;
			count ++;
		}
		
//		System.out.println(result);
		
		return result;
	}

}
