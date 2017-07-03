package leetcode_medium;

import java.util.HashMap;

public class Sort_Colors {
	
	public static void main(String args[]) {
		
		int nums[] = {0, 1, 2, 0, 0, 2, 1, 2, 1, 0, 1, 2};
		Sort_Colors sc = new Sort_Colors();
		sc.sortColors(nums);
		
	}
	
	public void sortColors(int[] nums) {
        HashMap<Integer, Integer> color_counts = new HashMap<>();
        for(int i : nums) {
            if(color_counts.containsKey(i)) {
                color_counts.put(i, color_counts.get(i) + 1);
            } else {
                color_counts.put(i, 1);
            }
        }
        
        int index = 0;
        for(int x : color_counts.keySet()) {
            int count = color_counts.get(x);
            for(int i = 0; i < count; i ++) {
                nums[index++] = x;
            }
        }
    }

}
