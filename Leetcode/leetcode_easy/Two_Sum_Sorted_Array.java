package leetcode_easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum_Sorted_Array {
	
	public static void main(String args[]) {
		
		int [] numbers = {2, 11, 7, 15};
		int target = 9;
		
		int ans[] = twoSum(numbers, target);
		
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i] + " ");
		}
		
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		
		int ans[] = new int[2];
		
		Map<Integer, Integer> nums_map = new HashMap<>();
		
		for (int i = 0; i < numbers.length; i++) {
			nums_map.put(numbers[i], i);
		}
		
		for (int i = 0; i < numbers.length; i++) {
			if(nums_map.containsKey(target - numbers[i])) {
				ans[0] = i + 1;
				ans[1] = nums_map.get(target - numbers[i]) + 1;
				break;
			}
		}
		
		return ans;
		
	}

}
