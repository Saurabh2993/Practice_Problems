package leetcode_medium;

import java.util.Stack;

public class Decode_String {
	
	public static void main(String args[]) {
		
		String input = "100[abc]";
		
		Decode_String d = new Decode_String();
		d.decodeString(input);
	}

	
	
	public String decodeString(String s) {
		
		Stack<String> str_st = new Stack<>();
		StringBuilder ans = new StringBuilder();
		
		for(int i = 0; i < s.length(); i ++) {
			
			String temp = s.substring(i, i + 1);
			
			if(temp.equals("]")) {
				StringBuilder sb = new StringBuilder();
				while(!str_st.peek().equals("[")) {
					sb.insert(0, str_st.pop());
				}
				str_st.pop();
				int count = Integer.parseInt(str_st.pop());
				int multiplier = 10;
				while(str_st.size() != 0) {
					if(str_st.peek().matches("[0-9]")) {
						count = count + Integer.parseInt(str_st.pop()) * multiplier;
						multiplier *= 10;
					} else {
						break;
					}
				}
				
				System.out.println(count);
				String curr = sb.toString();
				
				for(int j = 1; j < count; j ++) {
					sb.append(curr);
				}
				
				if(str_st.size() == 0) {
					ans.append(sb.toString());
				} else {
					str_st.push(sb.toString());
				}
			} else {
				str_st.push(temp);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(str_st.size() != 0) {
			sb.insert(0, str_st.pop());
		}
		ans.append(sb.toString());
		System.out.println(ans.toString());
		
		return ans.toString();
	}
}
