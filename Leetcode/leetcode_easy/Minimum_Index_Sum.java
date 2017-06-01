package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimum_Index_Sum {
	
	public static void main(String args[]) {
		
		String[] s = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] t = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		
		String ans[] = findRestaurant(s, t);
		
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		
		
	}
	
	public static String[] findRestaurant(String[] list1, String[] list2) {
		
		Map<String, Integer> list1_map = new HashMap<>();
		Map<String, Integer> list2_map = new HashMap<>();
		List<String> result = null;
		
		for (int i = 0; i < list1.length; i++) {
			list1_map.put(list1[i], i);
		}
		
		for (int i = 0; i < list2.length; i++) {
			list2_map.put(list2[i], i);
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list1.length; i++) {
			int sum = 0;
			if(list2_map.containsKey(list1[i])) {
				sum = list1_map.get(list1[i]) + list2_map.get(list1[i]);
				if(sum < min) {
					min = sum;
					result = new ArrayList<String>();
					result.add(list1[i]);
				} else if(sum == min) {
					result.add(list1[i]);
				}
			}
		}
		
		String ans[] = new String[result.size()];
		for (int i = 0; i < result.size(); i++) {
			ans[i] = result.get(i);
		}
		
		return ans;
		
		
		
	}

}
