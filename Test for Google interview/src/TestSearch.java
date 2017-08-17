import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestSearch {

	private static String[] arr2 = {"The", "quick", "H", "brown", "fox", "jump", "over", "the", "lazy", "dog", "back", "a", "b", "c"};
	
	public static void main(String[] args) {
		String[] arr = new String[100000];
		 
		for(int i=0; i< 100000; i++){
			arr[i] = getSaltString();
		}
		arr[0] = "The";
		Set<String> dicSet = new TreeSet<String>(Arrays.asList(arr));
		Collection<String> words = new ArrayList<>(Arrays.asList(arr2));
				
		
		long startTime;
		long endTime;
		long duration;
		String result = "";
		
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			result = searchLoop(arr2, arr);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("splitText Seconds  " + ((double) duration) / 1E9 + "  : " + result);
		
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			result = searchSorted(arr2, arr);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("splitText Seconds  " + ((double) duration) / 1E9 + "  : " + result);
		
		startTime = System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			result = searchSet(words, dicSet);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("searchSet Seconds  " + ((double) duration) / 1E9 + "  : " + result);

	}


	private static String searchSet(Collection<String> words, Set<String> dicSet) {
		StringBuilder result = new StringBuilder();
		for(String word: words){
			if(dicSet.contains(word)){
				result.append(word);
			}
		}
		return result.toString();
	}


	private static String searchSorted(String[] words, String[] dic) {
		StringBuilder result = new StringBuilder();
		Arrays.sort(dic);
		int wordFoundIndex = -1;
		for(int i = 0; i < words.length; i++){
			wordFoundIndex = Arrays.binarySearch(dic, words[i]);
			if(wordFoundIndex >= 0){
				result.append(words[i]);	
			}
		}
		return result.toString();
	}



	private static String searchLoop(String[] words, String[] dic) {
		StringBuilder result = new StringBuilder();
		for(int i = 0;i < words.length; i++)
		{
			for(int j =0; j < dic.length; j ++){
				if(words[i] == dic[j]){
					result.append(words[i]).append(" ");
				}
			}
		}
		return result.toString();
	}



	static protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZYabcdefghijklmopqrsuvqxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        int stringLength = rnd.nextInt(5)+1; 
        while (salt.length() < stringLength) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

}
