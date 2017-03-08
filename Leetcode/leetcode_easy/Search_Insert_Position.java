package leetcode_easy;

public class Search_Insert_Position {
	
	public static void main(String args[]) {
		
		int nums[] = {1, 3, 5, 6};
		int target = 2;
		
		int ans = searchInsert(nums, target);
		
		System.out.println(ans);
		
	}
	
	
	public static int searchInsert(int[] nums, int target) {
		
		if (target > nums[nums.length  - 1]) {
			return nums.length;
		}
		else if (target < nums[0]) {
			return 0;
		}
		else {
			boolean found = false;
			int low = 0;
			int high = nums.length;
			int mid;
			int ans = 0;
			
			while (low <= high) {
			
				mid = low + (high - low) / 2;
//				System.out.print(mid);
				if(target == nums[mid]) {
					ans = mid;
					break;
				}
				else if (target < nums[mid]) {
					high = mid - 1;
					ans = mid;
				}
				else {
					low = mid + 1;
					ans = mid + 1;
				}
			}
			
			return ans;
		}
	        
    }

}
