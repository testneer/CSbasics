package interviewCakeEx;

import java.util.Arrays;

public class ProductOfIntExceptIndex {

	public static void main(String[] args) {
		int[] small = {3,2,1};
		int[] small2 = {-3,6,0};
		int[] small3 = {2,3,4,6};
		int[] twoZeros = {-35,4,5,6,5,4,5,6,6,7,4,3,3,46,0,6,0};
		System.out.println(Arrays.toString(getProductOfAllindicesExceptIndex(small)));
		System.out.println(Arrays.toString(getProductOfAllindicesExceptIndex(small2)));
		System.out.println(Arrays.toString(getProductOfAllindicesExceptIndex(small3)));
		System.out.println(Arrays.toString(getProductOfAllindicesExceptIndex(twoZeros)));

	}
	
	
	static int[] getProductOfAllindicesExceptIndex(int[] arr){
		if(arr==null || arr.length == 0){
			throw new IllegalArgumentException("arr null or empty");
		}
		
		int[] res = new int[arr.length];
		if(arr.length == 1){
			res[0] = arr[0];
			return res;
		}
		res[0] = 1;
		for(int i = 1; i < arr.length; i++){
			res[i] = arr[i-1] * res[i-1];
		}
		int temp = arr[arr.length-1];
		for(int i = arr.length -2; i >= 0; i--){
			res[i] = res[i] * temp;
			temp = temp*arr[i];
		}
		return res;
	}
}
