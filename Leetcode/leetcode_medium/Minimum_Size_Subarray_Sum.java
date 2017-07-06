package leetcode_medium;

public class Minimum_Size_Subarray_Sum {
	
	public static void main(String args[]) {
		
		int nums[] = {2, 3, 1, 2, 4, 3};
		int s = 7;
		
		Minimum_Size_Subarray_Sum a = new Minimum_Size_Subarray_Sum();
		System.out.println(a.minSubArrayLen(s, nums));
	}
	
	public int minSubArrayLen(int s, int[] nums) {
        
        int curr = 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for(i = 0; i < nums.length; i++) {
            curr++;
            sum += nums[i];
            
            if(sum >= s) {
            
                while(sum > s && curr != 0) {
                    sum -= nums[j];
                    j ++;
                    curr--;
                }

                if(sum != s) {
                    j--;
                    sum += nums[j];
                    curr++;
                }
                
                min = Math.min(min, curr);
            }
        }
        
        if(min == Integer.MAX_VALUE) {
            return 0;
        } else {
            return min;
        }
    }
}
