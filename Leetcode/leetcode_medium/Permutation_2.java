package leetcode_medium;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Permutation_2 {
	
	List<List<Integer>> answer = new ArrayList<List<Integer>>();
	
	public static void main(String args[]) {
		
		Permutation_2 p = new Permutation_2();
		int[] nums = {1, 1, 2, 2};
		List<List<Integer>> answer = p.permuteUnique(nums);
		
		for(List<Integer> list : answer) {
			System.out.println(list);
		}
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		
		List<Integer> permutation = new ArrayList<>();
		HashMap<Integer, Integer> nums_map = new HashMap<>();
		
		for(int i : nums) {
			if(nums_map.containsKey(i)) {
				nums_map.put(i, nums_map.get(i) + 1);
			} else {
				nums_map.put(i, 1);
			}
		}
		
		permuteUnique(permutation, answer, nums_map, nums.length);
		
		/*for(List<Integer> l : answer) {
			System.out.println(l);
		}*/
		
		return answer;
	}
	
	public void permuteUnique(List<Integer> permutation, List<List<Integer>> answer, HashMap<Integer, Integer> nums_map, int n) {
		
		if(n <= 0) {
			answer.add(new ArrayList<Integer>(permutation));
			return;
		}
		
		for(Integer num : nums_map.keySet()) {
			if(nums_map.get(num) <= 0) {
				continue;
			}
			nums_map.put(num, nums_map.get(num) - 1);
			permutation.add(num);
//			System.out.println(permutation);
			permuteUnique(permutation, answer, nums_map, n - 1);
			nums_map.put(num, nums_map.get(num) + 1);
			permutation.remove(permutation.size() - 1);
		}
	}

}
