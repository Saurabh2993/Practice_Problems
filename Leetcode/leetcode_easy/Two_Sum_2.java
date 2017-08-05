package leetcode_easy;

public class Two_Sum_2 {
	
	public static void main(String args[]) {
		
		int numbers[] = {2, 7, 11, 15};
		int target = 9;
		
		Two_Sum_2 t = new Two_Sum_2();
		t.twoSum(numbers, target);
		
		
	}
	
//	Two Pointers Approach n complexity
	public int[] twoSum(int[] numbers, int target) {
		
		int start = 0;
		int end = numbers.length - 1;
		int ans[] = new int[2];
		
		while(start < end) {
			if(numbers[start] + numbers[end] < target) {
				start++;
			} else if(numbers[start] + numbers[end] > target) {
				end --;
			} else if(numbers[start] + numbers[end] == target) {
				ans[0] = start + 1;
				ans[1] = end + 1;
				return ans;
			}
		}
		
		return ans;
	}
	
	
//	Binary Search Approach n(log n) complexity
	/*public int[] twoSum(int[] numbers, int target) {
        
        int n = numbers.length;
        int ans[] = new int[2];
        
        for(int i = 0; i < numbers.length - 1; i++) {
            
            int index1 = i;
            int index2 = binarySearch(numbers, i + 1, n - 1, target - numbers[i]);
            
            if(index1 < index2) {
                ans[0] = index1 + 1;
                ans[1] = index2 + 1;
                return ans;
            }
        }
        
        return ans;
    }
        
    private int binarySearch(int[] numbers, int start, int end, int value) {
        
        while(start <= end) {

            int mid = (start + end) / 2;
            if(numbers[mid] == value) {
                return mid;
            } else if(value < numbers[mid]) {
                end = mid - 1;
                continue;
            } else {
                start = mid + 1;
                continue;
            }
        }

        return -1;

    }*/

}
