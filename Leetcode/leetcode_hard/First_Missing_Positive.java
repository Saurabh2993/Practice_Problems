package leetcode_hard;

import java.util.HashSet;

public class First_Missing_Positive {
	
	public static void main(String args[]) {
		
		First_Missing_Positive f = new First_Missing_Positive();
		int[] nums = {3, 4, -1, 1};
		System.out.println(f.firstMissingPositive(nums));
		
	}
	
	
	public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) {
            return 1;
        }
        if(nums.length == 1 && nums[0] < 1) {
            return 1;
        }
        
        int max = Integer.MIN_VALUE;
        
        HashSet<Integer> nums_set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                nums_set.add(nums[i]);
                if(max < nums[i]) {
                    max = nums[i];
                }
            }
		}
        
        for(int i = 1; i <= max; i ++) {
            if(!nums_set.contains(i)) {
                return i;
            }
        }
        
        return max + 1;
    }

}
