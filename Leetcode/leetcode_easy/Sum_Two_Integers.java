package leetcode_easy;

public class Sum_Two_Integers {
	
	public static void main(String args[]) {
		
		int a = 10;
		int b = 3;
		
		getSum(a, b);
		
	}

	public static int getSum(int a, int b) {
		
		int sum = a ^ b;
		int carry = (a & b) << 1;
		
		a = sum;
		b = carry;
		
		System.out.println(a + " " + b);
		
		while(carry != 0) {
			
			sum = a ^ b;
			carry = (a & b) << 1;
			
			a = sum;
			b = carry;
			
			System.out.println(a + " " + b);
			
		}
		
		return sum;
		
	}

}
