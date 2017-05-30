package leetcode_easy;

import java.util.HashSet;
import java.util.Set;

public class Remove_Duplicates {
	
	public static void main (String args[]) {
		
		int[] nums = {1, 1, 2};
		int ans = removeDuplicates(nums);
		
		System.out.println(ans);
		
	}
	
	
	public static int removeDuplicates(int[] nums) {
		
		if (nums.length == 0) 
			return 0;
        
		int j = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != nums[j])
            	nums[++j] = nums[i];
        
        
//      for (int i = 0; i < j; i++) {
//			System.out.print(nums[i] + " ");
//		}
        
        return ++j;
		
	}

}
