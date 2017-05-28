package leetcode_easy;

public class Next_Greater_Element_1 {
	
	public static void main (String args[]) {
		
		int[] nums1 = {4, 1, 2};
		int[] nums2 = {1, 3, 4, 2};
		
		int ans[] = nextGreaterElement(nums1, nums2);
		
		for (int i : ans)
			System.out.println(i);
		
	}
	
	public static int[] nextGreaterElement(int[] findNums, int[] nums) {
		
		int[] result = new int[findNums.length];
		
		for (int i = 0; i < result.length; i++) {
			
			result[i] = -1;
			int curr = findNums[i];
//			System.out.println(curr);
			
			int pos = nums.length;
			for (int j = 0; j < nums.length; j++) {
				
				if(curr == nums[j]) {
					
					pos = j;
					
				}
//				System.out.println(pos);
				if(j > pos && nums[j] > curr) {
					
					result[i] = nums[j];
					break;
					
				}
			}
		}
		
		return result;
	}
}
