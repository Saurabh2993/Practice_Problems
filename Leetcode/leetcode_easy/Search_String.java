package leetcode_easy;

public class Search_String {
	
	public static void main(String args[]) {
		
		String x1 = "Hi all";
		String x2 = "all";
		
		System.out.println(strStr(x1, x2));
		
	}
	
	public static int strStr(String haystack, String needle) {
		
		int l1 = haystack.length();
		int l2 = needle.length();
		
//		System.out.println(l1 + " " + l2);
		
		if(l2 == 0)
			return 0;
		if(l1 < l2)
			return -1;
		
		for (int i = 0; i <= l1 - l2; i++) {
//			System.out.println(haystack.substring(i, i + l2));
			if(haystack.substring(i, i + l2).equals(needle))
				return i;
		}
		
		return -1;
		
	}

}
