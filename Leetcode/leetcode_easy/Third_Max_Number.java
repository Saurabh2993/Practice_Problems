package leetcode_easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Third_Max_Number {
	
	public static void main(String args[]) {
		
		int nums[] = {1,-2147483648,2};
		int result = thirdMax(nums);
		
		System.out.println(result);
		
	}
	
	public static int thirdMax(int[] nums) {
		
		List<Integer> nums_list = new ArrayList<Integer>();
		
		for (int num : nums) {
			if(nums_list.contains(num)) {
				continue;
			}
			else {
				nums_list.add(num);
			}
		}
		
		Collections.sort(nums_list);
		
		if (nums_list.size() < 3) {
			return nums_list.get(nums_list.size() - 1);
		} else {
			return nums_list.get(nums_list.size() - 3);
		}
	}
}
