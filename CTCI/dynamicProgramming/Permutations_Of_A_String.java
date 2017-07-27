package dynamicProgramming;

import java.util.List;
import java.util.ArrayList;

public class Permutations_Of_A_String {
	
	public static void main(String args[]) {
		String s = "abcde";
		Permutations_Of_A_String p = new Permutations_Of_A_String();
		System.out.println(p.getPerms(s));
	}
	
	public List<String> getPerms(String str) {
		List<String> result = new ArrayList<>();
		getPerms("", str, result);
		
		return result;
	}
	
	private void getPerms(String prefix, String remainder, List<String> result) {
		if(remainder.length() == 0) {
//			System.out.println(prefix);
			result.add(prefix);
		}
		
		int len = remainder.length();
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
//			System.out.println(prefix + remainder.charAt(i) + " " + before + after);
			getPerms(prefix + remainder.charAt(i), before + after, result);
		}
	}

}
