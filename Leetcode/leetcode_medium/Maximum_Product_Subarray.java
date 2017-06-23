package leetcode_medium;

public class Maximum_Product_Subarray {
	
	public static void main(String args[]) {
		
		int nums[] = {2,-5,-2,-4,3};
		System.out.println(maxProduct(nums));
		
	}
	
	public static int maxProduct(int[] nums) {
		
		int max = nums[0];
		int min = nums[0];
		int result = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			
			int temp = max;
			
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
			
			if(result < max) {
				result = max;
			}
		}
		
		return result;
	}

}
