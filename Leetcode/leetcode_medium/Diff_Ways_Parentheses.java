package leetcode_medium;

import java.util.List;
import java.util.ArrayList;

public class Diff_Ways_Parentheses {
	
	public List<Integer> diffWaysToCompute(String input) {
        
    	List<Integer> result = new ArrayList<>();
    	
    	for (int i = 0; i < input.length(); i++) {
			
    		char curr = input.charAt(i);
    		if(curr == '+' || curr == '-' || curr == '*') {
    			List<Integer> left = diffWaysToCompute(input.substring(0, i));
    			List<Integer> right = diffWaysToCompute(input.substring(i + 1));
    			
    			for(int x : left) {
    				for(int y : right) {
    					switch(curr) {
    						case '+':
    							result.add(x + y);
    							break;
    						case '-':
    							result.add(x - y);
    							break;
    						case '*':
    							result.add(x * y);
    							break;
    					}
    				}
    			}
    		}
		}
    	
    	if(result.size() == 0) {
    		result.add(Integer.parseInt(input));
    	}
    	return result;
    }
}
