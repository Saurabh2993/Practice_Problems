package leetcode_medium;

public class Integer_Replacement {
	
	public static void main(String args[]) {
		
		int n = 20;
		Integer_Replacement i = new Integer_Replacement();
		System.out.println(i.integerReplacement(n));
		
	}
	
//	Logic here is if n is an odd number, (n-1) and (n+1) will be even and one of them will be a multiple of 4. If n is a multiple of 4 we can take at least two steps towards 1 before running into another odd number where as if n is a multiple of 2 we can take only one step and then we would run into another odd number. The only edge case here is for number 3 where it is better if we choose 2 instead of 4.  
	public int integerReplacement(int n) {
        
        if(n == Integer.MAX_VALUE) {
            return 32;
        }
        
        int count = 0;
        
        while(n > 1) {
            if(n % 2 == 0) {
                n = n / 2;
            } else {
                if((n + 1) % 4 == 0 && n != 3) {
                    n++;
                } else {
                    n--;
                }
            }
            
            count++;
        }
        
        return count;
    }

}
