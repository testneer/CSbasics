package fromGlassDoor;

import java.util.Arrays;

public class rotateArray {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		rotateArrayLeft(arr, 8);
		System.err.println(Arrays.toString(arr));
	}
	
	static void rotateArrayLeft(int[] arr, int k){
		if(arr == null || arr.length == 0){
			throw new IllegalArgumentException("Dude - get real");
		}
		int length = arr.length;
		if (k>=length){
			k = k%length;
		}
		
		int sets = gcd(length, k);
		int tempVal;
		
		for(int i = 0; i < sets; i++){ //outer loop for num of sets
			int sourceIndex = i+k;
			int desIndex = i;
			tempVal = arr[i];
			while(sourceIndex != i){
				arr[desIndex] = arr[sourceIndex];
				desIndex = (desIndex+k) % length;
				sourceIndex = (sourceIndex+k) % length;
			}
			arr[desIndex] = tempVal;
		}
	}

	private static int gcd(int a, int b) {
		if(b == 0){
			return a;
		}
		return gcd(b, a%b);
	}
}
