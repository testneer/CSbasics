package crackingTheCodeInterview.recursion;

import java.util.Arrays;

public class ex16_16 {

	public static void main(String[] args) {
		int[] arr = {1,2,4,7,10,11,7,17,6,7,16,18,19};
		int[] array = {1, 9, 4, 3, 5};
		int[] arr1 = {2,2,2,2,1,2,2,2,2};
		System.out.println(getSubIndices(arr));
		findUnsortedSequence(arr);
		System.out.println(getSubIndices(new int[]{3}));
		findUnsortedSequence(new int[]{3});
		System.out.println(getSubIndices(new int[]{3,4}));
		findUnsortedSequence(new int[]{3,4});
		System.out.println(getSubIndices(new int[]{4,3}));
		findUnsortedSequence(new int[]{4,3});
		System.out.println(getSubIndices(array));
		findUnsortedSequence(array);
		System.out.println(getSubIndices(arr1));
		findUnsortedSequence(arr1);
//		System.out.println(getSubIndices(new int[]{}));
		findUnsortedSequence(new int[]{});
		
		
		System.out.println(Arrays.binarySearch(arr, 0,5,0));
		
//		System.out.println(Arrays.binarySearch(new int[]{1,2,3},0));
//		System.out.println(Arrays.binarySearch(new int[]{1,2,3},4));
//		System.out.println(Arrays.binarySearch(new int[]{1,2,3},3));
//		System.out.println(Arrays.binarySearch(new int[]{1,2,3},1,3,1));
	}
	
	public static class Result{
		int m,n;
		public Result(int m, int n) {
			this.m = m;
			this.n=n;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "("+m+","+n+")";
		}
	}
	
	public static Result getSubIndices(int[] arr){
		if(arr == null || arr.length == 0){
			throw new IllegalArgumentException();
		}
		int leftEnd = 0;
		int rightStart = arr.length-1;
		
		while(leftEnd+1 < arr.length){
			if(arr[leftEnd] > arr[leftEnd+1]){
				break;
			}
			leftEnd++;
		}
		if(leftEnd == arr.length-1){
			return new Result(-1, -1);
		}
		while(rightStart > 0){
			if(arr[rightStart]<arr[rightStart-1] || arr[rightStart-1] < arr[leftEnd]){
				break;
			}
			rightStart--;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = leftEnd+1; i <= rightStart; i++){
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		
		int m = Arrays.binarySearch(arr, 0,leftEnd+1,min);
		if(m<0){
			m+=1;
			m*=-1;
		}
		else{
			while(m<arr.length-1 && arr[m] == arr[m+1]){
				m++;
			}
		}
		
		int n = Arrays.binarySearch(arr, rightStart,arr.length,max);
		if(n<0){
			n+=1;
			n=n*-1;
			n=n-1;
		}else{
			while(n>0 && arr[n] == arr[n-1]){
				n--;
			}
		}
		return new Result(m,n);
	}
	
	
	
	//////////////////BOOK solution
	public static int findEndOfLeftSubsequence(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				return i - 1;
			}
		}
		return array.length - 1;
	}
	
	public static int findStartOfRightSubsequence(int[] array) {
		for (int i = array.length - 2; i >= 0; i--) {
			if (array[i] > array[i + 1]) {
				return i + 1;
			}
		}
		return 0;
	}		
	
	public static int shrinkLeft(int[] array, int min_index, int start) {
		int comp = array[min_index];
		for (int i = start - 1; i >= 0; i--) {
			if (array[i] <= comp) {
				return i + 1;
			}
		}
		return 0;
	}
	
	public static int shrinkRight(int[] array, int max_index, int start) {
		int comp = array[max_index];
		for (int i = start; i < array.length; i++) {
			if (array[i] >= comp) {
				return i - 1;
			}
		}
		return array.length - 1;
	}	
	
	public static void findUnsortedSequence(int[] array) {
		// find left subsequence
		int end_left = findEndOfLeftSubsequence(array);	
		
		if (end_left >= array.length - 1) {
			//System.out.println("The array is already sorted.");
			return; // Already sorted
		}
		
		// find right subsequence
		int start_right = findStartOfRightSubsequence(array);	
		
		int max_index = end_left; // max of left side
		int min_index = start_right; // min of right side
		for (int i = end_left + 1; i < start_right; i++) {
			if (array[i] < array[min_index]) {
				min_index = i;
			}
			if (array[i] > array[max_index]) {
				max_index = i;
			}
		}		
		
		// slide left until less than array[min_index]
		int left_index = shrinkLeft(array, min_index, end_left);

		// slide right until greater than array[max_index]
		int right_index = shrinkRight(array, max_index, start_right);
		
		if (validate(array, left_index, right_index)) {
			System.out.println("TRUE: " + left_index + " " + right_index);
		} else {
			System.out.println("FALSE: " + left_index + " " + right_index);
		}
	}
	
	/* Validate that sorting between these indices will sort the array. Note that this is not a complete
	 * validation, as it does not check if these are the best possible indices.
	 */
	public static boolean validate(int[] array, int left_index, int right_index) {
		int[] middle = new int[right_index - left_index + 1];
		for (int i = left_index; i <= right_index; i++) {
			middle[i - left_index] = array[i];
		}
		java.util.Arrays.sort(middle);
		for (int i = left_index; i <= right_index; i++) {
			array[i] = middle[i - left_index];
		}
		for (int i = 1; i < array.length; i++) {
			if (array[i-1] > array[i]) {
				return false;
			}		
		}
		return true;
	}
	

}
