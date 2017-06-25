package leetcode_easy;

import java.util.ArrayList;

public class Reverse_Vowels {
	
	public static void main(String args[]) {
		
		String x = "leetcode";
		System.out.println(reverseVowels(x));
		
	}
	
//	slow solution
	/*public static String reverseVowels(String s) {
		
		if(s.equals(""))
			return s;
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Character> vowels = new ArrayList<>();
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if(s.toLowerCase().charAt(i) == 'a' ||
					s.toLowerCase().charAt(i) == 'e' ||
					s.toLowerCase().charAt(i) == 'i' ||
					s.toLowerCase().charAt(i) == 'o' ||
					s.toLowerCase().charAt(i) == 'u') {
				
				vowels.add(s.charAt(i));
				count++;
				
			}
		}
		
		if(count == 0) {
			return s;
		}
		
		for (int i = 0; i < s.length() && count > 0; i++) {
			if(s.toLowerCase().charAt(i) == 'a' ||
					s.toLowerCase().charAt(i) == 'e' ||
					s.toLowerCase().charAt(i) == 'i' ||
					s.toLowerCase().charAt(i) == 'o' ||
					s.toLowerCase().charAt(i) == 'u') {
				
				sb.append(vowels.get(--count));
				
			} else {
				sb.append(s.charAt(i));
			}
			
		}
		
		System.out.println(sb.toString());
		
		
		return sb.toString();
	}*/
	
//	fast solution where time complexity is half of length of string
	public static String reverseVowels(String s) {
		
		int start = 0;
		int end = s.length() - 1;
		String vowels = "aeiouAEIOU";
		char c[] = s.toCharArray();
		
		while(start < end) {
			while(start < end && !vowels.contains(c[start] + "")) {
				start ++;
			}
			
			while(start < end && !vowels.contains(c[end] + "")) {
				end --;
			}
			
			char temp = c[start];
			c[start] = c[end];
			c[end] = temp;
			
			start++;
			end--;
		}
		
		return new String(c);
	}

}
