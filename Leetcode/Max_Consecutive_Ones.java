
public class Max_Consecutive_Ones {
	
	public static void main(String args[]) {
		
		int nums[] = {1, 1, 0, 1, 1, 1};
		
		int ans = findMaxConsecutiveOnes(nums);
		System.out.println(ans);
		
	}
	
	public static int findMaxConsecutiveOnes(int[] nums) {
		
		int max_count = 0;
		int count = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 1) {
				count++;
			} else {
				if(count > max_count) {
					max_count = count;
				}
				count = 0;
			}
		}
		if(count > max_count)
			max_count = count;
		
		return max_count;
	}
}