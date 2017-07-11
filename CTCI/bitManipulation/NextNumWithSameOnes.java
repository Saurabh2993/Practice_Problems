package bitManipulation;

public class NextNumWithSameOnes {
	
	public static void main(String args[]) {
		
		int n = 1398;
//		int n = 1023;
		
		NextNumWithSameOnes x = new NextNumWithSameOnes();
		System.out.println(x.getGreaterNumber(n));
		System.out.println(Integer.toBinaryString(x.getSmallerNumber(n)));
	}
	
	public int getGreaterNumber(int n) {
		
		System.out.println(Integer.toBinaryString(n));
		int c = n;
		int c0 = 0;
		int c1 = 0;
		int answer = n;
		
		while((c != 0) && (c & 1) == 0) {
			c0++;
			c = c >> 1;
		}
		
		while((c != 0) && (c & 1) == 1) {
			c1++;
			c = c >> 1;
		}
		
		int p = c0 + c1;
		
		if(p == 31 || p == 0) {
			return -1;
		}
		
		answer = answer & (~0 << p);
		System.out.println(Integer.toBinaryString(answer));
		
		int right_mask = 1 << p;
		
		right_mask |= (1 << (c1 - 1)) - 1;
		System.out.println(Integer.toBinaryString(right_mask));
		
		return answer | right_mask;
		
	}
	
	public int getSmallerNumber(int n) {
		
		System.out.println(Integer.toBinaryString(n));
		int c = n;
		int c0 = 0;
		int c1 = 0;
		int answer = n;
		
		while((c & 1) == 1) {
			c1++;
			c = c >> 1;
		}
		
		if(c == 0) {
			return -1;
		}
		
		while((c != 0) && (c & 1) == 0) {
			c0++;
			c = c >> 1;
		}
		
		int p = c0 + c1;
		
		if(p == 0 || p == 31) {
			return -1;
		}
		
		answer = answer & (~0 << (p + 1));
//		System.out.println(Integer.toBinaryString(answer));
		
		int right_mask = (1 << (c1 + 1)) - 1;
		right_mask = right_mask  << (c0 - 1);
		
		
		return answer | right_mask;
	}

}
