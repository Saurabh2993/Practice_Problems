package test_Package;

import java.util.HashSet;

public class GetDifferentNumber {
	
	public static void main(String args[]) {
		
		int arr[] = {2, 1, 3, 0};
		GetDifferentNumber g = new GetDifferentNumber();
		
		System.out.println(g.getDifferentNumber(arr));

	}
	
	//O(n) space approach
	/*public int getDifferentNumber(int[] arr) {
		
		int n = arr.length;
		HashSet<Integer> nums = new HashSet<>();
		
		for (int i = 0; i < arr.length; i++) {
			nums.add(arr[i]);
		}
		
		for (int i = 0; i < n; i++) {
			if(!nums.contains(i)) {
				return i;
			}
		}
		
		return n;
	}*/
	
	//O(1) space approach
	public int getDifferentNumber(int[] arr) {
		
		int n = arr.length;
		
		for (int i = 0; i < arr.length; i++) {
			int curr = arr[i];
			while(curr < n && arr[curr] != curr) {
				int temp = arr[curr];
				arr[curr] = curr;
				curr = temp;
			}
		}
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		for (int i = 0; i < n; i++) {
			if(arr[i] != i)
				return i;
		}
		
		
		return n;
	}

}
