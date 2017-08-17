package crackingTheCodeInterview.searchAlgos;


public class ex10_3 {

	public static void main(String[] args) {
//		//           0,1,2,3,4,5,6,7,8
		int[] arr = {6,7,8,9,1,2,3,4,5};
		int[] arr2 ={6,7,8,9,1};
		int[] arr3 ={2,2,3,4,2};
		int[] arr4 ={1,2,3,4,0};
		int[] arr5 ={3,4,5,1,2};
		int[] arr6 ={5,2,3,4,4};
		int[] arr7 ={2,2,3,4,5};
		int[] arr8 ={2,2,3,4,4};
		int[] arr9 ={3,3,3,4,2};
		int[] arr10 ={2,2,2,3,4,2};
		System.out.println(biSearch2(arr , 8));
		System.out.println(biSearch2(arr2, 9));
		System.out.println(biSearch2(arr3, 4));
		System.out.println(biSearch2(arr4, 4));
		System.out.println(biSearch2(arr5, 4));
		System.out.println(biSearch2(arr6, 5));
		System.out.println(biSearch2(arr7, 5));
		System.out.println(biSearch2(arr8, 2));
		System.out.println(biSearch2(arr9, 2));
		System.out.println(biSearch2(arr10, 4));

	}
	
	public static int biSearch2(int[] arr, int x){
		return biSearch2(arr, x, 0, arr.length-1);
	}
	
	private static int biSearch2(int[] arr, int x, int left, int right){
		int mid = (left+right)/2;
		if(arr[mid] == x){
			return mid;
		}
		if((left>right)){
			return -1;
		}
		
		if(x > arr[mid]){ //can be on either side x=5 and {5,2,3,4,4} OR {2,2,3,4,5}
			if(arr[left] <= arr[mid]){ //left is in order so it must be on the right {2,2,3,4,5} 
				return biSearch2(arr, x, mid+1, right); //search right
			}
			else{ // right is in order - still can be on either side x=5 and {5,2,3,4,4} OR {2,2,3,4,5}
				if(x<=arr[right]){ //must be right {2,2,3,4,5}
					return 	biSearch2(arr, x, mid+1, right);
				}
				else{
					return biSearch2(arr, x, left, mid-1); //search left
				}
			}
		}
		else{ // still can be on either side
			if(arr[right] >= arr[mid]){// right is in order must be left
				return biSearch2(arr, x, left, mid-1); //search left
			}
			else{ // left is in order - still can be on either side x=2 and {2,2,3,4,4} OR {3,3,3,4,2}
				if(x>=arr[left]){
					return biSearch2(arr, x, left, mid-1); //search left
				}
				else{
					return biSearch2(arr, x, mid+1, right); //search right	
				}
			}
		}
	}
	
	public static int biSearch(int[] arr, int x){
		return biSearch(arr, x, 0, arr.length-1);
	}
	
	private static int biSearch(int[] arr, int x, int left, int right){
		int mid = (left+right)/2;
		if(arr[mid] == x){
			return mid;
		}
		if((left>right)){
			return -1;
		}
		
		if(x < arr[mid]){
				return biSearch(arr, x, left, mid-1);  //search left
		}
		else{
			return biSearch(arr,x,mid+1,right); //search right
		}
	}
}
