package leetcode_easy;

import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicates {
	
	public static void main(String args[]) {
		
		int[] nums = {1, 2, 3, 5, 5};
		
		System.out.println(containsDuplicate(nums));
		
	}
	
	public static boolean containsDuplicate(int[] nums) {
		
		if (nums.length == 0) {
			return false;
		}
		
		Set<Integer> nums_set = new HashSet<>();
		
		for (int i = 0; i < nums.length; i++) {
			if(!nums_set.add(nums[i])) {
				return true;
			}
		}
		
		return false;
		
	}

}
