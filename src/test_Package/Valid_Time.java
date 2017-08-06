package test_Package;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Valid_Time {
	
	public static void main(String args[]) {
		
		int A = 0;
		int B = 0;
		int C = 0;
		int D = 8;
		
		Valid_Time v = new Valid_Time();
		v.findMaxTime(A, B, C, D);
		
		
	}
	
	public String findMaxTime(int A, int B, int C, int D) {
		
		int nums[] = {A, B, C, D};
		Set<String> validTimes = new HashSet<>();
		
		HashMap<Integer, Integer> num_count = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(!num_count.containsKey(nums[i])) {
				num_count.put(nums[i], 0);
			}
			num_count.put(nums[i], num_count.get(nums[i]) + 1);
		}
		
		getValidTimes(validTimes, nums, 0, "", num_count);
		System.out.println(validTimes);
		if(validTimes.size() == 0) {
			return "NOT POSSIBLE";
		}
		
		List<String> times = new ArrayList<>(validTimes);
		Collections.sort(times);
		System.out.println(times);
		
		StringBuilder sb = new StringBuilder();
		sb.append(times.get(times.size() - 1));
		
		sb.insert(2, ":");
//		System.out.println(sb.toString());
		
		return sb.toString();
		
	}
	
	private void getValidTimes(Set<String> validTimes, int[] nums, int index, String time, HashMap<Integer, Integer> num_count) {
		if(time.length() == 2) {
			if(Integer.parseInt(time) >= 24) {
				return;
			}
		}
		if(time.length() == 4) {
			if(Integer.parseInt(time) % 100 < 60) {
				validTimes.add(time);
			}
			return;
		}
		
		for(int i = 0; i < nums.length; i ++) {
			
			if(num_count.get(nums[i]) != 0) {
				num_count.put(nums[i], num_count.get(nums[i]) - 1);
				
				getValidTimes(validTimes, nums, index + 1, time + nums[i], num_count);
				
				num_count.put(nums[i], num_count.get(nums[i]) + 1);
			}
		}
	}

}
