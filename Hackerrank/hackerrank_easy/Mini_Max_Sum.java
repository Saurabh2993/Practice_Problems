package hackerrank_easy;

import java.util.Scanner;

public class Mini_Max_Sum {
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		int a[] = new int[5];
		
		for(int i = 0; i < 5; i ++) {
			
			a[i] = in.nextInt();
			
		}
		
		sort(a, 0, 4);
		
		long min_sum = 0;
		long max_sum = 0;
		
		for (int i = 0; i < a.length - 1; i++) {
			
			min_sum = min_sum + a[i];
			max_sum = max_sum + a[i + 1];
			
		}
		
		System.out.println(min_sum + " " + max_sum);
		
	}
	
	public static void sort (int a[], int low, int high) {
		
		int i = low;
		int j = high;
		int temp;
		int pivot = a [low];
		
		while(i <= j) {
			while (a[i] < pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
		
			if(i <= j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				
				i++;
				j--;
			}
		}
		
		if (low < j)
			sort (a, low, j);
		if (high > i)
			sort (a, i, high);
	}

}
