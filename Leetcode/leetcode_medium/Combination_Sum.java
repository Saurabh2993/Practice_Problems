package leetcode_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Combination_Sum {
	
	public static void main(String args[]) {
		
		Combination_Sum c = new Combination_Sum();
		int target = 7;
		int[] candidates = {2, 3, 6, 7};
		System.out.println(c.combinationSum(candidates, target));
		
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		List<List<Integer>> answer_list = new ArrayList<List<Integer>>();
		List<Integer> nums = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum(answer_list, candidates, target, 0, nums, 0);
		
		return answer_list;
	}
	
	private void combinationSum(List<List<Integer>> answer_list, int[] candidates, int target, int sum, List<Integer> nums, int start) {
		if(sum > target) {
			return;
		} else if (sum == target) {
			answer_list.add(new ArrayList<>(nums));
			return;
		} else {
			for (int i = start; i < candidates.length; i++) {
				if(sum + candidates[i] > target) {
					break;
				}
				nums.add(candidates[i]);
				combinationSum(answer_list, candidates, target, sum + candidates[i], nums, i);
				nums.remove(nums.size() - 1);
			}
		}
	}
}
