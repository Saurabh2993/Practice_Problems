package leetcode_easy;

import java.util.HashMap;
import java.util.Map;

public class Majority_Element {
	
	public static void main(String args[]) {
		
		int[] nums = {1, 1, 1, 1, 2, 2, 2};
		
		System.out.println(majorityElement(nums));
		
	}
	
	public static int majorityElement(int[] nums) {
		
		Map<Integer, Integer> elements = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if(elements.containsKey(nums[i])) {
				elements.put(nums[i], elements.get(nums[i]) + 1);
			} else {
				elements.put(nums[i], 1);
			}
		}
		
		int ans = 0;
		for (Map.Entry<Integer, Integer> entry : elements.entrySet()) {
			 if(entry.getValue() > nums.length / 2){
				 ans = entry.getKey();
				 break;
			 }
		}
		
		return ans;
		
	}

}
