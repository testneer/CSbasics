package eulerEx;


public class Ex4 {

	/**
	 * A palindromic number reads the same both ways. The largest palindrome made 
	 * from the product of two 2-digit numbers is 9009 = 91 × 99.
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 */
	
	public static void main(String[] args) {
		int one = -1;
		
		String str1 = Integer.toString(one);
		System.out.println(str1);
		
		System.out.println("is 1 a palindrome: " + isPalindrome(1));
		System.out.println("is 10 a palindrome: " + isPalindrome(10));
		System.out.println("is 90009 a palindrome: " + isPalindrome(90009));
		System.out.println("is 0 a palindrome: " + isPalindrome(0));
		System.out.println(findPalindrome());
	}
	
	
	static int findPalindrome(){
		int result = -1;
		for(int i = 999; i > 99; i--){
			for(int j = 999; j > 99; j--){
				int multiply = i*j;
				if(isPalindrome(multiply)){
					System.out.println(i + " " + j);
					result = Math.max(multiply, result);
				}
			}
		}
		return result;
	}
	
	private static boolean isPalindrome(int number){
		String numStr = Integer.toString(number);
		for (int i = 0; i < numStr.length()/2; i++){
			if(!(numStr.charAt(i) == numStr.charAt(numStr.length() - 1 - i))){
				return false;
			}
		}
		return true;
	}
}
