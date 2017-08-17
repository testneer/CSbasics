package interviewCakeEx;

import java.util.Arrays;

/**
 * Your quirky boss collects rare, old coins...
They found out you're a programmer and asked you to solve something they've been wondering for a long time.

Write a function that, given:

an amount of money
a list of coin denominations
computes the number of ways to make the amount of money with coins of the available denominations.

Example: for amount=4 (4¢) and denominations=[1,2,3] (1¢, 2¢ and 3¢), your program would output 4—the number of ways to make 4¢ with those denominations:

1¢, 1¢, 1¢, 1¢
1¢, 1¢, 2¢
1¢, 3¢
2¢, 2¢
 * @author orenegauthier
 *
 */
public class CoinDenomination {

	
	public static void main(String[] args) {
		System.out.println(countWaysToMakeAmount(2, new int[] {1,2}));
	}
	
	public static int countWaysToMakeAmount(int amount, int[]denoms){
		return countWaysToMakeAmount(amount, denoms, 0);
	}
	
	public static int countWaysToMakeAmount(int amountLeft, int[] denominations, int currentIndex){
		
		//Base case
		if(amountLeft == 0){
			return 1;
		}
		if(amountLeft < 0){
			return 0;
		}
		
		// we're out of denominations
	    if (currentIndex == denominations.length) {
	        return 0;
	    }
	    
	    int numPossibilities = 0;
	    System.out.println(String.format("checking ways to make %d with %s", amountLeft, Arrays.toString(Arrays.copyOfRange(denominations, currentIndex, denominations.length))));

	        // choose a current coin
	        int currentCoin = denominations[currentIndex];

	        // see how many possibilities we can get
	        // for each number of times to use currentCoin
	        while (amountLeft >= 0) {
	            numPossibilities += countWaysToMakeAmount(amountLeft, denominations, currentIndex + 1);
	            amountLeft -= currentCoin;
	        }

	        return numPossibilities;
	}

}
