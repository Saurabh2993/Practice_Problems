package dynamicProgramming;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Permutation_Of_A_String_2 {
	
	public static void main(String args[]) {
		
		String s = "abcdd";
		Permutation_Of_A_String_2 p = new Permutation_Of_A_String_2();
		System.out.println(p.getPerms(s));
		
	}
	
	
	public List<String> getPerms(String str) {
		
		HashMap<Character, Integer> char_map = buildFreqTable(str);
		List<String> result = new ArrayList<>();
//		System.out.println(char_map);
		getPerms("", str.length(), char_map, result);
		
		return result;
	}
	
	private void getPerms(String prefix, int rem_len, HashMap<Character, Integer> char_map, List<String> result) {
		if(rem_len == 0) {
			result.add(prefix);
			return;
		}
		
		for(char c : char_map.keySet()) {
			int count = char_map.get(c);
			if(count > 0) {
				char_map.put(c, count - 1);
				getPerms(prefix + c, rem_len - 1, char_map, result);
				char_map.put(c, count);
			}
		}
	}

	private HashMap<Character, Integer> buildFreqTable(String s) {
		
		HashMap<Character, Integer> char_map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!char_map.containsKey(c)) {
				char_map.put(c, 0);
			}
			char_map.put(c, char_map.get(c) + 1);
		}
		
		return char_map;
	}

}
