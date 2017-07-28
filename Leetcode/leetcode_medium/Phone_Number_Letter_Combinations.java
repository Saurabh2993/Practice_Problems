package leetcode_medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Phone_Number_Letter_Combinations {
	
	String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static void main(String args[]) {
		
		String digits = "23";
		Phone_Number_Letter_Combinations p = new Phone_Number_Letter_Combinations();
		
//		System.out.println(p.letters);
		System.out.println(p.letterCombinations(digits));
		
	}
	
	
	public List<String> letterCombinations(String digits) {
        String regex = "[2-9]+";
        if(!digits.matches(regex)) {
        	return new ArrayList<>();
        }
        
        List<String> answer = new ArrayList<>();
        letterCombinations("", digits, answer);
        
        return answer;
    }
	
	private void letterCombinations(String prefix, String remaining, List<String> answer) {
		if(remaining.length() == 0) {
			answer.add(prefix);
			return;
		}
		
		int curr = remaining.charAt(0) - '0';
		System.out.println(curr);
		String curr_letters = letters[curr];
		
		for(int i = 0; i < curr_letters.length(); i ++) {
			char c = curr_letters.charAt(i);
			letterCombinations(prefix + c, remaining.substring(1), answer);
		}
		
		
	}
}
