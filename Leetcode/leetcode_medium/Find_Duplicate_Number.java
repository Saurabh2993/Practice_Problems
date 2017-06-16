package leetcode_medium;

public class Find_Duplicate_Number {
	
	public static void main(String args[]) {
		
		int[] nums = {1, 3, 4, 2, 6, 6, 5};
		System.out.println(findDuplicate(nums));
		
	}
	
	public static int findDuplicate(int[] nums) {
	    
		if(nums.length > 1) {
			
			int slow = nums[0];
			int fast = nums[nums[0]];
			
			while (slow != fast) {
				slow = nums[slow];
				fast = nums[nums[fast]];
			}
			fast = 0;
			while (slow != fast) {
				fast = nums[fast];
				slow = nums[slow];
			}
			return slow;
			
		}
		return -1;
		
	}

}
