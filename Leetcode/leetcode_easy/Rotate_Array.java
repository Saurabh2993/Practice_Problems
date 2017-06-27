package leetcode_easy;

public class Rotate_Array {
	
	public static void main(String args[]) {
		
		int nums[] = {1, 2, 3, 4, 5, 6, 7};
		int k = 3;
		
		Rotate_Array r = new Rotate_Array();
		r.rotate(nums, k);
		
		for (int i : nums) {
			System.out.print(i + " ");
		}
		
	}
	
	/*public void rotate(int[] nums, int k) {
		
		int n = nums.length;
		k = k % n;
		
		if(k == 0)
			return;
		
		reverse(nums, 0, n - k - 1);
		reverse(nums, n - k, n - 1);
		reverse(nums, 0, n - 1);
		
	}*/
	
	public void reverse(int nums[], int start, int end) {
		 
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			
			start++;
			end--;
		}
	}
	
	public void rotate(int[] nums, int k) {
		
		int n = nums.length;
		k = k % n;
		
		if(k == 0)
			return;
		
		int buffer[] = new int[k];
		int i = 0;
		
		for(i = 0; i < k; i ++) {
			buffer[i] = nums[n - k + i];
		}
		
		for (i = n - k - 1; i >= 0; i--) {
			nums[i + k] = nums[i];
		}
		for(i = 0; i < k; i ++) {
			nums[i] = buffer[i];
		}
	}

}
