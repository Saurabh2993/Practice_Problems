package test_Package;

import java.util.Arrays;

public class Max_Sum_Subarray {
	
	public static void main(String args[]) {
		
		int nums[] = {1, 2, 1, 2, 1};
		Max_Sum_Subarray m = new Max_Sum_Subarray();
		Arrays.asList(m.getMaxSumSubarray(nums, 3));
		
	}
	
	public int[] getMaxSumSubarray(int nums[], int k) {
		
		int sum = 0;
		int i = 0;
		for(i = 0; i < k; i ++) {
			sum = sum + nums[i];
		}
		System.out.println(sum);
		int max_sum = sum;
		int start = 0;
		
		for(i = 1; i < nums.length - k; i ++) {
			sum = sum - nums[i - 1] + nums[i + k - 1];
			System.out.println(sum);
			if(sum > max_sum) {
				start = i;
				max_sum = sum;
			}
		}
		
		int ans[] = new int[k];
		for(i = 0; i < k; i ++) {
			ans[i] = nums[i + start];  
		}
		
		return ans;
	}

}
