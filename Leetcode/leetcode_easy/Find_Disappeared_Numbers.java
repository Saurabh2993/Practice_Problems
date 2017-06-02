package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Find_Disappeared_Numbers {
	
	public static void main(String args[]) {
		
		int nums[] = {4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers(nums));
		
	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		
		List<Integer> missing_nums = new ArrayList<>();
		Map<Integer, Boolean> nums_present = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			nums_present.put(i + 1, false);
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (!nums_present.get(nums[i])) {
				nums_present.put(nums[i], true);
			}
		}
		
		for (int i = 1; i <= nums.length; i++) {
			if(!nums_present.get(i))
				missing_nums.add(i);
		}
		
		System.out.println(Arrays.asList(missing_nums));
		
		return missing_nums;
		
	}
}