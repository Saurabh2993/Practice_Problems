package leetcode_easy;

import java.util.HashMap;

public class Word_Pattern {
	
	public static void main(String args[]) {
		
		String pattern = "aaaa";
		String str = "dog cat cat dog";
		
		System.out.println(wordPattern(pattern, str));
		
	}
	
	public static boolean wordPattern(String pattern, String str) {
		
		String[] str_split = str.split(" ");
		
		if(str_split.length != pattern.length())
			return false;
		
		HashMap<Character, String> pattern_word_map = new HashMap<>();
		
		for (int i = 0; i < str_split.length; i++) {
			char curr = pattern.charAt(i);
			
			if(pattern_word_map.containsKey(curr)) {
				if(!pattern_word_map.get(curr).equals(str_split[i]))
					return false;
			} else {
				if(!pattern_word_map.containsValue(str_split[i]))
					pattern_word_map.put(curr, str_split[i]);
				else
					return false;
			}
			
		}
		
		
		return true;
	}

}
