package leetcode_easy;

public class Arrange_Coins {
	
	public static void main(String args[]) {
		
		int n = 6;
		System.out.println(arrangeCoins(n));
		
	}
	
	public static int arrangeCoins(int n) {
		
		if(n == 0 || n == 1)
			return n;
		
		int count = 0;
		
		for (int i = 1; ; i++) {
			n = n - i;
			if(n < 0) {
				break;
			} else {
				count ++;
			}
		}
		
		return count;
	}

}
