package leetcode_medium;

import java.util.List;
import java.util.ArrayList;

public class Combinations {
	
	public static void main(String args[]) {
		
		int n = 4;
		int k = 1;
		Combinations c = new Combinations();
		System.out.println(c.combine(n, k));
		
	}
	
	public List<List<Integer>> combine(int n, int k) {
		
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> nums = new ArrayList<>();
		
		combine(n, 1, k, answer, nums);
		
		return answer;
	}
	
	private void combine(int n, int start, int k, List<List<Integer>> answer, List<Integer> nums) {
		if(k == 0) {
			answer.add(new ArrayList<>(nums));
			return;
		} else {
			for(int i = start; i <= n; i ++) {
				
				nums.add(i);
				combine(n, i + 1, k - 1, answer, nums);
				nums.remove(nums.size() - 1);
				
			}
		}
	}

}
