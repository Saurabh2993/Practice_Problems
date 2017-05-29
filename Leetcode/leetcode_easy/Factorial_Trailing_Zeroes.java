package leetcode_easy;

public class Factorial_Trailing_Zeroes {
	
	public static void main(String args[]) {
		
		int n = 1808548329;
		int ans = trailingZeroes(n);
		
		System.out.println(ans);
		
	}
	
	public static int trailingZeroes(int n) {
		
		int zero_count = 0;
		long i;
		for (i = 5; i < n; i = i * 5) {
			System.out.println(i);
			zero_count = (int) (zero_count + (n / i));
		}
		System.out.println(i);
		if(i == n)
			zero_count++;
		
		return zero_count;
		
	}

}
