package leetcode_medium;

public class Rotated_Sorted_Array_Search {
	
	public static void main(String args[]) {
		
		int nums[] = {4, 5, 6, 7, 8, 0, 1, 2, 3};
		int target = 3;
		
		Rotated_Sorted_Array_Search r = new Rotated_Sorted_Array_Search();
		System.out.println(r.search(nums, target));
	}
	
	public int search(int[] nums, int target) {
        
        if(nums.length == 0) {
            return -1;
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
            return 0;
        } else if(target < start) {
            return binarySearch(nums, pivot, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, pivot - 1, target);
        }
        
    }
    
    private int binarySearch(int[] nums, int start, int end, int target) {
        if(start > end) {
            return -1;
        }
        
        int mid = (start + end) / 2;
        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, end, target);
        }
        
    }

}
