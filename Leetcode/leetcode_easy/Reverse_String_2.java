package leetcode_easy;

public class Reverse_String_2 {
	
	public static void main(String args[]) {
		
		String s = "abcdefg";
		Reverse_String_2 rs = new Reverse_String_2();
		
		System.out.println(rs.reverseStr(s, 1));
		
	}
	
	public String reverseStr(String s, int k) {
		
		if(s.length() <= k) {
			return reverse(s);
		}
		
		int i = 0;
		StringBuilder sb = new StringBuilder();
		
		while((i + k) < s.length()) {
			
			System.out.println(s.substring(i, i + k));
			String rev = reverse(s.substring(i, i + k));
			System.out.println(rev);
			sb.append(rev);
			
			i = i + k;
			
			int limit = (i + k) < s.length() ? (i + k) : s.length();
			
			sb.append(s.substring(i, limit));
			
			i = i + k;
		}
		
		if(i < s.length()) {
			sb.append(s.substring(i, s.length()));
		}
		
		
		return sb.toString();
	}
	
	public String reverse(String x) {
		
		int i = 0;
		int j = x.length() - 1;
		
		char c[] = x.toCharArray();
		
		while(i < j) {
			
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
			
			i++;
			j--;
		}
		
		return new String(c);
	}
	
	

}
