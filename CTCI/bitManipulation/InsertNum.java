package bitManipulation;

public class InsertNum {
	
	public static void main(String args[]) {
		
		int m = 1399;
		int n = 19;
		
		InsertNum x = new InsertNum();
		System.out.println(Integer.toBinaryString(x.insertNInM(n, m, 2, 6)));
		
	}
	
	public int insertNInM(int n, int m, int i, int j) {
		
		int allOnes = ~0;
		
		int left_mask = m & (allOnes << (j + 1));
		System.out.println(Integer.toBinaryString(left_mask));
		
		int right_mask = m & ((1 << i) - 1);
		System.out.println(Integer.toBinaryString(right_mask));
		
		int mask = left_mask | right_mask;
		
		return mask | (n << i);
	}

}
