package leetcode_easy;

import java.util.HashSet;

public class Base7 {
	
	public static void main(String args[]) {
		
		int x = 0;
		
		//fastest solution
		System.out.println(Integer.toString(10, 2));
		convertToBase7(x);
		
		
	}
	
	public static String convertToBase7(int num) {
		
		String ans = "";
		boolean negative = false;
		
		if(num < 0) {
			negative = true;
			num = -num;
		}
		
		do {
			ans = (num % 7) + ans;
			num = num / 7;
		} while (num != 0);
		
		if(negative)
			ans = "-" + ans;
		
		System.out.println(ans);
			return ans;
		
	}

}
