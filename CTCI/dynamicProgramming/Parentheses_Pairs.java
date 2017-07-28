package dynamicProgramming;

import java.util.List;
import java.util.ArrayList;

public class Parentheses_Pairs {
	
	public static void main(String args[]) {
		
		int n = 3;
		Parentheses_Pairs p = new Parentheses_Pairs();
		System.out.println(p.getParens(n));
		
	}
	
	public List<String> getParens(int n) {
		char[] str = new char[n * 2];
		List<String> answer = new ArrayList<>();
		AddParen(answer, n, n, str, 0);
		return answer;
	}
	
	private void AddParen(List<String> answer, int leftCount, int rightCount, char[] str, int index) {
		if(leftCount < 0 || rightCount < 0) {
			return;
		}
		
		if(leftCount == 0 && rightCount == 0) {
			answer.add(String.copyValueOf(str));
		} else {
			
			if(leftCount > 0) {
				str[index] = '(';
				AddParen(answer, leftCount - 1, rightCount, str, index + 1);
			}
			
			if(rightCount  > leftCount) {
				str[index] = ')';
				AddParen(answer, leftCount, rightCount - 1, str, index + 1);
			}
		}
	}
}
