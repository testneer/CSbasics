package crackingTheCodeInterview.searchAlgos;

public class ex10_5 {

	public static void main(String[] args) {
		String[] arr1 = {"","james","","","koko"};
		System.out.println(sparseSearch(arr1, arr1[arr1.length-1]));
	}
	
	public static int sparseSearch(String[] arr, String item){
		int mid;
		int low = 0;
		int high = arr.length-1;
		while(low<=high){
			mid = (low+high)/2;
			int valueToLeft = getValueToLeft(arr, mid);
			String midStr = arr[valueToLeft];
			if(midStr.compareTo(item) > 0){
				high = mid -1;
			}
			else if(midStr.compareTo(item) < 0){
				low = mid+1;
			}
			else{
				return valueToLeft;
			}
		}
		return -1;
	}

	private static int getValueToLeft(String[] arr, int index) {
		
		while(index > 0 && arr[index] == ""){
			index--;
		}
		return index;
	}

}
