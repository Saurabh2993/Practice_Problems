package leetcode_medium;

public class Integer_Break {
	
	public static void main(String args[]) {
		
		int n = 11;
		
		System.out.println(integerBreak(n));
		
	}
	
//	public static int integerBreak(int n) {
//		
//		if(n == 2)
//            return 1;
//            
//        if(n == 3)
//            return 2;
//		
//		if(n % 3 == 0) {
//			return (int) Math.pow(3, n / 3);
//		} else if (n % 3 == 1) {
//			return (int) Math.pow(3, (n / 3) - 1) * 4;
//		} else {
//			return (int) Math.pow(3, (n / 3)) * 2;
//		}
//	}
	
//	DP Solution
	public static int integerBreak(int n) {
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        
        for(int i = 3; i <= n; i ++) {
            if(i <= 4) {
                dp[i] = dp[i - 1] * 2;
            }
            else if(i == 5) {
                dp[i] = dp[i - 2] * 3;
            }
            else if(i % 3 == 0) {
                dp[i] = (int) Math.pow(3, i / 3);
                continue;
            }
            else if(i % 3 == 1) {
                dp[i] = dp[i - 2] * 2;
            } else if(i % 3 == 2) {
                dp[i] = dp[i - 3] * 3;
            }
        }
            
        return dp[n];
    }

}
