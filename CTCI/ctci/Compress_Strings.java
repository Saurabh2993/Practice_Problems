package ctci;

public class Compress_Strings {
	
	public static void main(String args[]) {
		
		System.out.println(compress("aaabbbbbb"));
		
	}
	
	public static String compress(String s) {
		
		if(s.length() == 1)
			return s;
		
		StringBuilder sb = new StringBuilder();
		int count = 1;
		sb.append(s.charAt(0));
		
		for (int i = 1; i < s.length(); i++) {
			if(sb.length() >= s.length())
				return s;
			
			if(s.charAt(i) == s.charAt(i - 1)) {
				count ++;
			} else {
				sb.append(count);
				count = 1;
				sb.append(s.charAt(i));
			}
		}
		sb.append(count);
		
//		System.out.println("--------------------");
		return sb.length() < s.length() ? sb.toString() : s;
	}
}
