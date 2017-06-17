package leetcode_medium;

import java.util.HashMap;
import java.util.HashSet;

public class Longest_Substring_Unique_Characters {
	
	public static void main(String args[]) {
		
		String s = "pwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	/*public static int lengthOfLongestSubstring(String s) {
		
		if(s.length() == 0 || s.length() == 1)
			return s.length();
		
		HashMap<Character, Integer> char_map = new HashMap<>();
		int max_length = Integer.MIN_VALUE;
		int count = 0;
		int prev_repeating = Integer.MIN_VALUE;
		
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if(char_map.containsKey(curr)) {
				if((prev_repeating < char_map.get(curr))) {
					count = i - char_map.get(curr);
					prev_repeating = char_map.get(curr);
					System.out.println(count);
					char_map.put(curr, i);
				} else {
					char_map.put(curr, i);
					count++;
				}
			} else {
				char_map.put(curr, i);
				count++;
			}
			if(count > max_length) {
				max_length = count;
			}
		}		
		
		return max_length;
		
	}*/
	
	public static int lengthOfLongestSubstring(String s) {
		
		int max = 0;
		HashSet<Character> char_set = new HashSet<>(); 
		
		int i = 0;
		int j = 0;
		
		while(j < s.length()) {
			if(char_set.contains(s.charAt(j))) {
				char_set.remove(s.charAt(i++));
			} else {
				char_set.add(s.charAt(j));
				j++;
				
				max = Math.max(max, j - i + 1);
			}
		}
		
		return max;
	}

}
