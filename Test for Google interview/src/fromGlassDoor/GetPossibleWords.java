package fromGlassDoor;

import java.util.ArrayList;

public class GetPossibleWords {
	public static void main(String[] args) {
		System.out.println(getCharValue(1));
		System.out.println(getCharValue(20));
		System.out.println(getWords("11111111111111111111111111111111"));
	}
	
	static char getCharValue(int num){
		return (char) (((int)'a')-1+num);
	}
	
	static ArrayList<String> getWords(String str){
		if(str == null || str.isEmpty()){
			throw new IllegalArgumentException("invalid input");
		}
		ArrayList<String> result = new ArrayList<>();
		getWords(str, "", result);
		return result;
		
	}
	
	static void getWords(String str, String currentString, ArrayList<String> result){
		if(str.isEmpty()){
			if(str != ""){
				result.add(currentString);
				return;
			}
		}
		if(str.length() == 1){
			result.add(currentString+getCharValue(Integer.valueOf(str)));
			return;
		}
		
		int num = Integer.valueOf(str.substring(0,2));
		if(num > 26){
			getWords(str.substring(2, str.length()), currentString + getCharValue(num/10) + getCharValue(num%10), result);
		}
		else if(num%10 == 0){
			getWords(str.substring(2, str.length()), currentString+getCharValue(num), result);
		}
		else{
			getWords(str.substring(1, str.length()), currentString+getCharValue(num/10), result);
			getWords(str.substring(2, str.length()), currentString+getCharValue(num), result);
		}
		return;
	}
}
