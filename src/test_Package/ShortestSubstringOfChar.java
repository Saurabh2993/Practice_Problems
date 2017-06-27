package test_Package;

import java.util.HashMap;

public class ShortestSubstringOfChar {
	
	public static void main(String args[]) {
		
		String str = "xyyzyzayx";
		char arr[] = {'x', 'y', 'z'};
		
		ShortestSubstringOfChar s = new ShortestSubstringOfChar();
		System.out.println(s.getShortestUniqueSubstring(arr, str));
	}
	
	public String getShortestUniqueSubstring(char arr[], String str) {
		
		int head_index = 0;
		int tail_index = 0;
		int unique_counter = 0;
		String result = "";
		HashMap<Character, Integer> count_map = new HashMap<>();
		
//		put all characters from arr in hashmap
		for (int i = 0; i < arr.length; i++) {
			count_map.put(arr[i], 0);
		}
		
		for (tail_index = 0; tail_index < str.length(); tail_index++) {

			char tailChar = str.charAt(tail_index);
			
			if(!count_map.containsKey(tailChar)) {
				continue;
			}
			
			int tailCount = count_map.get(tailChar);
			if(tailCount == 0) {
				unique_counter += 1;
			}
			
			count_map.put(tailChar, tailCount + 1);
			
			while(unique_counter == arr.length) {
				
				System.out.println(head_index + " " + tail_index);
				
				int curr_length = tail_index - head_index + 1;
				if(curr_length == arr.length) {
					return str.substring(head_index, tail_index + 1);
				}
				
				if(result.equals("") || curr_length < result.length()) {
					result = str.substring(head_index, tail_index + 1);
				}
				
				char headChar = str.charAt(head_index);
				
				if(count_map.containsKey(headChar)) {
					int count = count_map.get(headChar) - 1;
					if(count == 0)
						unique_counter -= 1;
					count_map.put(headChar, count);
				}
				
				head_index++;
			}
		}
		
		return result;
	}

}
