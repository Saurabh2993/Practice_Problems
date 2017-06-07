package leetcode_medium;

import java.util.Arrays;

public class Next_Greater_Element {
	
	public static void main(String args[]) {
		
		int nums[] = {1, 2, 1};
		
		System.out.println(Arrays.toString(nextGreaterElements(nums)));
		
	}
	
	public static int[] nextGreaterElements(int[] nums) {
		
		int[] result = new int[nums.length];
		
		if(nums.length == 1) {
			result[0] = -1;
			return result;
		}
		
		for (int i = 0; i < nums.length; i++) {
			int curr = nums[i];
			int j;
			
			if(i == nums.length - 1)
				j = 0;
			else
				j = i + 1;
				
			while(j != i) {
				if(nums[j] > curr) {
					result[i] = nums[j];
					break;
				}
				
				if(j == nums.length - 1) {
					j = 0;
				} else {
					j++;
				}
			}
			
			if(j == i) {
				result[i] = -1;
			}
		}
		
		return result;
	}

}
