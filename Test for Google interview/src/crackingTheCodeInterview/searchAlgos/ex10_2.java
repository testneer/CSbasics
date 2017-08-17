package crackingTheCodeInterview.searchAlgos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

public class ex10_2 {
	
	public static class AnagramComparator implements Comparator<String>{
		
		public int compare(String s1, String s2){
			char[] s1Chars = s1.toCharArray();
			char[] s2Chars = s2.toCharArray();
			Arrays.sort(s1Chars);
			Arrays.sort(s2Chars);
			String s1Sorted = new String(s1Chars);
			String s2Sorted = new String(s2Chars);
			return s1Sorted.compareTo(s2Sorted);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isAnagram("qwerty","ytrewq"));
		System.out.println("a".compareTo("b"));

		String[] arr = {"dog", "aba", "aab", "god", "aa"};
		System.out.println(Arrays.toString(arr));
//		Arrays.sort(arr, new AnagramComparator());
		groupAnagrams(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	//Best Solution
	public static void groupAnagrams(String[] arr){
		//null check
		Map<String, List<String>> map = new HashMap<>();
		for(String s : arr){
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			List<String> anagramGroup = map.get(key);
			if(anagramGroup == null){
				anagramGroup = new ArrayList<String>();
			}
			anagramGroup.add(s);
			map.put(key, anagramGroup);
		}
		int index = 0;
		for(List<String> anagrams : map.values()){
			for(String s : anagrams){
				arr[index] = s;
				index++;
			}
		}
		
	}

	//Test Method
	private static boolean isAnagram(String a, String b){
		if(a.length() != b.length()){
			return false;
		}
		int[] lettersCount = new int[26];
		for(int i = 0; i < a.length(); i++){
			char c = a.charAt(i);
			lettersCount[c-'a']++;
			c = b.charAt(i);
			lettersCount[c-'a']--;
		}
		
		for(int i = 0; i < lettersCount.length; i++){
			if(lettersCount[i] != 0){
				return false;
			}
		}
		return true;
	}
}
