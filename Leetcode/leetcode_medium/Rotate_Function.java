package leetcode_medium;

public class Rotate_Function {
	
	public static void main (String args[]) {
		
		int A[] = {4, 3, 2, 6};
		Rotate_Function r = new Rotate_Function();
		System.out.println(r.maxRotateFunction(A));
		
	}
	
	public int maxRotateFunction(int[] A) {
        
        int n = A.length;
        if(n == 0) {
            return 0;
        }
        
        int max = 0;
        int sum = 0;
        
        for(int i = 0; i < n; i ++) {
            max += A[i] * i;
            sum += A[i];
        }
        
        int curr = max;
        
        for(int i = 1; i < n; i ++) {
            curr = curr - n * A[n - i] + sum;
            max = Math.max(max, curr);
        }
        
        return max;
    }

}
