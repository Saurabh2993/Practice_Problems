package leetcode_easy;

public class MinMoves {
	
	public static void main(String args[]) {
		
		int nums [] = {1, 2, 3};
		MinMoves m = new MinMoves();
		System.out.println(m.minMoves(nums));
		
	}
	
	public int minMoves(int[] nums) {
		
		int result = 0;
		int min = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] < min)
				min = nums[i];
		}
		
		for (int i : nums) {
			result += i - min;
		}
		
		return result;
	}

}
