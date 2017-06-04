package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection_of_2_Arrays {
	
	public static void main (String args[]) {
		
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		
		int ans[] = intersection(nums1, nums2);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]);
		}
		
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
		
		List<Integer> result_list = new ArrayList<>();
		
		Map<Integer, Integer> numbers_map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			numbers_map.put(nums1[i], 1);
		}
		
		for (int i = 0; i < nums2.length; i++) {
			if(numbers_map.containsKey(nums2[i]) && !result_list.contains(nums2[i])) {
				result_list.add(nums2[i]);
			}
		}
		
		int ans[] = new int[result_list.size()];
		int i = 0;
		for(int element : result_list) {
			ans[i++] = element;
		}
		
		return ans;
	}

}