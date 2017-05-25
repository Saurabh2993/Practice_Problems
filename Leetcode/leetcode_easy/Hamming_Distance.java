package leetcode_easy;

public class Hamming_Distance {
	
	public static void main(String args[]) {
		
//		680142203
//		1111953568

		
		int ans = hammingDistance(680142203, 1111953568);
		
		System.out.println(ans);
		
		
	}
	
	public static int hammingDistance(int x, int y) {

		String binaryIntx = Integer.toBinaryString(x);
		String binaryInty = Integer.toBinaryString(y);
		
//		System.out.println(binaryIntx);
//		System.out.println(binaryInty);
		
		int binaryLengthx = binaryIntx.length();
		int binaryLengthy = binaryInty.length();
		
//		System.out.println(binaryLengthx);
//		System.out.println(binaryLengthy);
		
		if(binaryLengthx != binaryLengthy) {
			
			if(binaryLengthx > binaryLengthy) {
				
				for (int i = binaryLengthy; i < binaryLengthx; i++) {
					
					binaryInty = "0" + binaryInty;
					
				}
				
//				binaryInty = String.format("%0"+ binaryLengthx + "d", Integer.parseInt(binaryInty));
				
			} else if(binaryLengthx < binaryLengthy) {
				
				for (int i = binaryLengthx; i < binaryLengthy; i++) {
					
					binaryIntx = "0" + binaryIntx;
					
				}
				
//				binaryIntx = String.format("%0"+ binaryLengthy + "d", Integer.parseInt(binaryIntx));
				
			}
		}
		
//		System.out.println(binaryIntx);
//		System.out.println(binaryInty);
		
		int hamming_distance = 0;
		
		for (int i = 0; i < binaryIntx.length(); i++) {
			if(binaryIntx.charAt(i) != binaryInty.charAt(i)) {
				hamming_distance ++;
			}
		}
		
		return hamming_distance;
		
	}

}
