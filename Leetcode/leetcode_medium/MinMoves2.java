package leetcode_medium;

import java.util.Arrays;
import java.util.HashMap;

public class MinMoves2 {
	
	public static void main(String args[]) {
		
		int nums[] = {1, 2, 2, 2, 4};
		MinMoves2 m = new MinMoves2();
		
		System.out.println(m.minMoves2(nums));
		
	}
	
	/*public int minMoves2(int[] nums) {
		
		HashMap<Integer, Integer> nums_map = new HashMap<>();
		
		for (int i : nums) {
			if(nums_map.containsKey(i)) {
				nums_map.put(i, nums_map.get(i) + 1);
			} else {
				nums_map.put(i, 1);
			}
		}
		int median = findMedian(nums);
		System.out.println(median);
		
		int result = 0;
		for(Integer key : nums_map.keySet()) {
			result += Math.abs(median - key) * nums_map.get(key);
		}
		
		return result;
	}*/
	
	public int minMoves2(int[] nums) {
		
		int median = findMedian(nums);
		int result = 0;
		
		for(int i : nums) {
			result += Math.abs(median - i);
		}
		
		return result;
	}
	
	public int findMode(HashMap <Integer, Integer> nums_map) {
		
		int mode = 0;
		int max = Integer.MIN_VALUE;
		
		for(Integer key : nums_map.keySet()) {
			if(nums_map.get(key) > max) {
				mode = key;
				max = nums_map.get(key);
			}
		}
		
		return mode;
	}
	
	public int findMedian(int[] nums) {
		
		Arrays.sort(nums);
		return nums[nums.length/ 2];
		
	}

}
