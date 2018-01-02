package crackingTheCodeInterview.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class ex1_1 {

	public static void main(String[] args) {
		int a = 'A';
		System.out.println("ire" + a);
		String str = "abcd";
		System.out.println(hasUniqueChars(str));
		System.out.println(hasUniqueCharsNoDs(str));
		System.out.println(hasUniqueCharsBitVector(str));
		int i = 0;
		System.out.println(1 << 4);
	}
	
	private static boolean hasUniqueChars(String str){
		if(str==null){
			throw new IllegalArgumentException("String can't be null");
		}
		Set<Character> set = new HashSet<>();
		for(int i = 0; i<str.length();i++){
			if(!set.add(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	
	private static boolean hasUniqueCharsNoDs(String str){
		boolean[] arr = new boolean[256];
		for(int i = 0; i< str.length(); i++){
			char c = str.charAt(i);
			if(arr[(int)c]){
				return false;
			}
			arr[(int)c] = true ;
		}
		return true;
	}
	
	private static boolean hasUniqueCharsBitVector(String str){
		int checker = 0;
		for(int i = 0; i < str.length(); i++){
			int val = (int)str.charAt(i);
			val = val - 'a';
			if((checker & 1 << val) > 0){
				return false;
			}
			else{
				checker |= 1 << val;
			}
		}
		return true;
	}


}
