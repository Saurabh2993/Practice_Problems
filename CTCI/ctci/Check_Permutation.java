package ctci;

import java.util.HashMap;

public class Check_Permutation {
	
	public static void main(String args[]) {
		
		String s = "aaabacc";
		String t = "bcabcaa";
		
		System.out.println(checkPermutation(s, t));
		
	}
	
	public static boolean checkPermutation(String s, String t) {
		
		if(s.length() != t.length())
			return false;
		
		HashMap<Character, Integer> char_map = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if(char_map.containsKey(curr)) {
				char_map.put(curr, char_map.get(curr) + 1);
			} else {
				char_map.put(curr, 1);
			}
		}
		
		for (int i = 0; i < t.length(); i++) {
			char curr = t.charAt(i);
			
			if(char_map.containsKey(curr)) {
				System.out.println(curr + " " + char_map.get(curr));
				if(char_map.get(curr) > 0) {
					char_map.put(curr, char_map.get(curr) - 1);
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		
		return true;
		
	}

}
