package crackingTheCodeInterview.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class ex16_21 {

	public static void main(String[] args) {
		int[] res = swapToMakeEqual(new int[]{1,1,1,4,2,2}, new int[]{3,3,6,3});
		System.out.println(Arrays.toString(res));
		
		
		int[] res2 = swapToMakeEqual2(new int[]{1,1,1,4,2,2}, new int[]{3,3,6,3});
		System.out.println(Arrays.toString(res2));
	}
	
	private static int[] swapToMakeEqual2(int[] arr1, int[] arr2) {
		int arr1Sum = 0;
		int arr2Sum = 0;
		
		Set<Integer> set = new HashSet<Integer>();
		for(int num : arr1){
			set.add(num);
			arr1Sum += num;
		}
		
		for(int num : arr2){
			arr2Sum += num;
		}
		
		int halfDiff = Math.abs(arr1Sum - arr2Sum) / 2;
		for(int num : arr2){
			if(set.contains(num-halfDiff)){
				return new int[]{num, num-halfDiff};
			}
		}
//		Pair p = new Pair();
		return null;
		
		
	}

	static int[] swapToMakeEqual(int[] arr1, int[] arr2){
		int arr1Sum = sum(arr1);
		int arr2Sum = sum(arr2);
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int[] maxArr = arr2Sum > arr1Sum ? arr1 : arr2;
		int[] minArr = arr2Sum < arr1Sum ? arr1 : arr2;
		
		int halfGap = Math.abs(arr1Sum - arr2Sum) / 2;
		
		int maxI = 0;
		int minI = 0;
		
		while(maxI < maxArr.length && minI < minArr.length){
			int maxValue = maxArr[maxI];
			int minValue = minArr[minI];
			
			if(minArr[minI] - maxArr[maxI] == halfGap){
				int[] ret = new int[2];
				ret[0] = maxArr == arr1?maxValue:minValue;
				ret[1] = maxArr == arr1?minValue:maxValue;
				return ret;
			}
			else if (maxI-minI > halfGap){
				minI++;
			}
			else{
				maxI++;
			}
		}
		return null;
	}

	private static int sum(int[] arr1) {
		int res = 0;
		for(int num : arr1){
			res += num;
		}
		return res;
	}
}
