package leetcode_easy;

public class Longest_Uncommon_Subsequence {
	
	public static void main(String args[]) {
		
		String a = "aaa";
		String b = "aaa";
		
		System.out.println(findLUSlength(a, b));
		
	}
	
	public static int findLUSlength(String a, String b) {
		
		int a_len = a.length();
		int b_len = b.length();
		
		if(a_len != b_len) {
			if(a_len > b_len)
				return a_len;
			else
				return b_len;
		} else {
			if(a == b)
				return -1;
			else
				return a_len;
		}
	}

}
