package eulerEx;

/**
 * The sum of the squares of the first ten natural numbers is,

1^2 + 2^2 + ... + 10^2 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)^2 = 55^2 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * @author orenegauthier
 *
 */
public class ex6 {
	
	public static void main(String[] args){
		int n = 100;
		System.out.println(getSumOfSquares(n));
	}

	private static long getSumOfSquares(int n) {
		if(n <0){
			throw new IllegalArgumentException("input must be positive");
		}
		int sumOfSq = 0;
		
		for(int i = 1; i <= n; i++ ){
			sumOfSq += i*i;
		}
		int sqOfSum = 0;
		
		for(int i = 0; i <=n; i++){
			sqOfSum += i;
		}
		sqOfSum = sqOfSum*sqOfSum;
		
		return sqOfSum - sumOfSq;
		
	}
	
	
}


