package ctci_easy;

import java.util.HashMap;
import java.util.Map;

public class Palindrome_Permutation {
	
	public static void main(String args[]) {
		
		String s = "Taco cat";
		System.out.println(isPalindromePermutation(s));
		
	}
	
	public static boolean isPalindromePermutation(String s) {
		
		s = s.toLowerCase();
		s = s.replaceAll(" ", "");
		
		HashMap<Character, Integer> char_map = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if(char_map.containsKey(curr)) {
				char_map.put(curr, char_map.get(curr) + 1);
			} else {
				char_map.put(curr, 1);
			}
		}
		
		boolean odd_count_found = false;
		for(Character key : char_map.keySet()) {
			if(char_map.get(key) % 2 == 0) {
				continue;
			} else if((char_map.get(key) % 2 == 1 && !odd_count_found)) {
				odd_count_found = true;
			} else {
				return false;
			}
		}
		
		return true;
	}

}
