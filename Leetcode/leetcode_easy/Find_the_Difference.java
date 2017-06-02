package leetcode_easy;

import java.util.HashMap;
import java.util.Map;

public class Find_the_Difference {
	
	public static void main(String args[]) {
		
		String s = "abcd";
		String t = "abcde";
		
		System.out.println(findTheDifference(s, t));
		
	}
	
	public static char findTheDifference(String s, String t) {
		
		int string_s_sum = 0;
		int string_t_sum = 0;
		int i;
		for (i = 0; i < s.length(); i++) {
			string_s_sum += s.charAt(i);
			string_t_sum += t.charAt(i);
		}
		string_t_sum += t.charAt(i);
		
		return (char) (string_t_sum - string_s_sum);
		
	}

}
