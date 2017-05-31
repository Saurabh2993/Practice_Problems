package leetcode_easy;

public class Move_Zeroes {
	
	static int nums[] = {0, 0, 1};
	
	public static void main(String args[]) {
		
		moveZeroes(nums);
		
	}
	
	public static void moveZeroes(int[] nums) {
		
		int pos = 0;
		
		for(int i : nums) {
			if(i != 0) {
				nums[pos++] = i;
			}
		}
		while(pos < nums.length)
			nums[pos++] = 0;
		
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
