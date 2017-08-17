package crackingTheCodeInterview.searchAlgos;

import java.util.Arrays;

public class SortingAlgos {
	
	public static void main(String[] args) {
//		int[] arr = {3,2,5,7,2,5,6,28,9,9234,4,5};
		int[] arr = {3,2};
//		System.out.println(Arrays.toString(arr));
//		bubbleSort(arr);
//		System.out.println(Arrays.toString(arr));
		
//		String[] s = {"a","b","c","r","e","t","u","q","a"};
		String[] s = {"a","b","c"};
		System.out.println(Arrays.toString(s));
		quickSortStr(s);
		System.out.println(Arrays.toString(s));
	}
	
	private static void bubbleSort(int[] arr) {
		for(int lastIndex = arr.length-1; lastIndex>0; lastIndex--){
			for(int i = 0; i < lastIndex;i++){
				if(arr[i] > arr[i+1]){
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}

	private static void quickSortStr(String[] arr){
		quickSortStr(arr,0,arr.length-1);
	}
	private static void quickSortStr(String[] arr, int left, int right){
		//base condition
		if(left >= right){
			return;
		}
		int index = partition(arr, left, right);
		quickSortStr(arr, left, index);
		quickSortStr(arr, index+1, right);
	}
	
	private static int partition(String[] arr, int left, int right){
		String pivot = arr[(left+right)/2];
		while(left<=right){
			while(arr[left].compareTo(pivot) < 0){
				left++;
			}
			while(arr[right].compareTo(pivot) > 0){
				right--;
			}
			if(left <= right){
				String temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}
}
