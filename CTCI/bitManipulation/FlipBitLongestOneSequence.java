package bitManipulation;

public class FlipBitLongestOneSequence {
	
	public static void main(String args[]) {
		
		int n = 1024;
		FlipBitLongestOneSequence x = new FlipBitLongestOneSequence();
		
		System.out.println(x.longestOneSequenceWithFlip(n));
	}
	
	public int longestOneSequenceWithFlip(int n) {
		
		int count = 0;
		int max_count = Integer.MIN_VALUE;
		int prev_zero_index = -1;
		
		String num = Integer.toBinaryString(n);
		
		for(int i = 0; i < num.length(); i ++) {
			
			if(num.charAt(i) == '1') {
				count ++;
			} else {
				if(prev_zero_index == -1) {
					count ++;
					prev_zero_index = i;
				} else {
					if(max_count < count) {
						max_count = count;
					}
					count = i - prev_zero_index;
					prev_zero_index = i;
				}
			}
		}
		
		return max_count > count ? max_count : count;
	}

}
