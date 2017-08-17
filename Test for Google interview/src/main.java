import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class main {
	//ARRAYS
	private static String[] arr1 = {"al", "big", "a"};
	private static String[] empty_arr = {};
	private static String[] arr2 = {"The", "quick", "brown", "fox", "jump", "over", "jumpover", "the", "lazy", "dog", "back"};
	private static String str = "ThequickbrownfoxjumpoverthelazydogH";
	
	
	public static void main(String[] args){
		
		
//		System.out.println("biga: " + splitText("biga", arr1));
////		System.out.println("empty_arr: " + splitText("biga", empty_arr));
//		System.out.println("the fox: " + splitText(str, arr2));

		String[] arr = new String[100];
		 
		for(int i=0; i< 100; i++){
			arr[i] = getSaltString();
		}		
		
		String[] bigArr = concat(arr, arr2); 
		
		long startTime;
		long endTime;
		long duration;
		String result = "";
		
//		startTime = System.nanoTime();
//		for (int i = 0; i < 1000000; i++) {
//			result = splitText(str, bigArr);
//		}
//		endTime = System.nanoTime();
//		duration = endTime - startTime;
//		System.out.println("splitText Seconds  " + ((double) duration) / 1E9 + "  : " + result);
		
		
		startTime = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			result = splitText2(str, bigArr);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("splitText2 Seconds  " + ((double) duration) / 1E9 + "  : " + result);	
		
		startTime = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			result = splitText3(str, bigArr);
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("splitText3 Seconds  " + ((double) duration) / 1E9 + "  : " + result);	
		
	}
	
	private static String splitText3(String str, String[] dic) {
		//null checking
		
		Set<String> sortedDicSet = new TreeSet<String>(Arrays.asList(dic));
		StringBuilder result = new StringBuilder();
		
		
		for(int i = 0; i < str.length(); i++){
			String word = Character.toString(str.charAt(i));
			while(!sortedDicSet.contains(word) && i < str.length() -1){
				i++;
				word += str.charAt(i);
			}
			
			//We assume word was found
			result.append(word);
			if(i<str.length()){
				result.append(" ");
			}
		}
		
		return result.toString();
	}

	public static String[] concat(String[] a, String[] b) {
		   int aLen = a.length;
		   int bLen = b.length;
		   String[] c= new String[aLen+bLen];
		   System.arraycopy(a, 0, c, 0, aLen);
		   System.arraycopy(b, 0, c, aLen, bLen);
		   return c;
		}
	
	private static String splitText(String str, String[] dic){
		if(str == null || str.length() <= 1){
			return str;
		}
		
		if( dic == null || dic.length == 0){
			throw new IllegalArgumentException("dictionary is empty");
		}
		
		StringBuilder spacedStr = new StringBuilder();
		
		for(int i=0; i < str.length(); i++){ //num of words *
			char lookupChar = str.charAt(i);
			for(int j = 0; j < str.length(); j++){ //Go over the words in the dic
				boolean wordFound = false;
				String word = dic[j];
				if(word.charAt(0) == lookupChar){
					for(int k=1; k<word.length() && k+i < str.length(); k++ ){
						char nextChar = str.charAt(k+i);
						if(nextChar != word.charAt(k)){
							break; // breaks and goes to the next word
						}
						if(k == word.length()-1){
							spacedStr.append(word).append(" ");
//							System.out.println("word found: " + word);
							wordFound = true;
						}
					}
					if(word.length() == 1){
						spacedStr.append(word).append(" ");
//						System.out.println("word found: " + word);
						wordFound = true;
					}
					if(wordFound){
						i += word.length() -1;
						break;
					}
				}
			}
		}
		spacedStr.delete(spacedStr.length()-1, spacedStr.length());
		return spacedStr.toString();
	}
	
	private static String splitText2(String str, String[] dic){
		
		//VALIDATIONS
		int length = str.length();
		if(str == null || length <= 1){
			return str;
		}
		if( dic == null || dic.length == 0){
			throw new IllegalArgumentException("dictionary is empty");
		}
		
		String[] sortedDic = dic.clone();
		Arrays.sort(sortedDic); //nlog(n) of dic

		StringBuilder result = new StringBuilder();
		String tempWord = "";
		for(int i = 0; i < length; i++){
			tempWord = Character.toString(str.charAt(i));
			while(Arrays.binarySearch(sortedDic, tempWord) < 0 && i < (length - 1)){
				i++;
				if(i>= length){
					System.out.println("reon");
				}
				tempWord += str.charAt(i);
			}
			result.append(tempWord);
			if(i != length){
				result.append(" ");
			}
			
		}
		return result.toString();
	}
	
	static protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZYabcdefghijklmopqrsuvqxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        int stringLength = rnd.nextInt(12)+1; 
        while (salt.length() < stringLength) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	

}
