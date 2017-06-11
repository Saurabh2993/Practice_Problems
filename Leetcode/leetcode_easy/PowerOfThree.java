package leetcode_easy;

public class PowerOfThree {
	
	public static void main(String args[]) {
		
		System.out.println(isPowerOfThree(28));
		
	}
	
	public static boolean isPowerOfThree(int n) {
		
		if(n <= 0)
            return false;
            
        while(n != 1) {
            if(n % 3 == 1 || n % 3 == 2) {
                return false;
            }
            n = n / 3;
            
        }
        
        return true;
		
	}

}
