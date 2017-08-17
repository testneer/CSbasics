import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SumOfAllMultiples {

	public static void main(String[] args) {
	System.out.println(sumOfMultiplesOf3Or5Beloww1000());
	System.out.println(sumOfMultipliers(100000000000L, 10,5,7,2,3,11,13,17,23,47));
	System.out.println(Long.MAX_VALUE);
	}

	
	public static long sumOfMultiplesOf3Or5Beloww1000(){
		long result = 0;
		Set<Long> multiples = new HashSet<>();
		
		for(long i = 3; i < 1000; i+=3){
			multiples.add(i);	
		}
		
		for(long i = 5; i < 1000; i += 5){
			multiples.add(i);
		}
		
		Iterator<Long> iter = multiples.iterator();
		
		while(iter.hasNext()){
			result += iter.next();
		}
		
	
		return result;
		
	}
	
	public static long sumOfMultipliers(long upperLimit, long... multiples){
		long result = 0;
		boolean negLimit = upperLimit < 0;
		if(negLimit){
			upperLimit = Math.abs(upperLimit);
		}
		
		for (long i = 1; i <upperLimit; i++){
			for(long num: multiples){
//				if(num == 0){
//					throw new IllegalArgumentException("multiples can't be 0");
//				}
				if(negLimit && num > 0){
					break;
				}
				if(num != 0 && i % num == 0){
					result = Math.addExact(result, i);
					break;
				}
			}
		}
		return negLimit ? result*-1:result;
	}
}
