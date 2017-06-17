package leetcode_easy;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum {
	
	public static void main(String args[]) {
		
		int nums[] = {2, 7, 11, 15};
		int target = 9;
		
		int ans[] = twoSum(nums, target);
		
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		
	}
	
	public static int[] twoSum(int[] nums, int target) {
		
		HashMap<Integer, Integer> nums_map = new HashMap<>();
		int[] ans = new int[2];
		
		for (int i = 0; i < nums.length; i++) {
			if(nums_map.containsKey(target - nums[i])) {
				ans[0] = nums_map.get(target - nums[i]);
				ans[1] = i;
				return ans;
			}
			nums_map.put(nums[i], i);
		}
		
		return ans;
	}

}
