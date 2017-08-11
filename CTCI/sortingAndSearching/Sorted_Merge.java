package sortingAndSearching;

public class Sorted_Merge {
	
	public int[] merge(int[] a, int[] b, int lastA, int lastB) {
		
		int lastIndexA = lastA - 1;
		int lastIndexB = lastB - 1;
		int index = lastA + lastB - 1;
		
		while(lastIndexB >= 0) {
			if(lastIndexA >= 0 && a[lastIndexA] > b[lastIndexB]) {
				a[index--] = a[lastIndexA];
				lastIndexA --;
			} else {
				a[index--] = b[lastIndexB];
				lastIndexB --;
			}
		}
		
		return a;
	}

}
