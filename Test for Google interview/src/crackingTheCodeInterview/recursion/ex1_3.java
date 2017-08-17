package crackingTheCodeInterview.recursion;

import java.util.Arrays;

public class ex1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = new char[50];
		arr[0] = 'a';
		arr[1] = ' ';
		System.out.println("=="+' '+"==");
		arr[2] = 'b';
		arr[3] = 'c';
		arr[4] = ' ';
		arr[5] = 'b';
		System.out.println(Arrays.toString(arr));
		URLify(arr, 6);
		System.out.println(Arrays.toString(arr));
		
	}
	
	static void URLify(char[] arr, int length){
		char whiteSpace = ' ';
		int whiteSpaceCounter = 0;
		for(int i = 0; i < length; i++){
			if(arr[i] == whiteSpace){
				whiteSpaceCounter ++;
			}
		}
		if(whiteSpaceCounter == 0){
			return;
		}
		
		int sourceIndex = length-1;
		int destIndex = sourceIndex + whiteSpaceCounter*2;
		
		while(sourceIndex >=0){
			char source = arr[sourceIndex];
			if(source == whiteSpace){
				arr[destIndex] = '0';
				arr[--destIndex] = '2';
				arr[--destIndex] = '%';
			}
			else{
				arr[destIndex] = arr[sourceIndex];
			}
			sourceIndex --;
			destIndex--;
		}
	}

}
