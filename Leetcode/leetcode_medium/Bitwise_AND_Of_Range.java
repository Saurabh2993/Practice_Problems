package leetcode_medium;

public class Bitwise_AND_Of_Range {
	
	public static void main(String args[]) {
		
		Bitwise_AND_Of_Range b = new Bitwise_AND_Of_Range();
		b.rangeBitwiseAnd(5, 7);
		
	}
	
	
	/*public int rangeBitwiseAnd(int m, int n) {
        if(m == 0) {
            return 0;
        }
        if(m == n) {
            return m;
        }
        
        int len = Integer.toBinaryString(m).length();
        int mask = 1 << len;
        
        if(n >= mask && mask > 0) {
            return 0;
        }
        
        int ans = m;
        while(m < n) {
            m++;
            ans &= m;
        }
        
        return ans;
    }*/
	
	public int rangeBitwiseAnd(int m, int n) {
        while(n != 0 && m < n) {
            n &= (n - 1);
        }
        
        return n;
    }

}
