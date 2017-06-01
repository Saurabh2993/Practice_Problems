package leetcode_easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class First_Unique_Char {
	
	public static void main(String args[]) {
		
		String s = "loveleetcode";
		System.out.println(firstUniqChar(s));
		
	}
	
	public static int firstUniqChar(String s) {
		
		Map<Character, Integer> characters_map = new LinkedHashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if(characters_map.containsKey(curr)) {
				characters_map.put(curr, characters_map.get(curr) + 1);
			} else {
				characters_map.put(curr, 1);
			}
		}
		
		for (Map.Entry<Character, Integer> entry : characters_map.entrySet()) {
//			System.out.println(entry.getKey() + " " + entry.getValue());
			 if(entry.getValue() == 1)
				 return s.indexOf(entry.getKey());
			 else
				 continue;
		}
		
		return -1;
		
	}

}
