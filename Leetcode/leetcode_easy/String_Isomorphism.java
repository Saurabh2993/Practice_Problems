package leetcode_easy;

import java.util.HashMap;
import java.util.Map;

public class String_Isomorphism {
	
	public static void main(String args[]) {
		
		String s = "ab";
		String t = "aa";
		
		System.out.println(isIsomorphic(s, t));
	}
	
	public static boolean isIsomorphic(String s, String t) {
		
		if(s.length() != t.length())
			return false;
		
		Map<Character, Character> char_map = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			
			char a = s.charAt(i);
			char b = t.charAt(i);
			
			if(char_map.containsKey(a)) {
				if(!char_map.get(a).equals(b)) {
					return false;
				} else {
					continue;
				}
			} else {
				if(!char_map.containsValue(b))
					char_map.put(a, b);
				else
					return false;
			}
		}
		
		return true;
	}

}
