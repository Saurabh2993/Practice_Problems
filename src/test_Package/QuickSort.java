package test_Package;

public class QuickSort {
	
	public static void main (String args[]) {
		
		int x[] = {34, 42, 67, 82, 90, 17, 12};
		int i = 0;
		int j = x.length - 1;
		sort(x, i, j);
		for(int k = 0; k < x.length; k++)
			System.out.print(x[k] + " ");
	}

	public static void sort (int a[], int low, int high) {
		
		int i = low;
		int j = high;
		int temp;
		int pivot = a [low];
	
		for(int k = i; k < a.length; k++)
//			System.out.print(a[k] + " ");
//		System.out.println();
		
		
		while(i <= j) {
			//System.out.println(i +"  " + j);
			while (a[i] < pivot) {
//				System.out.println(a[i]);
				i++;
			}
			while (a[j] > pivot) {
//				System.out.println(a[j]);
				j--;
			}
		
			if(i <= j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				
//				for(int k = 0; k < a.length; k++)
//					System.out.print(a[k] + " ");
//				System.out.println();
				
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