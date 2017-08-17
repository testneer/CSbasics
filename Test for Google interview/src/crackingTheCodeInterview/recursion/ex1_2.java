package crackingTheCodeInterview.recursion;

import java.util.Arrays;

public class ex1_2 {

	public static void main(String[] args) {
		String first = "oren";
		String second = "nreo";
		System.out.println(checkPermutation(first, second));
		System.out.println(checkPermutation2(first, second));
		String a = "oren";
		System.out.println(a == first);
		System.out.println(a.equals(first));
		int[] ore = {1,2,3};
		int oren[] = {1,2,4};
		System.out.println(ore + " " + oren);
		

	}
	
	static boolean checkPermutation(String first, String second){
		if(first == null || second == null){
			throw new IllegalArgumentException("String can't be null");
		}
		if(first.length() != second.length()){
			return false;
		}
		
		int[] charCounter = new int[128];
		
		for(int i = 0; i < first.length(); i++){
			int fCharIndex = (int)first.charAt(i);
			int sCharIndex = (int)second.charAt(i);
			
			charCounter[fCharIndex] = charCounter[fCharIndex] + 1;
			charCounter[sCharIndex] = charCounter[sCharIndex] - 1;
		}
		for(int i = 0; i < charCounter.length; i++){
			if(charCounter[i] != 0){
				return false;
			}
		}
		return true;
	}
	
	static boolean checkPermutation2(String first, String second){
		char[] firstSorted = first.toCharArray();
		Arrays.sort(firstSorted);
		char[] secondSorted = second.toCharArray();
		Arrays.sort(secondSorted);
		
		return Arrays.equals(firstSorted, secondSorted);
	}


}
