package leetcode_easy;

public class Valid_Perfect_Square {
	
	public static void main(String args[]) {
		
		System.out.println(isPerfectSquare(2147395600));
		
	}

	public static boolean isPerfectSquare(int num) {
		
		if(num == 2147483647)
			return false;
		int i = 0;
		while(i * i <= num) {
			if(i * i == num) {
				return true;
			}
			i++;
		}
		
		return false;
	}
	
}
