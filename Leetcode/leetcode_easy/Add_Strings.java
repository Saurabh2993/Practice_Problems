package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Add_Strings {
	
public static void main(String args[]) {
		
		String num1 = "123";
		String num2 = "99";
		
		System.out.println(addStrings(num1, num2));
		
	}

	public static String addStrings(String num1, String num2) {
		
		if(num1.equals("0")) {
			return num2;
		} else if(num2.equals("0")) {
			return num1;
		}
		
		int m = num1.length();
		int n = num2.length();
		
		int result[];
		
		if(m >= n) {
			result = new int[m + 1];
			for (int i = n; i < m; i++) {
				num2 = "0" + num2;
			}
		} else {
			result = new int[n + 1];
			for (int i = m; i < n; i++) {
				num1 = "0" + num1;
			}
		}
		
//		System.out.println(num1 + " " + num2);
		
		for (int i = num1.length() - 1; i >= 0; i--) {
			
//			System.out.println(num1.charAt(i) + " " + num2.charAt(i));
//			System.out.println(i);
			int pos = i + 1;
			int sum = result[pos] + (num1.charAt(i) - '0') + (num2.charAt(i) - '0');
//			System.out.println(sum);

			if(sum >= 10) {
				result[pos] = sum % 10;
				result[pos - 1] = result[pos - 1] + 1;
			} else {
				result[pos] = sum;
			}
//			System.out.println(Arrays.toString(result));
		}
		
		StringBuilder builder = new StringBuilder();
		if(result[0] != 0)
			builder.append(result[0]);
		for (int i = 1; i < result.length; i ++) {
			  builder.append(result[i]);
		}
		
		return builder.toString();
		
	}


}
