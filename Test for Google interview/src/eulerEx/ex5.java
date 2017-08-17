package eulerEx;


/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * @author orenegauthier
 *
 */
public class ex5 {
	
	public static void main(String[] args) {
//		for(float i = 1; i < 11; i++){
//			System.out.println(2520/i);
//			
//		}
		System.out.println(findSmallestDivisible(20));
		
	}
	
	static int findSmallestDivisible(int upperLimit){
		int i = 1;
		while (true){
			if(divsibileByAll(i, upperLimit)){
				return i;
			}
			i++;
		}
	}
	
	static boolean divsibileByAll(int num, int limit){
		boolean result = true;
		for (int i = 1; i < limit; i++){
			if(num%i == 0){
				result = result && true;
			}else{
				result = result && false;
			}
			
		}
		return result;
	}
}

