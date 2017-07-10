package leetcode_easy;

import java.util.Arrays;

public class Majority_Element_2 {
	
	public static void main(String args[]) {
		int nums[] = {2,2,3,5,4,2,2,2,2};
		Majority_Element_2 m = new Majority_Element_2();
		
		System.out.println(m.majorityElement(nums));
	}
	
	
	/*public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }*/
	
	public int majorityElement(int[] nums) {
		
		int element = nums[0];
		int count = 0;
		
		for(int i : nums) {
			if(count == 0) {
				element = i;
			}
			if(i == element) {
				count ++;
			} else {
				count --;
			}
		}
		
		return element;
		
	}
}
