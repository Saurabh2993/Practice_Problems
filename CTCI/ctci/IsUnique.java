package ctci;

import java.util.HashSet;

public class IsUnique {
	
	public static void main(String args[]) {
		
		String s = "saurabh";
		System.out.println(isUnique(s));
		
	}
	
//	O(n) time complexity. O(1) space complexity. Assuming it only uses lower case letters a-z.
/*	public static boolean isUnique(String s) {
		
		int checker = 0;
		
		for (int i = 0; i < s.length(); i++) {
			
			int val = s.charAt(i) - 'a';
			if((checker & (1 << val)) > 0) {
				return false;
			}
			checker = checker | (1 << val);
		}
		
		return true;
	}
*/	
	
//	O(n) time complexity. O(n) space complexity. Works for all characters.
	public static boolean isUnique(String s) {
		
		HashSet<Character> char_set = new HashSet<>();
		
		for (int i = 0; i < s.length(); i++) {
			if(!char_set.add(s.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
}
