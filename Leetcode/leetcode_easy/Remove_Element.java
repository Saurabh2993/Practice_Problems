package leetcode_easy;

public class Remove_Element {
	
	public static void main(String args[]) {
		
		int nums[] = {3, 2, 2, 3};
		int val = 3;
		
		Remove_Element r = new Remove_Element();
		System.out.println(r.removeElement(nums, val));
		
	}
	
	public int removeElement(int[] nums, int val) {
        
        int n = nums.length;
        int i = 0;
        
        while(i < n) {
            if(nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        
        return n;
    }
}
