package test_Package;

public class Sort_Contiguous {
	
	public static void main(String args[]) {
		
		int A[] = {1, 2, 6, 5, 4, 3, 2, 1};
		
		Sort_Contiguous s = new Sort_Contiguous();
		s.minStudents(A);
	}
	
	public int minStudents(int[] A) {
		
		int index1 = Integer.MIN_VALUE;
		
		for(int i = 1; i < A.length; i ++) {
			if(A[i - 1] > A[i]) {
				index1 = i - 1;
				break;
			}
		}
		
		System.out.println(index1);
		if(index1 == Integer.MIN_VALUE) {
			return 0;
		}
		
		int min = A[index1];
		for(int i = index1; i < A.length; i ++) {
			min = Math.min(min, A[i]);
		}
		
		System.out.println(min);
		System.out.println(A[index1]);
		
		for(int i = index1; i >= 0; i --) {
			if(A[i] > min) {
				index1 = i;
			}
		}
		System.out.println(A[index1]);
		
		int index2 = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = A.length - 1; i > 0; i --) {
			if(A[i - 1] > A[i]) {
				max = A[i - 1];
				index2 = i - 1;
				break;
			}
		}
		
		System.out.println(index2);
		
		while(index2 < A.length) {
			if(max < A[index2]) {
				break;
			}
			index2++;
		}
		System.out.println(index2);
		System.out.println(index2 - index1);
		
		return index2 - index1;
	}

}
