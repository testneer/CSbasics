package crackingTheCodeInterview.recursion;

//implementing binary search in recursion
public class ex8_0 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,8,11,12};
		int number = 10;
		System.out.println(binSearch(arr, 10));
		System.out.println(binSearch(arr, 9));
		System.out.println(binSearch(arr, 7));
		System.out.println(binSearch(arr, 0));
		System.out.println(binSearch(arr, 12));
		System.out.println(binSearch(arr, 8));
	}
	
	static boolean binSearch(int[] arr, int number){
		return binSearchRec(arr, number, 0, arr.length-1);
	}
	
	private static boolean binSearchRec(int[] arr, int number, int startIndex, int endIndex){
		
		//base case
		if(startIndex > endIndex){
			return false;
		}
		int middle = (startIndex+endIndex)/2;
		if(arr[middle] == number){
			return true;
		}
		else if(arr[middle] < number){
			return binSearchRec(arr, number,middle+1, endIndex);
		}
		else{
			return binSearchRec(arr, number,startIndex, middle-1);
		}
	}
}
