package leetcode_easy;

public class Nth_Digit {
	
	public static void main(String args[]) {
		
		int n = 3;
		
		Nth_Digit x = new Nth_Digit();
		System.out.println(x.findNthDigit(n));
		
	}

	public int findNthDigit(int n) {
        
        int num_len = 1;
        long count = 9;
        int start = 1;
        
        while(n > num_len * count) {
            
            n -= num_len * count;
            count *= 10;
            start *= 10;
            num_len++;
            
        }
        
        start += (n - 1) / num_len;
        String s = Integer.toString(start);
        
        return Character.getNumericValue(s.charAt((n-1) % num_len));
    }

}
