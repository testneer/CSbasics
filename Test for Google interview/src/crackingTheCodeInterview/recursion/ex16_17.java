package crackingTheCodeInterview.recursion;

import java.util.*;

public class ex16_17 {

	public static void main(String[] args) {
		int[] a1 = {-1};
//		int[] a1 = {2, -8, -3, -2, 4, 6,};
		int[] a2 = {-1,-2,10,1,-5,-3,11,-3,-6,-1};
		int[] a3 = {2, -8, 3,1,2,3,-1 -2, 4,-2,-3,-1,-4,};
//		int[] a3 = {2, -8, 3, -2, 4};
		
		System.out.println(Arrays.toString(a1));
		System.out.println(getMaxSequence(a1));
		System.out.println(getMaxSequence2(a1));
		System.out.println(getMaxSequence3(a1));
		System.out.println(getMaxSum(a1));
		System.out.println(Arrays.toString(a2));
		System.out.println(getMaxSequence(a2));
		System.out.println(getMaxSequence2(a2));
		System.out.println(getMaxSequence3(a2));
		System.out.println(getMaxSum(a2));
		System.out.println(Arrays.toString(a3));
		System.out.println(getMaxSequence(a3));
		System.out.println(getMaxSequence2(a3));
		System.out.println(getMaxSequence3(a3));
		System.out.println(getMaxSum(a3));
		

		//test trim Negatives
//		System.out.println(Arrays.toString(a2));
//		List<Integer> list = toList(a2); 
//		trimNegatives(list);
//		System.out.println(Arrays.toString(list.toArray()));
//		
//		//testMerge adjcent
//		sumAdjcentPairs(list);
//		System.out.println(Arrays.toString(list.toArray()));
//		
//		//testFindMax
//		System.out.println(findMax(list));
//		
//		List<Integer> list2 = toList(a);
//		System.out.println(Arrays.toString(list2.toArray()));
//		mergeAdjectsBySign(list2);
//		System.out.println(Arrays.toString(list2.toArray()));
		
	}
	
	public static int getMaxSequence3(int[] arr){
		int max = 0;
		int localMax = 0;
		for(int i = 0; i <arr.length; i++){
			localMax += arr[i];
			max = Math.max(localMax, max);
			if(localMax < 0){
				localMax = 0;
			}
		}
		return max;
	}
	
	public static int getMaxSequence2(int[] arr){
		int max = Integer.MIN_VALUE;
		int localMax = 0;
		int i = 0;
		while(i<arr.length){
			if(arr[i] < 0){
				i++;
			}
			else{ //first positive int is found
				while(localMax >= 0){
					localMax += arr[i];
					if(arr[i] > 0){
						max = Math.max(max, localMax);
					}
					i++;
					if(i >= arr.length){
						break;
					}
				}
				localMax=0;
			}
		}
		return max;
	}
	
	
	public static int getMaxSequence(int[] arr){
		List<Integer> list = toList(arr);
		trimNegatives(list);
		int max = arr[0];
		while(list.size() > 1){
			mergeAdjectsBySign(list);
			max = Math.max(max, findMax(list));
			sumAdjcentPairs(list);
			trimNegatives(list);
		}
		return Math.max(max, list.get(0));
	}

	private static void mergeAdjectsBySign(List<Integer> list){
		int i = 0;
		while(i<list.size()-1){
			int first = list.get(i);
			int second = list.get(i+1);
			if((first < 0 && second < 0) || (first > 0 && second > 0)){
				list.set(i, first+second);
				list.remove(i+1);
			}else{
				i++;
			}
		}
	}
	private static int findMax(List<Integer> list){
		int max = Integer.MIN_VALUE;
		for(Integer i : list){
			max = Math.max(max, i);
		}
		return max;
	}
	
	private static void sumAdjcentPairs(List<Integer> list){
		for(int i = 0; i < list.size()-1;i++){
			list.set(i, list.get(i) + list.get(i+1));
			list.remove(i+1);
		}
	}
	private static List<Integer> toList(int[] arr){
		List<Integer> list = new ArrayList<>();
		for(int i : arr){
			list.add(i);
		}
		return list;
	}
	
	private static void trimNegatives(List<Integer> list){
		//trim left side
		while(list.get(0)<0){
			list.remove(0);
		}
		//trim the right side
		while(list.get(list.size()-1) < 0){
			list.remove(list.size()-1);
		}
	}
	
	public static int getMaxSum(int[] a) {
		int maxSum = 0;
		int runningSum = 0;
		for (int i = 0; i < a.length; i++) {
			runningSum += a[i];
			if (maxSum < runningSum) {
				maxSum = runningSum;
			} else if (runningSum < 0) {
				runningSum = 0;
			}
		}
		return maxSum;
	}
	
}
