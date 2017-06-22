package leetcode_easy;

public class Range_Sum {
	
	int[] nums;
	
	public static void main(String args[]) {
	
		int[] nums = {-2, 0, 3, -5, 2, -1};		//-2, -2, 1, -4, -2, -3
		Range_Sum rs = new Range_Sum(nums);
		
		int x = rs.sumRange(2, 5);
		System.out.println(x);
	}

		public Range_Sum(int[] nums) {
			
			for (int i = 1; i < nums.length; i++) {
				nums[i] += nums[i - 1];
			}
	
			this.nums = nums;
		}
		
		public int sumRange(int i, int j) {
			
			if(i == 0)
				return nums[j];
			
			else
				return nums[j] - nums[i - 1];
			
		}

}
