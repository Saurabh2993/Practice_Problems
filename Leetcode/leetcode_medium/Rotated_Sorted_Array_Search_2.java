package leetcode_medium;

public class Rotated_Sorted_Array_Search_2 {
	
	public static void main(String args[]) {
		
		int nums[] = {4, 5, 6, 7, 8, 0, 1, 2, 3};
		int target = 3;
		
		Rotated_Sorted_Array_Search_2 r = new Rotated_Sorted_Array_Search_2();
		System.out.println(r.search(nums, target));
	}
	
	public boolean search(int[] nums, int target) {
        
        if(nums.length == 0) {
            return false;
        }
        
        int pivot = Integer.MIN_VALUE;
        int start = nums[0];
        for(int i = 1; i < nums.length; i ++) {
            if(nums[i] < nums[i - 1]) {
                pivot = i;
                break;
            }
        }
        
        if(pivot == Integer.MIN_VALUE) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        
        if(target == start) {
            return true;
        } else if(target < start) {
            return binarySearch(nums, pivot, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, pivot - 1, target);
        }
        
    }
    
    private boolean binarySearch(int[] nums, int start, int end, int target) {
        if(start > end) {
            return false;
        }
        
        int mid = (start + end) / 2;
        if(nums[mid] == target) {
            return true;
        } else if(nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, end, target);
        }
        
    }

}
