package leetcode_hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Max_Gap {
	
	public static void main(String args[]) {
		
		int nums[] = {5, 4, 10, 6, 2, 8, 1, 9};
		Max_Gap m = new Max_Gap();
		System.out.println(m.maximumGap(nums));
		
	}
	
//	Sorting approach
	public int maximumGap(int[] nums) {
		
		if(nums.length < 2) {
            return 0;
        }
		
		Arrays.sort(nums);
		int prev = nums[0];
        int max_gap = Integer.MIN_VALUE;
        
        for (int i = 1; i < nums.length; i++) {
			
        	max_gap = max_gap > (nums[i] - prev) ? max_gap : (nums[i] - prev); 
        	prev = nums[i];
		}
		
        return max_gap;
	}
	
//	Min Heap approach
	/*public int maximumGap(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(int i = 0; i < nums.length; i ++) {
			minHeap.add(nums[i]);
		}
		
		int prev = minHeap.remove();
        int max_gap = Integer.MIN_VALUE;
		
		while(minHeap.size() != 0) {
            
			Integer curr = minHeap.remove();
			int gap = curr - prev;
			max_gap = max_gap > gap ? max_gap : gap;
			prev = curr;
		}
		
		return max_gap;
	}*/

}
