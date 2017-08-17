package crackingTheCodeInterview.recursion;

import java.util.Arrays;

public class ex6_0 {
	public static void main(String[] args) {
		System.out.println(isPrime(982451653));
		System.out.println(isPrimeSieve(982451653));
	}
	
	static boolean isPrime(int candidate){
		if(candidate < 2){
			return false;
		}
		
		if(candidate%2 == 0){
			return false;
		}
		
		else {
			for (int i = 3; i < Math.sqrt(candidate); i+=2){
				if(candidate % i == 0){
					return false;
				}
			}
			return true;
		}
	}
	
	static boolean isPrimeSieve(int candidate){
		int maxToCheck = (int) Math.sqrt(candidate)+1;
		boolean[] checkedNumbers = new boolean[maxToCheck];
		Arrays.fill(checkedNumbers, true);
		
		int intToCheck = 2;
		while (intToCheck<maxToCheck){
			System.out.println(intToCheck);
			if(candidate % intToCheck == 0){
				return false;
			}
			else{
				//mark multiples of that prime as non viable 
				for(int i = intToCheck; i < maxToCheck; i+=intToCheck){
					checkedNumbers[i] = false;
				}
			}
			//get the next prime
			int nextToCheck = intToCheck;
			for(int i = intToCheck+1; i<maxToCheck; i++){
				if(checkedNumbers[i]){
					nextToCheck = i;
					break;
				}
			}
			if(nextToCheck == intToCheck){
				return true;
			}else{
				intToCheck = nextToCheck;
			}
		}
		return true;
	}
}

