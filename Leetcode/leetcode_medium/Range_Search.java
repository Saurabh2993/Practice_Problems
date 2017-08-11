package leetcode_medium;

public class Range_Search {
	
	public static void main(String args[]) {
		
		int nums[] = {5, 7, 7, 8, 8, 10};
		Range_Search r = new Range_Search();
		
		int range[] = r.searchRange(nums, 8);
		for(int i : range) {
			System.out.print(i + "  ");
		}
	}

	public int[] searchRange(int[] nums, int target) {
		
		int index = binarySearch(nums, target, 0, nums.length  - 1);
		int result[] = new int[2];
		
		if(index == -1) {
			result[0] = -1;
			result[1] = -1;
			return result;
		}
		
		int start_index = index;
		while(start_index > 0) {
			if(nums[start_index - 1] == target) {
				start_index--;
			} else {
				break;
			}
		}
		
		int end_index = index;
		while(end_index < nums.length - 1) {
			if(nums[end_index + 1] == target) {
				end_index++;
			} else {
				break;
			}
		}
		
		result[0] = start_index;
		result[1] = end_index;
		
		return result;
	}
	
	private int binarySearch(int[] nums, int target, int start, int end) {
		
		if(start > end) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		if(nums[mid] == target) {
			return mid;
		} else if(target < nums[mid]) {
			return binarySearch(nums, target, start, mid - 1);
		} else {
			return binarySearch(nums, target, mid + 1, end);
		}
	}
	
}
