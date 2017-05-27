package leetcode_easy;

import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz {
	
	public static void main(String args[]) {
		
		int n = 15;
		List<String> answer = fizzBuzz(n);
		
		for(String s : answer) {
			System.out.println(s);
		}
	}
	
	public static List<String> fizzBuzz(int n) {
		
		List<String> result = new ArrayList<>();
		
		for (int i = 1; i < n + 1; i++) {
			
			if(i % 15 == 0) {
				result.add("FizzBuzz");
			} else if(i % 5 == 0) {
				result.add("Buzz");
			} else if(i % 3 == 0) {
				result.add("Fizz");
			} else {
				result.add(Integer.toString(i));
			}
		}
		
		return result;
	}
}
