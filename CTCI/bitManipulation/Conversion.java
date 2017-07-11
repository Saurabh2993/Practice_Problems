package bitManipulation;

public class Conversion {
	
	public static void main(String args[]) {
		
		int a = 29;
		int b = 29;
		
		Conversion c = new Conversion();
		System.out.println(c.bitsForConversion(a, b));
	}
	
	/*public int bitsForConversion(int a, int b) {
		
		int temp = a ^ b;
		int count = 0;
		
		while(temp != 0) {
			count += (temp & 1);
			temp >>= 1;
		}
		
		return count;
	}*/
	
//	Slightly faster approach
	public int bitsForConversion(int a, int b) {
		
		int count = 0;
		int c = a ^ b;
		while(c != 0) {
			count++;
			c = c & (c - 1);
		}
		
		return count;
	}

}
