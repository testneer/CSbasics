package crackingTheCodeInterview.recursion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex16_2 {

	public static void main(String[] args) throws FileNotFoundException {
		String path = "/Users/orenegauthier/Desktop/book.txt";
		Map<String, Integer> map = countOccurences(path);
		for(String key : map.keySet()){
			System.out.print(key + ":" + map.get(key) + " ");
		}
		
	}
	
	public static Map<String, Integer> countOccurences(String path) throws FileNotFoundException{
		Scanner scanner = new Scanner(new FileInputStream(path));
		Map<String, Integer> map = new HashMap<>();
		while(scanner.hasNext()){
			String word = scanner.next().toLowerCase().replaceAll("[^A-Za-z]", "");
			if(!word.isEmpty()){
				Integer occurences = map.get(word);
				if(occurences == null){
					occurences = new Integer(1);
				}else{
					occurences = new Integer(occurences.intValue()+1);
				}
				map.put(word, occurences);	
			}
			
		}
		scanner.close();
		return map;
	}

}
