package leetcode_easy;

public class Palindrome_Number {
	
	public static void main (String args[]) {
		
		int x = 14641;
		System.out.println(isPalindrome(x));
		
	}
	
	public static boolean isPalindrome(int x) {
		
		String num = Integer.toString(x);
		int len = num.length();
		
		if(len == 1)
			return true;
		
		boolean palindrome = true;
		
		for (int i = 0; i < len / 2; i++) {
			
			if(num.charAt(i) == num.charAt(len - 1 - i)) {
				continue;
			} else {
				palindrome = false;
				break;
			}
		}
		
		return palindrome;
	}
}
