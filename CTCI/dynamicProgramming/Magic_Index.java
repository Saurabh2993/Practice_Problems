package dynamicProgramming;

public class Magic_Index {
	
	public static void main(String args[]) {
		
		int nums[] = {-20, 2, 4, 4, 5, 6, 8, 12, 13, 42, 55, 64, 72, 81, 100};
		Magic_Index m = new Magic_Index();
		System.out.println(m.findMagicIndex(nums));
		
	}
	
	public int findMagicIndex(int n[]) {
		
		return magicIndexHelper(n, 0, n.length - 1);
		
	}
	
	public int magicIndexHelper(int n[], int start, int end) {
		
		if(end < start) {
			return -1;
		}
		
		int midIndex = (start + end) / 2;
		int midValue = n[midIndex];
		if(midValue == midIndex) {
			return midValue;
		}
		
		int leftValue = magicIndexHelper(n, start, Math.min(midIndex - 1, midValue));
		if(leftValue >= 0) {
			return leftValue;
		}
		
		int rightValue = magicIndexHelper(n, Math.max(midIndex + 1, midValue), end);
		return rightValue;
		
	}

}
