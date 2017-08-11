package leetcode_easy;

public class Merge_Sorted_Array {
	
	public static void main(String args[]) {
		
		int nums1[] = {1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0, 0};
		int nums2[] = {1, 3, 5, 7, 9, 11};
		Merge_Sorted_Array m = new Merge_Sorted_Array();
		m.merge(nums1, 6, nums2, 6);
		
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int[] ans = new int[m + n];
        
        int index1 = 0;
        int index2 = 0;
        
        int ans_index = 0;
        
        while(index1 < m && index2 < n) {
            if(nums1[index1] <= nums2[index2]) {
                ans[ans_index++] = nums1[index1];
                index1++;
            } else {
                ans[ans_index++] = nums2[index2];
                index2++;
            }
        }
        
        while(index1 < m) {
            ans[ans_index++] = nums1[index1];
            index1++;
        }
        
        while(index2 < n) {
            ans[ans_index++] = nums2[index2];
            index2++;
        }
        
        for(int i = 0; i < ans.length; i ++) {
            nums1[i] = ans[i];
        }
        
        for(int i : nums1) {
        	System.out.println(i);
        }
            
    }

}
