package eulerEx;

import java.util.ArrayList;

public class Ex3LargestPrimeFactor {

	//The prime factors of 13195 are 5, 7, 13 and 29.
	//
	//What is the largest prime factor of the number 600851475143 ?

 
	
	public static void main(String[] args) {
		ArrayList<Long> factors = new ArrayList<>();
		ArrayList<Long> factorsToRemove = new ArrayList<>();
		
		//find all factors
		long number = 600851475143L;
		factors.add(2L);
		for (long i = 3; i < Math.sqrt(number); i+=2){
			if(number%i==0){
//				System.out.println(i);
				factors.add(i);
			}
		}
		//get the factors to remove
		for (long i = 0; i < factors.size(); i ++){
			for (long j = i+1; j<factors.size(); j++){
				if(factors.get((int) j)%factors.get((int) i)==0){
					factorsToRemove.add(factors.get((int) j));
//					System.out.println(factors.get(j));
					
				}
			}
		}
		
		//remove them
		factors.removeAll(factorsToRemove);
		System.out.println("prime factors :" + factors);
	}
	
	

}
