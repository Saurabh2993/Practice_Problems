package leetcode_medium;

import java.util.Arrays;

public class Multiply_Strings {
	
	public static void main(String args[]) {
		
		String num1 = "99";
		String num2 = "0";
		
		System.out.println(multiply(num1, num2));
		
	}
	
	public static String multiply(String num1, String num2) {
		
		if(num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		
		int m = num1.length();
		int n = num2.length();
		int digits[] = new int[m + n];
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				
				int mul = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
				System.out.println(mul);
				System.out.println(mul%10);
				System.out.println(mul/10);
				
				int p1 = i + j + 1;
				int p2 = i + j;
				System.out.println("digits[p1]" + digits[p1]);
				int x = digits[p1] + mul % 10; 
				if(x >= 10) {
					digits[p1] = x % 10;
					digits[p1 - 1] = digits[p1 - 1] + 1;
				} else {
					digits[p1] = x;
				}
				System.out.println("digits[p1]" + digits[p1]);
				
				System.out.println("digits[p2]" + digits[p2]);
				int y = digits[p2] + mul / 10;
				if(y >= 10) {
					digits[p2] = y % 10;
					digits[p2 - 1] = digits[p2 - 1] + 1;
				} else {
					digits[p2] = y;
				}
				System.out.println("digits[p2]" + digits[p2]);
				
				for (int k = 0; k < digits.length; k++) {
					System.out.print(digits[k] + " ");
				}
				System.out.println();
				
			}
		}
		
		StringBuilder builder = new StringBuilder();
		if(digits[0] != 0)
			builder.append(digits[0]);
		for (int i = 1; i < m + n; i ++) {
			  builder.append(digits[i]);
		}
		return builder.toString();
		
	}
}
