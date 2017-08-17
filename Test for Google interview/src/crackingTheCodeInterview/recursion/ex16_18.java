package crackingTheCodeInterview.recursion;

import java.util.*;

//pull request
public class ex16_18 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(getAllpossibleLengths(0, 2, 14).toArray()));
		String value = "catcatgogo";
		String pattern = "bb";
		Pair p = new Pair(3, 2);
		System.out.println(isPatternMatching(pattern, value));
		String a = "a";
		System.out.println(a.substring(0,1));
	}
	
	public static boolean isPatternMatching(String pattern, String value){
		
		if(pattern == null || value == null || pattern.length()>value.length()){
			throw new IllegalArgumentException();
		}
		
		List<Pair> possiblePairs;
		int aCount = 0;
		int bCount = 0;
		
		for(int i = 0; i < pattern.length(); i++){
			char c = pattern.charAt(i);
			if(c=='a'){
				aCount++;
			}
			else if (c == 'b'){
				bCount++;
			}
			else{
				throw new IllegalArgumentException();
			}
			
		}
		possiblePairs = getAllpossibleLengths(aCount, bCount, value.length());
		for(Pair p : possiblePairs){
			if(patternMatches(pattern, value, p)){
				return true;
			}
		}
		return false;
	}

	public static boolean patternMatches(String pattern, String value, Pair p){
		String a = null;
		String b = null;
		int startIndex = 0;
		for(int i = 0; i < pattern.length(); i++){
			char c = pattern.charAt(i);
			if('a'==c){
				String temp = value.substring(startIndex, startIndex+p.a);
				if(a==null){
					a = temp;
				}
				if(!a.equals(temp)){
					return false;
				}
				startIndex += p.a;
			}
			else if('b'==c){
				String temp = value.substring(startIndex, startIndex+p.b);
				if(b==null){
					b = temp;
				}
				if(!b.equals(temp)){
					return false;
				}
				startIndex += p.b;
			}
		}
		return true;
	}

	static class Pair{
		int a;
		int b;
		public Pair(int aLength, int bLength) {
			this.a = aLength;
			this.b = bLength;
		}
		@Override
		public String toString() {
			return "("+a+","+b+")"; 
		}
	}
	
	private static List<Pair> getAllpossibleLengths(int aCount, int bCount, int sum){
		List<Pair> possibleLengths = new ArrayList<>();
		if(aCount == 0 && (sum%bCount == 0)){
			possibleLengths.add(new Pair(0,sum/bCount));
			return possibleLengths;
		}
		if(bCount == 0 && (sum%aCount) == 0){
			possibleLengths.add(new Pair(sum/aCount,0));
			return possibleLengths;
		}
		int aLength = 1;
		while(true){
			int temp = sum-(aLength*aCount);
			if(temp%bCount == 0){
				possibleLengths.add(new Pair(aLength, temp/bCount));
			}
			aLength++;
		
			if(bCount >= temp){
				break;
			}
		}
		return possibleLengths;
	}
}
