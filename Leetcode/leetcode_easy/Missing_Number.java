package leetcode_easy;

public class Missing_Number {
	
	public static void main(String args[]) {
		
		int nums[] = {0, 1, 3};
		Missing_Number m = new Missing_Number();
		System.out.println(m.missingNumber(nums));
		
	}
	
	
	public int missingNumber(int[] nums) {
        
        int n = nums.length;
		int temp = 0;
		
		for(int i = 0; i < n; i ++) {
			temp ^= i;
			temp ^= nums[i];
		}
		
		return temp ^ n;
        
    }

}
