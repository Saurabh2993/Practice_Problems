package leetcode_easy;

public class Maximum_Subarray {
	
	public static void main(String args[]) {
		
		int nums[] = {1, -1, 3, 4, -2, 5, 1, -4, 7};
		
		System.out.println(maxSubArray(nums));
		
	}
	
	public static int maxSubArray(int[] nums) {
		
		int max = nums[0];
		int sums[] = new int[nums.length];
		
		sums[0] = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			
			int temp = nums[i];
			if(sums[i - 1] > 0) {
				temp += sums[i - 1];
			}
			
			if(max < temp) {
				max = temp;
			}
			
			sums[i] = temp;
		}
		
		return max;
	}

}
