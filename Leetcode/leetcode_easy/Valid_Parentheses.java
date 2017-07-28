package leetcode_easy;

import java.util.Stack;

public class Valid_Parentheses {
	
	public static void main(String args[]) {
		
		String s = "()[]{}";
		Valid_Parentheses v = new Valid_Parentheses();
		System.out.println(v.isValid(s));
		
	}
	
	
	public boolean isValid(String s) {
		if(s.length() % 2 == 1) {
			return false;
		}
		
		Stack<Character> brackets = new Stack<>();
		for(int i = 0; i < s.length(); i ++) {
			
			char curr = s.charAt(i);
			if(curr == ')' || curr == ']' || curr == '}') {
				if(brackets.size() == 0) {
					return false;
				}
				char temp = brackets.pop();
				if(curr - temp == 2 || curr - temp == 1) {
					continue;
				} else {
					return false;
				}
			} else {
				brackets.push(curr);
			}
			
		}
		
		if(brackets.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

}
