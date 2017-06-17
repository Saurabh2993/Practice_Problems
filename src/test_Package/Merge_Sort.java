package test_Package;

public class Merge_Sort {
	
	public static void main(String args[]) {
		
		int nums[] = {12, 32, 1, 68, 30, 40, 8, 91, 50};
		divide(nums, 0, nums.length - 1);
		
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		
	}
	
	public static void divide(int nums[], int low, int high) {
		
		if(low < high) {
			int mid = (high + low) / 2;
			divide(nums, low, mid);
			divide(nums, mid + 1, high);
			
			merge(nums, low, mid, high);
		}
		
		
	}
	
	public static void merge(int nums[], int low, int mid, int high) {
		
		int size_l = mid - low + 1;
		int size_r = high - mid;
		int i = 0, j = 0;
		
		int l[] = new int[size_l + 1];
		int r[] = new int[size_r + 1];
		
		for (i = 0; i < size_l; i++) {
			l[i] = nums[low + i];
		}
		l[size_l] = Integer.MAX_VALUE;
		
		for (j = 0; j < size_r; j++) {
			r[j] = nums[mid + j + 1];
		}
		r[size_r] = Integer.MAX_VALUE;
		
		i = 0;
		j = 0;
		
		for (int k = low; k <= high; k++) {
			if(l[i] < r[j]) {
				nums[k] = l[i];
				i++;
			} else {
				nums[k] = r[j];
				j++;
			}
		}
	}

}
