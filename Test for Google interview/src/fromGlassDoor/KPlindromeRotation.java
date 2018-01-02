package fromGlassDoor;

public class KPlindromeRotation {
	public static void main(String[] args) {
		System.out.println(getCharIndex('a'));
		System.out.println(getCharIndex('C'));
		System.out.println(getCharIndex('0'));
		System.out.println(getCharIndex('z'));
		System.out.println(getCharIndex('Z'));
		System.out.println(getCharIndex('9'));
	}
	
	static int getCharIndex(char c){
		if(c<='z' && c>='a'){
			return c-'a';
		}
		else if(c<='Z' && c>='A'){
			return 26+c-'A';
		}
		else if(c<='9' && c>='0'){
			return 52+c-'0';
		}
		else{
			return -1;
		}
	}
	
//	static isKPalindrome(bla bla)
}
