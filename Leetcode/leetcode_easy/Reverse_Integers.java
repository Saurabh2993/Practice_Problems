package leetcode_easy;

public class Reverse_Integers {
	
	public static void main(String args[]) {
		
		int x = -2147483648;
		int answer = reverse(x);
		System.out.println(answer);
	}
	
	public static int reverse(int x) {
		
		long answer = 0;
		long positive_num = x;
		boolean negative = false;
		StringBuilder sb = new StringBuilder();
		
		if(x < 0) {
			negative = true;
			positive_num = -positive_num;
		}
		String num = Long.toString(positive_num);
		
		for (int i = num.length() - 1; i >= 0; i--) {
			sb.append(num.charAt(i));
		}
		
		answer = Long.parseLong(sb.toString());
		if(negative)
			answer = -answer;
		
		if(answer < Integer.MIN_VALUE || answer > Integer.MAX_VALUE)
			return 0;
		else
			return (int) answer;
		
	}

}
