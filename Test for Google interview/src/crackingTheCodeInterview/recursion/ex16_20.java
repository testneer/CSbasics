package crackingTheCodeInterview.recursion;

import java.util.*;

public class ex16_20 {

	public static void main(String[] args) {
//		testRecursion();
		Trie t = new MockTrie();
		String digits = "432";
		System.out.println(Arrays.toString(getPerdictions(digits, t).toArray()));
	}
	
	
	static List<String> getPerdictions(String digits, Trie trie){
		List<String> list = new ArrayList<>();
		Map<Integer, char[]> d2c = getD2cMap();
		getPredictions(digits, 0, d2c, "", trie, list );
		
		return list;
	}
	
	private static void getPredictions(String digits, int dIndex, Map<Integer, char[]> d2c, String word, Trie trie, List<String> matches) {
		
		if(!trie.isPrefixValid(word)){
			System.out.println(word);
			return;
		}
		if(dIndex==digits.length()){
			if(trie.contains(word)){
				matches.add(word);
			}
			return;
		}
		
		int digit = Character.getNumericValue(digits.charAt(dIndex));
		char[] chars = d2c.get(digit);
		
		for(char c : chars){
			getPredictions(digits, dIndex+1, d2c, word+c, trie, matches);
		}
		
	}


	private static Map<Integer, char[]> getD2cMap() {
		Map<Integer, char[]> d2c = new HashMap<>();
		d2c.put(1, new char[]{});
		d2c.put(2, new char[]{'a','b','c'});
		d2c.put(3, new char[]{'d','e','f'});
		d2c.put(4, new char[]{'g','h','i'});
		return d2c;
	}

	public interface Trie{
		public boolean isPrefixValid(String s);
		public boolean contains(String s);
		public TrieNode getPrefixLastNode(String s);
		
	}
	
	public class TrieNode{
		TrieNode[] children;
		char value;
		
		public TrieNode(char value, TrieNode[] children){
			this.value = value;
			this.children = children;
		}
		
	}
	public class TrieNodeEnd extends TrieNode{
		
		public TrieNodeEnd() {
			super(Character.MIN_VALUE,null);
		}
	}
	
	static class MockTrie implements Trie{

		@Override
		public boolean isPrefixValid(String s) {
			if("i".equals(s) || "id".equals(s) || "ida".equals(s) ||"h".equals(s) || "he".equals(s) || "heb".equals(s) || "".equals(s)){
				return true;
			}
			return false;
		}

		@Override
		public boolean contains(String s) {
			if("ida".equals(s) || "heb".equals(s)){
				return true;
			}
			return false;
		}

		@Override
		public TrieNode getPrefixLastNode(String s) {
			return null;
		}
	}
 
	
	static void testRecursion(){
		int[] numbers = {1,2,3};
		char chars[][] = {{'a','b','c'},{'d','e','f'},{'g','h','i'}};
		
		rec(numbers, 3, chars,"");
		
	}


	private static void rec(int[] num, int ni, char[][] chars, String word) {
		if(ni == 0){
			System.out.println(word);
			return;
		}
		int digit = num[ni-1];
		char[]  cod = chars[digit-1];
		
		rec(num, ni-1, chars,word+cod[2]);
		rec(num, ni-1, chars,word+cod[1]);
		rec(num, ni-1, chars,word+cod[0]);
	}
	
	private static void rec3(int[] num, int ni, char[][] chars, String word) {
		if(ni == 3){
			System.out.println(word);
			return;
		}
		int digit = num[ni];
		char[]  cod = chars[digit-1];
		for(int i = 0; i<cod.length; i++){
			char c = cod[i];
			rec(num, ni+1, chars,word+c);
		}
	}
	
	private static void rec2m(int[] num, int ni, char[][] chars, String word) {
		if(ni == 3){
		System.out.println(word);
		return;
		}
		for(int i = 0; i<chars.length; i++){
			char c = chars[num[ni]-1][i];
			rec2m(num, ni+1, chars, word+c);
		}
	}
}
