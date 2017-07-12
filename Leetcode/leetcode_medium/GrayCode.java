package leetcode_medium;

import java.util.List;
import java.util.ArrayList;

public class GrayCode {
	
	public static void main(String args[]) {
		
		int n = 4;
		GrayCode g = new GrayCode();
		g.grayCode(n);
		
	}
	
	public List<Integer> grayCode(int n) {
        
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < (1 << n); i ++) {
            result.add(i ^ (i >> 1));
            System.out.println(i ^ (i >> 1));
        }
        
        return result;
    }
}