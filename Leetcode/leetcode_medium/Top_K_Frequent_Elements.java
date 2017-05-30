package leetcode_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Top_K_Frequent_Elements {
	
	public static void main(String args[]) {
		
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k = 2;
		List<Integer> ans = topKFrequent(nums, k);
		
	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
		
		List<Integer> result = new ArrayList<>(); 
		
		Map<Integer, Integer> count_map = new HashMap<>();
		
		for(int i : nums) {
			
			if(count_map.get(i) == null) {
				count_map.put(i, 1);
			} else {
				count_map.put(i, (count_map.get(i) + 1));
			}
		}
		
		ArrayList<Integer>[] count_list = new ArrayList[nums.length];
		
		for (Map.Entry<Integer, Integer> entry : count_map.entrySet()) {
			if (count_list[entry.getValue() - 1] == null) {
				count_list[entry.getValue() - 1] = new ArrayList<>();
				count_list[entry.getValue() - 1].add(entry.getKey());
				
			} else {
				count_list[entry.getValue() - 1].add(entry.getKey());
			}
//			System.out.println(count_list[entry.getValue() - 1]);
		}
		
		int x = 0;
		for (int i = count_list.length - 1; i >= 0; i--) {
			if(x >= k) {
				break;
			} else {
				if(count_list[i] == null) {
					continue;
				} else {
					for (int j : count_list[i]) {
						result.add(j);
						x ++;
					}
				}
			}
		}
		
		System.out.println(result);
		
		return result;
		
	}
}
