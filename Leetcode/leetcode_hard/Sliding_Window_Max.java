package leetcode_hard;

import java.util.LinkedList;
import java.util.Queue;

public class Sliding_Window_Max {
	
	public static void main(String args[]) {
		
		int nums[] = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		
		Sliding_Window_Max s = new Sliding_Window_Max();
		
		int[] res = s.maxSlidingWindow(nums, k);
		
		for(int i : res) {
			System.out.print(i + " ");
		}
	}
	
	
	
	public int[] maxSlidingWindow(int[] nums, int k) {
		
		if(nums.length == 0) {
            int ans[] = new int[0];
            return ans;
        }
		
		Queue<Integer> window = new LinkedList<>();
		int max = Integer.MIN_VALUE;
		
		int answer[] = new int[nums.length - k + 1];
		
		for(int i = 0; i < k; i ++) {
			if(nums[i] > max) {
				max = nums[i];
			}
			window.add(nums[i]);
		}
		answer[0] = max;
		int index = 1;
		for (int i = k; i < nums.length; i++) {
			int removed_element = window.remove();
			window.add(nums[i]);
			if(nums[i] > max) {
				max = nums[i];
			} else if(max == removed_element) {
				int count = 0;
				max = Integer.MIN_VALUE;
				while(count != k) {
					int temp = window.remove();
					if(temp > max)
						max = temp;
					window.add(temp);
					count++;
				}
			}
			answer[index++] = max;
		}
		
		return answer;
	}

}
