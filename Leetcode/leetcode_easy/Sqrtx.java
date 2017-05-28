package leetcode_easy;

public class Sqrtx {
	
	public static void main(String args[]) {
		
		int ans = mySqrt(2147483647);
		System.out.println(ans);
		
	}
	
	
	public static int mySqrt(int x) {
        
		if(x == 0 || x == 1)
            return x;
        
        long i = 1;
        while(i * i <= x) {
        	i++;
        }

        return (int) --i;
    }

}
