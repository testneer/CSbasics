package crackingTheCodeInterview.recursion;

import java.util.Arrays;

public class ex16_6 {

	public static void main(String[] args) {
		int[] arr2 = {Integer.MIN_VALUE +100};
		int[] arr1 = {Integer.MAX_VALUE -100};
		System.out.println(getSmallestGap(arr1, arr2));
		System.out.println(getSmallestGapSimple(arr1, arr2));
	}
	
	
	public static int getSmallestGapSimple(int[] arr1, int[] arr2){
		if(arr1 == null || arr2 ==null || arr2.length == 0 || arr1.length == 0){
			return -1;
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int index1 = 0;
		int index2 = 0;
		int gap;
		int minGap = Math.abs(Math.subtractExact(arr1[index1], arr2[index2]));
		
		while(index1< arr1.length && index2 < arr2.length){
			gap = arr1[index1] > arr2[index2]?arr1[index1] - arr2[index2]: arr2[index2] - arr1[index1];
			minGap = Math.min(minGap, gap);
			
			if(arr1[index1] >= arr2[index2]){
				index2++;
			}
			else{
				index1++;
			}
		}
		return minGap;
	}
	public static int getSmallestGap(int[] arr1, int[] arr2){
		if(arr1 == null || arr2 ==null || arr2.length == 0 || arr1.length == 0){
			return -1;
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int index1 = 0;
		int index2 = 0;
		int gap1 = Integer.MAX_VALUE;
		int gap2 = Integer.MAX_VALUE;
		
		int gap = calcGap(arr1[index1], arr2[index2]);
		
		while(index1 < arr1.length && index2 < arr2.length){
			if(index1+1 < arr1.length){
				gap1 = calcGap(arr1[index1+1], arr2[index2]);
			}
			if(index2+1 < arr2.length){
				gap2 = calcGap(arr2[index2+1], arr1[index1]);
			}
			if(gap1 ==0 || gap2 ==0){
				return 0;
			}
			if(gap1 <= gap2){
				index1++;
			}
			else{
				index2++;
			}
			gap = Math.min(gap, Math.min(gap1, gap2));
		}
		return gap;
	}
	
	private static int calcGap(int a, int b){
		int smaller = a<b?a:b;
		int bigger = a<b?b:a;
		return bigger-smaller;
	}
}
