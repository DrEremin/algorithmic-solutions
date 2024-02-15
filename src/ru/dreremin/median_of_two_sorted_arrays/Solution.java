package ru.dreremin.median_of_two_sorted_arrays;

public class Solution {
	
    private boolean foundMin = false;
	private boolean foundMax = false;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArrays(nums1, -1, nums1.length, 
        							  nums2, -1, nums2.length);
    } 
	
	private double findMedianSortedArrays(int[] a1, int l1, int r1,     
		     				 			  int[] a2, int l2, int r2) { 
		
		int len = a1.length + a2.length;
		boolean odd = (len & 1) == 1;
		int min = (len >> 1) + (len & 1);
		int max = odd ? min : min + 1;
		int pivot, ptr, numL;
		
		if ((r1 - l1 - 1) <= (r2 - l2 - 1)) { 
			int[] temp = a1; a1 = a2; a2 = temp;
			int t = l1; l1 = l2; l2 = t; t = r1; r1 = r2; r2 = t;
		}
		pivot = l1 + (r1 - l1 >> 1);
		ptr = binarySearch(a2, l2, r2, a1[pivot]);
		ptr = ptr >= 0 ? ptr : -1 * (ptr + 1);
		numL = pivot + ptr + 1;
		
		if (numL < min) {
			l1 = pivot; l2 = ptr - 1;
			return findMedianSortedArrays(a1, l1, r1, a2, l2, r2);
		} 
		if(numL > max) {
			r1 = pivot + 1; r2 = ptr;
			return findMedianSortedArrays(a1, l1, r1, a2, l2, r2);
		}
		if (numL == min) {
			l1 = pivot; l2 = ptr - 1; foundMin = true;
			return odd || foundMax ? a1[pivot] : (double) (a1[pivot] + 
					findMedianSortedArrays(a1, l1, r1, a2, l2, r2)) / 2;
		} 
		r1 = pivot; r2 = ptr; foundMax = true;
		return odd || foundMin ? a1[pivot] : (double) (a1[pivot] + 
				findMedianSortedArrays(a1, l1, r1, a2, l2, r2)) / 2;
		
	}
	
	private int binarySearch(int[] a, int leftExclus, 
                             int rightExclus, int v) {	
		
		int l = leftExclus, r = rightExclus;
		
		for (int i = l + (r - l >> 1); r > l + 1; i = l + (r - l >> 1)) {
			if (a[i] >= v) { r = i; } 
			else { l = i; }
		}
		return (r != rightExclus) && a[r] == v ? r : -1 * (r + 1);
	}
}
