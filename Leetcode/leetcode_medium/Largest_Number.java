package leetcode_medium;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Largest_Number {
	
	public static void main(String args[]) {
		
		int nums[] = {3, 30, 34, 5, 9};
		Largest_Number l = new Largest_Number();
		System.out.println(l.largestNumber(nums));
		
	}
	
	
	public String largestNumber(int[] nums) {
        
		Comparator<String> comp = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				
				return s2.compareTo(s1);
			}
		};
		
        String str_nums [] = new String[nums.length];
        boolean all_zeros = true;
		for(int i = 0; i < nums.length; i ++) {
            if(nums[i] != 0) {
                all_zeros = false;
            }
            str_nums[i] = String.valueOf(nums[i]);
        }
        if(all_zeros) {
            return "0";
        }
		
        Arrays.sort(str_nums, comp);
        StringBuilder sb = new StringBuilder();
        
        for(String s : str_nums) {
            sb.append(s);
            
        }
		
		return sb.toString();
    }

}
