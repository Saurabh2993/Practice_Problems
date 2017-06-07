package leetcode_easy;

import java.util.HashMap;
import java.util.Map;

public class Ransom_Note {
	
	public static void main(String args[]) {
		
		String ransomNote = "";
		String magazine = "a";
		
		System.out.println(canConstruct(ransomNote, magazine));
		
	}
	
	public static boolean canConstruct(String ransomNote, String magazine) {
		
		Map<Character, Integer> char_map = new HashMap<>();
		
		for (int i = 0; i < magazine.length(); i++) {
			char curr = magazine.charAt(i);
			if(char_map.containsKey(curr)) {
				char_map.put(curr, char_map.get(curr) + 1);
			} else {
				char_map.put(curr, 1);
			}
		}
		
		for (int i = 0; i < ransomNote.length(); i++) {
			char curr = ransomNote.charAt(i);
			if (!char_map.containsKey(curr)) {
				return false;
			} else {
				if(char_map.get(curr) == 0) {
					return false;
				} else {
					char_map.put(curr, char_map.get(curr) - 1);
				}
			}
		}
		
		return true;
		
	}

}
