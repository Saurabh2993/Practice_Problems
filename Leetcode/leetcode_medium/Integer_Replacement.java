package leetcode_medium;

public class Integer_Replacement {
	
	public static void main(String args[]) {
		
		int n = 20;
		Integer_Replacement i = new Integer_Replacement();
		System.out.println(i.integerReplacement(n));
		
	}
	
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
