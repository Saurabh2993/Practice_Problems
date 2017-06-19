package leetcode_easy;

public class Hamming_Weight {
	
	public static void main(String args[]) {
		
		int x =   -2147483648;
		System.out.println(hammingWeight(x));
	}
	
	public static int hammingWeight(int n) {
		
		int count = 0;
		
		int i = 0;
		while(i != 32) {
			
			if((n & 1) == 1)
				count ++;
			
			System.out.println(n);
			n = n >> 1;
			
			i++;
		}
		
		return count;
	}

}
