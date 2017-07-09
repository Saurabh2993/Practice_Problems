package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection_Of_Arrays {
	
	public static void main(String args[]) {
		
		int nums1[] = {1, 2, 2, 1};
		int nums2[] = {2, 2};
		
		Intersection_Of_Arrays x = new Intersection_Of_Arrays();
		System.out.println(x.intersect(nums1, nums2));
		
	}
	
	public int[] intersect(int[] nums1, int[] nums2) {
        
        int pointer1 = 0;
        int pointer2 = 0;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> common_elements = new ArrayList<>();
        
        while(pointer1 < nums1.length && pointer2 < nums2.length) {
            
            if(nums1[pointer1] < nums2[pointer2]) {
                pointer1++;
            } else if(nums1[pointer1] > nums2[pointer2]) {
                pointer2++;
            } else {
                common_elements.add(nums1[pointer1]);
                pointer1++;
                pointer2++;
            }
        }
        
        int answer[] = new int[common_elements.size()];
        int index = 0;
        
        for(int i : common_elements) {
            answer[index++] = i;
        }
        
        return answer;
    }

}
