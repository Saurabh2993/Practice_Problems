package leetcode_medium;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Permutation {
	
	public static void main(String args[]) {
		
		int nums[] = {1, 2, 3};
		Permutation p = new Permutation();
		System.out.println(p.permute(nums));
		
	}
	
	public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        HashMap<Integer, Integer> nums_map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            nums_map.put(nums[i], 1);
        }
        permutationHelper(nums, nums_map, result, temp, 0);
        
        return result;
    }
    
    private void permutationHelper(int[] nums, HashMap<Integer, Integer> nums_map, List<List<Integer>> result, List<Integer> temp, int index) {
        if(index == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(Integer i : nums_map.keySet()) {
            if(nums_map.get(i) != 0) {
                nums_map.put(i, 0);
                temp.add(i);
                permutationHelper(nums, nums_map, result, temp, index + 1);
                temp.remove(temp.size() - 1);
                nums_map.put(i, 1);
            }
        }
    }

}
