package leetcode_easy;

public class Range_Sum_Query {

    int[] sumArray;
    
    public Range_Sum_Query(int[] nums) {
        createSumMatrix(nums);
    }
    
    private void createSumMatrix(int[] nums) {
    	int n = nums.length;
    	if(n == 0) {return;}
        
        sumArray = new int[n];
        sumArray[0] = nums[0];
        for(int i = 1; i < n; i ++) {
            sumArray[i] = sumArray[i - 1] + nums[i];
            
        }
        
        // for(int i = 0; i < n; i ++) {
        //     System.out.print(sumArray[i] + " ");
        // }
        
    }
    
    public int sumRange(int i, int j) {
        if(i == 0)
            return sumArray[j];
        else
            return sumArray[j] - sumArray[i - 1];
    }
    
    public static void main(String args[]) {
    	
    	int nums[] = {-2, 0, 3, -5, 2, -1};
    	Range_Sum_Query x = new Range_Sum_Query(nums);
    	
    	System.out.println(x.sumRange(0, 2));
    	System.out.println(x.sumRange(2, 5));
    	System.out.println(x.sumRange(0, 5));
    	
    }


}
