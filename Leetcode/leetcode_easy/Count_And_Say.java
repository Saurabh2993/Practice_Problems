package leetcode_easy;

public class Count_And_Say {
	
	public static void main(String args[]) {
		
		int n = 1;
		countAndSay(6);
		
	}
	
	public static String countAndSay(int n) {
		
		if(n == 1) {
			return "1";
		}
		
		String ans = "11";
		int count = 2;
		int i;
		
		while(count < n) {
			String temp = ans;
			StringBuilder sb = new StringBuilder();
			
			int occurences = 1;
			
			for (i = 1; i < temp.length(); i++) {
				if(temp.charAt(i) == temp.charAt(i - 1)) {
					occurences ++;
				} else {
					sb.append(occurences);
					sb.append(temp.charAt(i - 1));
					occurences = 1;
				}
			}
			sb.append(occurences);
			sb.append(temp.charAt(i - 1));
			
			ans = sb.toString();
//			System.out.println(ans);
			count++;
			
		}
		
		return ans;
	}

}
