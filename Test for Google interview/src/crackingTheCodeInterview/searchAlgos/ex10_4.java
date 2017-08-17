package crackingTheCodeInterview.searchAlgos;

import java.util.Arrays;

public class ex10_4 {
	public static void main(String[] args) {
		int element = 7;
		int[] listy = {3,4,5,6,7,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};
		int[] listy2 = {3,4,5,6,7};
		System.out.println(Arrays.binarySearch(listy2, element));
		System.out.println(Arrays.toString(listy));
		System.out.println(getListyIndex(listy, element));
	}
	
	public static int getListyIndex(int[] listy, int x){
		
		//find List size
		int end = 1;
		while(listy[end] != -1 && listy[end] < x){
			end*=2;
		}
		
		int size = end;
		if(listy[end] == -1){
			int start = end/2;
			while(start<end){
				int mid = (start+end)/2;
				if(listy[mid] == -1){ //search left
					end = mid-1;
				}
				else{
					start = mid+1;
				}
			}
			size = start+1;
		}
		
		return biSearch(listy, x, 0, size);
		
	}

	private static int biSearch(int[] listy, int x, int low, int high) {
		while(low<=high){
			int mid = (low+high)/2;
			if(x > listy[mid] ){
				low = mid+1;
			}
			else if (x < listy[mid]){
				high=mid-1;
			}
			if(x == listy[mid]){
				return mid;
			}
		}
		return -1;
	}
}
