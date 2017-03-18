package leetcode_easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K_Diff_Pairs {
	
	public static void main (String args[]) {
		
		int nums[] = {1, 3, 1, 5, 4};
		int k = 0;
		int ans = findPairs(nums, k);
		
		System.out.println(ans);
		
	}
	
	public static int findPairs(int[] nums, int k) {
        
		int pairs = 0;
		
		List<Integer> nums_list = new ArrayList<Integer>();
		
		if(k < 0)
		    return pairs;
		
		if(k == 0) {
			for (int i = 0; i < nums.length; i++) {
				nums_list.add(nums[i]);
			}
			
			List<Integer> zero_pairs_list = new ArrayList<Integer>();
			
			for (int i = 0; i < nums_list.size(); i++) {
				
				int current = nums_list.get(i);
				if (Collections.frequency(nums_list, current) > 1) {
					if (zero_pairs_list.contains(current))
						continue;
					else {
						pairs++;
						zero_pairs_list.add(current);
					}
				}
			}
	
			return pairs;
	
		} else {
		
			for (int i = 0; i < nums.length; i++) {
				if (!nums_list.contains(nums[i])) {
					nums_list.add(nums[i]);
				}
			}
			
			for (int i = 0; i < nums_list.size(); i++) {
				
				int current = nums_list.get(i);
				if (nums_list.contains(current + k)) {
					pairs++;
				}
			}
	
			return pairs;
		}
    }

}
