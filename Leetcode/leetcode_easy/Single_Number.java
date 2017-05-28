package leetcode_easy;

import java.util.Arrays;

public class Single_Number {
	
	public static void main(String args[]) {
		
		int nums[] = {1, 1, 2, 2, 3, 4, 4};
		int ans = singleNumber(nums);
		System.out.println(ans);
		
	}
	
	public static int singleNumber(int[] nums) {
		
		
//		O(n log(n)) solution
/*		if(nums.length == 1)
			return nums[0];
		
		Arrays.sort(nums);
		int i;
		for (i = 0; i < nums.length - 1; i++) {
			
			if(nums[i] == nums[i + 1]) {
				i++;
			} else {
				break;
			}
		}
		
		return nums[i]; */
		
		
//		O(n) solution
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			ans = ans ^ nums[i];
		}
		
		return ans;
	}

}
