package fromGlassDoor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Test if it's possible to break up a sequence of characters into several known words.  
//OR
//Given an input string and a dictionary of words, implement a method that breaks up the input string into a space-separated 
//string of dictionary words that a search engine might use for "Did you mean?" For example, an input of "applepie" 
//should yield an output of "apple pie".
//https://stackoverflow.com/questions/7195941/breaking-a-string-apart-into-a-sequence-of-words

public class CharSequenceToKonwnWords {

	public static void main(String[] args) {
		Set<String> dic = new HashSet<>();
		dic.add("a");
		dic.add("ba");
		dic.add("c");
		dic.add("c");
//		dic.add("aba");
		dic.add("adorable");
//		System.out.println(new String(new char[]{'a','d'}, 0, 1));
		System.out.println("result: "+wordExists("abaa".toCharArray(), dic));
		System.out.println("SegmentString() " + segmentString("abaa", dic)); 
	}
	
//	Solution from http://thenoisychannel.com/2011/08/08/retiring-a-great-interview-problem
	static String segmentString(String input, Set<String> dict) {
		  if (dict.contains(input)) return input;
		  int len = input.length();
		  for (int i = 1; i < len; i++) {
		    String prefix = input.substring(0, i);
		    if (dict.contains(prefix)) {
		      String suffix = input.substring(i, len);
		      String segSuffix = segmentString(suffix, dict);
		      if (segSuffix != null) {
		        return prefix + " " + segSuffix;
		      }
		    }
		  }
		  return null;
		}
	
	
	static String wordExists(char[] chars, Set<String> dic){
		List<String> result = new ArrayList<String>();
		wordExists(chars, 0, chars.length-1, dic);
		return Arrays.toString(result.toArray());
	}
	
	static String wordExists(char[] chars, int left, int right, Set<String> dic){
		String word = new String(chars, left, right-left+1);
		if(dic.contains(word)){
			System.out.println(word);
			return word;
		}
//		if(left>=right){
//			return;
//		}
		for(int i = left; i < right; i++){
			wordExists(chars, left, i, dic);
			wordExists(chars, i+1, right, dic);
		}
		return null;
	}
}	
