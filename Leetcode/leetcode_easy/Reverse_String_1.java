package leetcode_easy;

public class Reverse_String_1 {
	
	public static void main(String args[]) {
		
		String s = "hello";
		String r = reverse(s);
		
		System.out.println(r);
		
	}
	
	
	public static String reverse(String s) {

//		char ch[] = new char[s.length()];
//		
//		String res = "";
//		for (int i = ch.length - 1; i >= 0; i--) {
//			
//			res += s.charAt(i);
//			
//		}
//		
//		return res;
		
		char ch[] = s.toCharArray();
		
		int i = 0;
		int j = s.length() - 1;
		
		while(i < j) {
			
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			i ++;
			j --;
			
		}
		return new String(ch);
	
	}
}
