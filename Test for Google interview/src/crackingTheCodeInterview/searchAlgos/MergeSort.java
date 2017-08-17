package crackingTheCodeInterview.searchAlgos;

import java.util.Arrays;

public class MergeSort {
	
	
	public static void main(String[] args) {
		int[] arr = {2,3};
		int[] arr2 = {2,3,2,4};
		int[] arr3 = {2,4,3,1};
		System.out.println(Arrays.toString(arr));
		mergesort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		mergesort(arr2);
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		mergesort(arr3);
		System.out.println(Arrays.toString(arr3));
	}
	
	
	
	
	public static void mergesort(int[] array) {
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length - 1);
	}

	public static void mergesort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(array, helper, low, middle); // Sort left half
			mergesort(array, helper, middle + 1, high); // Sort right half
			merge(array, helper, low, middle, high); // Merge them
		}
	}

	public static void merge(int[] array, int[] helper, int low, int middle, int high) {
		/* Copy both halves into a helper array */
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}

		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;

		/*
		 * Iterate through helper array. Compare the left and right half,
		 * copying back the smaller element from the two halves into the
		 * original array.
		 */
//		while (helperLeft <= middle && helperRight <= high) {
//			if (helper[helperLeft] <= helper[helperRight]) {
//				array[current] = helper[helperLeft];
//				helperLeft++;
//			} else { // If right element is smaller than left element
//				array[current] = helper[helperRight];
//				helperRight++;
//			}
//			current++;
//		}
		
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] > helper[helperRight]) {
				array[current] = helper[helperRight];
				helperRight++;
			} else { // If right element is smaller than left element
				array[current] = helper[helperLeft];
				helperLeft++;
			}
			current++;
		}

		/*
		 * Copy the rest of the left side of the array into the target array
		 */
//		int remaining = middle - helperLeft;
//		for (int i = 0; i <= remaining; i++) {
//			array[current + i] = helper[helperLeft + i];
//		}
		
		/*
		 * Copy the rest of the items of the array into the target array
		 */
		
		for (int i = 0; i <= middle-helperLeft; i++) {
			array[current + i] = helper[helperLeft + i];
		}
	}
}