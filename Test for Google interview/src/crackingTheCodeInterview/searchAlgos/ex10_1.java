package crackingTheCodeInterview.searchAlgos;

import java.util.Arrays;

public class ex10_1 {

	public static void main(String[] args) {
		int[] a = {3,5,8,Integer.MIN_VALUE, Integer.MIN_VALUE};
		int[] b = {9,9};
		System.out.println(Arrays.toString(a));
		merge2(a, b);
		System.out.println(Arrays.toString(a));
	}
	
	public static void merge(int[] a, int[] b){
		int lastIndexA = a.length - b.length - 1;
		for(int i = lastIndexA; i >= 0; i--){
			a[b.length+i] = a[i];
		}
		int indexA = b.length;
		int indexB = 0;
		int indexMerged = 0;
		while(indexB < b.length){
			if(indexA < a.length && a[indexA] < b[indexB]){
				a[indexMerged] = a[indexA];
				indexA++;
			}
			else{
				a[indexMerged] = b[indexB];
				indexB++;
			}
			indexMerged++;
		}
	}
	
	public static void merge2(int[] a, int[] b){
		int indexA = a.length-b.length-1;
		int indexB = b.length-1;
		int indexMerged = a.length-1;
		while(indexB >=0){
			if(indexA >= 0 && a[indexA] > b[indexB]){
				a[indexMerged] = a[indexA];
				indexA--;
			}
			else{
				a[indexMerged] = b[indexB];
				indexB--;
			}
			indexMerged--;
		}
	}
}
