package leetcode_easy;

public class Perfect_Number {
	
	public static void main(String args[]) {
		
		int num = 6;
		
		System.out.println(checkPerfectNumber(num));
		
	}
	
	public static boolean checkPerfectNumber(int num) {
		
		int divisor_sum = 1;
		
		for (int i = 2; i < Math.sqrt(num); i++) {
			
			int j = num / i;
			
			if(i * j == num) {
				divisor_sum = divisor_sum + i + j; 
			}
		}
		
		
		if(divisor_sum == num)
			return true;
		else
			return false;
		
	}

}
