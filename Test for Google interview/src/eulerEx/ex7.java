package eulerEx;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
 * @author orenegauthier
 *
 */
public class ex7 {
	public static void main (String[] args){
		int num = 10;
//		System.out.println( getPrimesToNum(num));
		System.out.println(isPrime(1));
		long result = 0;
		int count = 0;
		int loopCount = 2;
		while(result == 0){
			if(isPrime(loopCount)){
				System.out.println(loopCount);
				count++;
			}
			if(count == 10001){
				result = loopCount;
			}
			loopCount++;
		}
		System.out.println(result);
	}

//	private static int getPrimesToNum(int num) {
//		for(int i = 0; i < num; i++){
//			if()
//			System.out.println();
//		}
//		return 0;
//	}
	
	//checks whether an int is prime or not.
//	static boolean isPrime(int n) {
//	    for(int i=2;i*i<n;i++) {
//	        if(n%i==0)
//	        	System.out.println(i);
//	    }
//	    return true;
//	}
	
	
	//checks whether an int is prime or not.
	static boolean isPrime(int n) {
		if(n == 2){
			return true;
		}
	    //check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	
}
