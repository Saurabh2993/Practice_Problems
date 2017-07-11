package leetcode_easy;

import java.util.HashMap;

public class Contains_Nearby_Duplicates {
	
	public static void main(String args[]) {
		
		int nums[] = {2, 3, 4, 5, 1, 6, 0, 10, 6};
		int k = 4;
		
		Contains_Nearby_Duplicates x = new Contains_Nearby_Duplicates();
		System.out.println(x.containsNearbyDuplicate(nums, k));
		
	}
	
//	Brute force solution
	/*public boolean containsNearbyDuplicate(int[] nums, int k) {
		
		for (int i = 0; i < nums.length; i++) {
			int curr = nums[i];
			for (int j = i + 1; j <= i + k && j < nums.length; j++) {
				if(nums[j] == curr) {
					return true;
				}
			}
		}
		
		return false;
	}*/
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		
		HashMap<Integer, Integer> nums_map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(nums_map.containsKey(nums[i])) {
				if(i - nums_map.get(nums[i]) <= k) {
					return true;
				}
			}
			nums_map.put(nums[i], i);
		}
		
		return false;
	}
}
