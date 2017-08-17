package interviewCakeEx;

/**
 * Writing programming interview questions hasn't made me rich. Maybe trading Apple stocks will.
Suppose we could access yesterday's stock prices as a list, where:

The indices are the time in minutes past trade opening time, which was 9:30am local time.
The values are the price in dollars of Apple stock at that time.
So if the stock cost $500 at 10:30am, stock_prices_yesterday[60] = 500.

Write an efficient function that takes stock_prices_yesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.

For example:

  stock_prices_yesterday = [10, 7, 5, 8, 11, 9]

get_max_profit(stock_prices_yesterday)
# returns 6 (buying for $5 and selling for $11)

No "shorting"—you must buy before you sell. You may not buy and sell in the same time step (at least 1 minute must pass).
 * @author orenegauthier
 *
 */
public class AppleStock {

	public static void main(String[] args) {
		int[] goUp = {1,2,3,4}; //3
		int[] goDown = {4,3,1}; //-1
		int[] upAndDown = {3,8,1,7}; // 6
		int[] noChange = {4,4,4,4}; // 0
		int[] nullArr = {}; // 
		System.out.println(getMaxProfit(goUp));
		System.out.println(getMaxProfit(goDown));
		System.out.println(getMaxProfit(upAndDown));
//		System.out.println(getMaxProfit(nullArr));
		System.out.println(getMaxProfit(noChange));

	}

	private static int getMaxProfit(int[] arr) {
		if(arr == null || arr.length < 1){
		    throw new IllegalArgumentException("input null or too small");
		  }
		
		int min = arr[0];
		int max = arr[0];
		int maxGap = Integer.MIN_VALUE;
		
		for (int i = 1; i < arr.length; i++){
			int currentVal = arr[i];
			if(currentVal < min){
				max = currentVal;
			}
			else{
				max = Math.max(max, currentVal);
			}
			
			maxGap = Math.max(maxGap, max-min);
			min = Math.min(min, currentVal);
		}
		return maxGap;
	}

}
