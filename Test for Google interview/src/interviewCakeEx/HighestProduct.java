package interviewCakeEx;

import java.util.Arrays;

/**
 * Given a list of integers, find the highest product you can get from three of the integers
 * @author orenegauthier
 *
 */
public class HighestProduct {

	public static void main(String[] args) {
		int[] ints1 = {3,5,6,7,8,2,4,6};
		int[] ints2 = {-5,-9,6,7,8,2,4,6};
		int[] ints3 = {-3,0,-6,4,6};
		int[] ints4 = {-3,-1,-6,-4,-6};
		int[] ints5 = {-3,0,-6,-4,-6};
		int[] ints6 = {-3,1,2,4};
		
		
		System.out.println("ints1 " + getHighestProduct(ints1));
		System.out.println("ints2 " + getHighestProduct(ints2));
		System.out.println("ints3 " + getHighestProduct(ints3));
		System.out.println("ints4 " + getHighestProduct(ints4));
		System.out.println("ints5 " + getHighestProduct(ints5));
		System.out.println("ints6 " + getHighestProduct(ints6));
System.out.println("----------");
		System.out.println("ints1 " + getHighestProductEfficient2(ints1));
		System.out.println("ints2 " + getHighestProductEfficient2(ints2));
		System.out.println("ints3 " + getHighestProductEfficient2(ints3));
		System.out.println("ints4 " + getHighestProductEfficient2(ints4));
		System.out.println("ints5 " + getHighestProductEfficient2(ints5));
		System.out.println("ints6 " + getHighestProductEfficient2(ints6));
	}

	/**
	 * do in Nlog(n)
	 * @param intArr
	 * @return
	 */
	private static long getHighestProduct(int[] intArr) {
		//sort it
		Arrays.sort(intArr);
		int lastIndex = intArr.length-1;
		long biggest = intArr[lastIndex];
		long secondBiggest = intArr[lastIndex -1];
		long thirdBiggest = intArr[lastIndex -2];
		long smallest = intArr[0];
		long secondSmallest = intArr[1];
		
		return Math.max(biggest*secondBiggest*thirdBiggest, biggest*smallest*secondSmallest);
	}

	
		/**
		 * efficient mofo
		 */
		private static long getHighestProductEfficient2(int[] intArr) {
			
			long biggest, secondBiggest, thirdBiggest, smallest, secondSmallest;
			
			//It's guarenteed to have at least 3 members;e
			int[] firstThree = new int[3];
			firstThree[0] = intArr[0];
			firstThree[1] = intArr[1];
			firstThree[2] = intArr[2];
			Arrays.sort(firstThree);

			//three Largest {-3,-1,-6,-4,-6};
			biggest = firstThree[2]; //a -1
			secondBiggest = firstThree[1];//a -3
			thirdBiggest = firstThree[0];//a -6
			long localLoser;
			long localWinner;
			
			
			//two smallest
			smallest = Long.MAX_VALUE;
			secondSmallest = Long.MAX_VALUE;
			
			for(int i = 3; i<intArr.length;i++){
				long latest = intArr[i];
				//ex //three Largest {-3,-1,-6,-4,-6}; l -6
				localWinner = Math.max(latest, biggest); // -1
				localLoser = Math.min(latest, biggest); // -6
				biggest = localWinner; // =-1
				localWinner = Math.max(localLoser, secondBiggest); //= max(-6,-3) = -3
				localLoser = Math.min(localLoser, secondBiggest);// = min(-6,-3) = -6
				secondBiggest = localWinner;// -3
				localWinner = Math.max(localLoser, thirdBiggest);// max(-6,-4) =-4
				localLoser = Math.min(localLoser, thirdBiggest);// min(-6,-4) = -6
				thirdBiggest = localWinner;// -4
				localWinner = Math.min(localLoser, smallest);// min(-6,-6) = -6 
				localLoser = Math.max(localLoser, smallest);// = max(-6,-6) = -6
				smallest = localWinner;//  -6
				secondSmallest = Math.min(localLoser, secondSmallest);// max(-6,maxV) = -6
			}
			
			if(intArr.length < 5){
				return biggest*secondBiggest*thirdBiggest;
			}
			else{
				return Math.max(biggest*secondBiggest*thirdBiggest, biggest*smallest*secondSmallest);
			}
		}
		
}
