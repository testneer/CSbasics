package crackingTheCodeInterview.recursion;


public class ex16_5 {

	public static void main(String[] args) {
		long n =  25; 
		System.out.println(getTrailingZeroForFactorial(n));
		System.out.println(getTrailingZeroForFactorial3(n));
		System.out.println(getTrailingZeroForFactorial4(n));
//		long fact = 1;
//		for (long i = 1; i <= n; i++) {
//			fact *=i;
//		}
//		System.out.println(fact);
	}
	
	public static int getTrailingZeroForFactorial4(long n){ //per book
		int count = 0;
		for(int i = 5; i <= n; i*=5){
			count += n/i;
		}
		return count;
	}
	public static int getTrailingZeroForFactorial3(long n){ //per book
		int total = 0;
		for (int i = 2; i <= n; i++) {
			total+= getFactorsOf5Count(i);
		}
		return total;
	}
	
	static int getFactorsOf5Count(long n){
		int count = 0;
		while(n%5 == 0){
			count++;
			n /=5;
		}
		return count;
	}
		
	public static int getTrailingZeroForFactorial(long n){ //wrong
		if(n < 2){
			return 0;
		}
		int zeroCount = 0;
		int totalSum = 1;
		int internalMulti = 2;
		
		for (int i = 2; i <= n; i++) {
			if(internalMulti == 10){
				internalMulti /= 10;
				zeroCount++;
			}
			
			totalSum *= internalMulti;
			
			if(totalSum %10 == 0){
				zeroCount++;
				totalSum /= 10;
			}
			else if (totalSum > 10){
				totalSum %= 10;
			}
			internalMulti++;
		}
		return zeroCount;
	}
}
