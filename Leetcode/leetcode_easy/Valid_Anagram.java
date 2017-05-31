package leetcode_easy;

import java.util.HashMap;
import java.util.Map;

public class Valid_Anagram {
	
	public static void main(String args[]) {
		
		String s = "a";
		String t = "b";
		
		System.out.println(isAnagram(s, t));
		
	}
	
	public static boolean isAnagram(String s, String t) {
		
		if(s.length() != t.length())
			return false;
		
		Map<Character, Integer> characters_map = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			
			char temp = s.charAt(i);
			
			if(characters_map.containsKey(temp)) {
				characters_map.put(temp, characters_map.get(temp) + 1);
			} else {
				characters_map.put(temp, 1);
			}
			
		}
		
		for (int i = 0; i < t.length(); i++) {
			
			char temp = t.charAt(i);
			
			if(!characters_map.containsKey(temp)) {
				return false;
			} else if(characters_map.get(temp) == 0) {
				return false;
			} else {
				characters_map.put(temp, characters_map.get(temp) - 1);
			}
		}
		
		int count = 0;
		for (Map.Entry<Character, Integer> entry : characters_map.entrySet()) {
			 count += entry.getValue();
		}
		System.out.println(count);
		if(count > 0)
			return false;
		else
			return true;
		
	}

}
