package bitManipulation;

public class Pairwise_Swap {
	
	public static void main(String args[]) {
		
		int n = 1023;
		Pairwise_Swap ps = new Pairwise_Swap();
		
		System.out.println(ps.swapBits(n));
	}
	
	public int swapBits(int n) {
		
		System.out.println(Integer.toBinaryString(n));
		int even_bits = n & 0xaaaaaaaa;
		int odd_bits = n & 0x55555555;
		
		System.out.println(Integer.toBinaryString(even_bits));
		System.out.println(Integer.toBinaryString(odd_bits));
		
		return (even_bits >>> 1) | (odd_bits << 1);
	}

}
