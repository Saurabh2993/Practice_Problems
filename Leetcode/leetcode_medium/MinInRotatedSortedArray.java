package leetcode_medium;

public class MinInRotatedSortedArray {

	public static void main(String args[]) {
		
		int nums[] = {4, 5, 6, 7, 0, 1, 2};
		
		MinInRotatedSortedArray x = new MinInRotatedSortedArray(); 
		
		System.out.println(x.findMin(nums));
		
	}
	
	
    public int findMin(int[] nums) {
	        
        for(int i = 0; i < nums.length - 1; i ++) {
            if(nums[i + 1] < nums[i])
                return nums[i + 1];
        }
        
        return nums[0];
    }
	
}
