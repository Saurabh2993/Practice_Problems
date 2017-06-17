package leetcode_hard;

public class Median_Two_Sorted_Arrays {
	
	public static void main(String args[]) {
		
		int [] nums1 = {1, 3};
		int [] nums2 = {2};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
		
		
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int len1 = nums1.length;
		int len2 = nums2.length;
		
		int k = (len1 + len2 + 1) / 2;
		int num1 = findkth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, k);
		if(((len1 + len2) & 1) == 1) {
			return num1;
		}
		
		int num2 = findkth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, k + 1);
		return (num1 + num2) / 2;
		
	}

	private static int findkth(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k) {
		
		if(l1 > r1) return nums2[l2 + k - 1];
		if(l2 > r2) return nums1[l1 + k - 1];
		
		int mid1 = (l1 + r1) / 2;
		int mid2 = (l2 + r2) / 2;
		
		if(nums1[mid1] <= nums2[mid2]) {
			if(k <= mid1 - l1 + mid2 - l2 + 1) {
				return findkth(nums1, l1, r1, nums2, l2, mid2 - 1, k);
			} else {
				return findkth(nums1, mid1 + 1, r1, nums2, l2, r2, k - (mid1 - l1) - 1);
			}
		}
		else {
			if(k <= mid1 - l1 + mid2 - l2 + 1) {
				return findkth(nums1, l1, mid1 - 1, nums2, l2, r2, k);
			} else {
				return findkth(nums1, l1, r1, nums2, mid2 + 1, r2, k - (mid2 - l2) - 1);
			}
		}
	}

}
