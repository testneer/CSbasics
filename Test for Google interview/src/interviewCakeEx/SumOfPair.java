package interviewCakeEx;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Ex From https://www.youtube.com/watch?v=XKu_SEDAykw
 * 
 * @author orenegauthier
 *
 */
public class SumOfPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(containsPairOfSum1(new int[] {1, 1, 2, 4}, 2));
	}
	
	/*
	 * good for sorted input
	 */
	private static boolean containsPairOfSum(int[] arr, int sum){
		if(arr == null || arr.length < 2){
			throw new IllegalArgumentException("Arr is null or length smaller than 2");
		}
		
		int smallIndex = 0;
		int largeIndex = arr.length-1;
		
		while(smallIndex < largeIndex){
			int currentSum = arr[smallIndex] + arr[largeIndex];
			
			if(currentSum == sum){
				return true;
			}
			else if (currentSum < sum){
				smallIndex++;
			}
			else{
				largeIndex --;
			}
		}
		return false;
	}
	
	private static boolean containsPairOfSum1(int[] arr, int sum){
		Set<Integer> set = new HashSet<>();
		
		for(int i =0; i < arr.length; i++){
			if(set.contains(arr[i])){
				return true;
			}
			else {
				set.add(sum-arr[i]);
			}
		}
		return false;
	}
}
