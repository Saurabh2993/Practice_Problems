package leetcode_easy;

import java.util.Arrays;

public class Array_Partition_1 {
	
	public static void main(String args[]) {
		
		int arr[] = {1, 2, 4, 3};
		
		int ans = arrayPairSum(arr);
		
		System.out.println(ans);
		
	}
	
	public static int arrayPairSum(int[] nums) {
		
		int sum = 0;
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i += 2) {
			
			sum = sum + nums[i];
			
		}
		
		return sum;
		
	}

}
