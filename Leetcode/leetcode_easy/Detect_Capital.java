package leetcode_easy;

public class Detect_Capital {
	
	public static void main(String args[]) {
		
		String s = "FL";
		System.out.println(detectCapitalUse(s));
		
	}
	
	public static boolean detectCapitalUse(String word) {
		
//		regex one line solution
		return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");


//		Brute force solution
		
//		if(word.length() == 1)
//			return true;
//		
//		boolean ans = false;
//		boolean first_char_capital;
//		boolean second_char_capital;
//		
//		if(word.charAt(0) >= 65 && word.charAt(0) <= 90)
//			first_char_capital = true;
//		else
//			first_char_capital = false;
//		
//		
//		if(word.charAt(1) >= 65 && word.charAt(1) <= 90)
//			second_char_capital = true;
//		else
//			second_char_capital = false;
//		
//		for (int i = 1; i < word.length(); i++) {
//			if(first_char_capital) {
//				if(second_char_capital) {
//					if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
//						ans = true;
//					} else {
//						ans = false;
//						break;
//					}
//				} else {
//					if(word.charAt(i) >= 97 && word.charAt(i) <= 122) {
//						ans = true;
//					} else {
//						ans = false;
//						break;
//					}
//				}
//			} else {
//				if(word.charAt(i) >= 97 && word.charAt(i) <= 122) {
//					ans = true;
//				} else {
//					return false;
//				}
//			}
//		}
//		
//		return ans;
	}

}
