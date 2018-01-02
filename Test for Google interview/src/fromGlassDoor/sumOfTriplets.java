package fromGlassDoor;

import java.util.Arrays;

public class sumOfTriplets {
	public static void main(String[] args) {
		System.out.println(containsSumOfTriplet(new int[]{1, 2,3}, 5));
		System.out.println("---------------");
		System.out.println(containsSumOfTriplet(new int[]{2,3,-1,0,4,7,-2}, 5));
		System.out.println("---------------");
		System.out.println(containsSumOfTriplet(new int[]{2,3,4,4,2}, 8));	}
	
	
	static boolean containsSumOfTriplet(int[] arr, int sum){
		if(arr == null || arr.length < 3){
			throw new IllegalArgumentException("invalid input");
		}
		
		Arrays.sort(arr);
		for(int i = 0; i < arr.length-2; i++){
			if(containsSumOfPair(arr, i+1, sum-arr[i])){
				return true;
			}
		}
		return false;
	}


	static boolean containsSumOfPair(int[] arr, int startIndex, int sum) {
		int left = startIndex;
		int right = arr.length -1;
		
		while(left<right){
			int tempSum = arr[left]+arr[right];
			if(tempSum == sum){
				System.out.println(arr[left] + " " + arr[right] + " " + arr[startIndex]);
				return true;
			}
			if(tempSum < sum){
				left++;
			}
			else{
				right--;
			}
		}
		return false;
	}
}
