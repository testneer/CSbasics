package crackingTheCodeInterview.recursion;

import java.util.HashSet;
import java.util.Set;

public class ex8_4 {
	
	public static void main(String[] args){
		Set<Object> set = new HashSet<>();
		for (int i = 0; i < 12; i++) {
			set.add(""+i);
		}
		System.out.println(set);
		long startTime = System.currentTimeMillis();
		Set<Set<Object>> allSubsetsOfGivenSet = getAllSubsetsOfGivenSet2(set);
		long endTime = System.currentTimeMillis();
		System.out.println("Time in milis " + (endTime - startTime));
		System.out.println("size:" + allSubsetsOfGivenSet.size() + " " + allSubsetsOfGivenSet);
	}
	static <T> Set<Set<T>> getAllSubsetsOfGivenSet(Set<T> origin){
		Set<Set<T>> result = new HashSet<>();
		return getAllSubsetsOfGivenSet(origin, result); 
	}
	static <T> Set<Set<T>> getAllSubsetsOfGivenSet(Set<T> origin, Set<Set<T>> result){
		  //base case
		  if(origin.size() == 0 || result.contains(origin)){
		    return null;
		  }
		 
		  for(T o : origin){
		    Set<T> subSet = new HashSet<>(origin);
		    subSet.remove(o);
		    getAllSubsetsOfGivenSet(subSet, result);
		    result.add(subSet);
		  }
		    return result;
		}
	
	static <T> Set<Set<T>> getAllSubsetsOfGivenSet2(Set<T> origin){
		  if(origin == null || origin.size() == 0){
		    throw new IllegalArgumentException("Set is Null or empty");
		  }
		  Set<Set<T>> result = new HashSet<>();
		  return getAllSubsetsOfGivenSet2(origin, result);
		}
		 
	static <T> Set<Set<T>> getAllSubsetsOfGivenSet2(Set<T> origin, Set<Set<T>> result){
		  
		  //base case
		  if (origin.size() == 0 || result.contains(origin)){
		    return null;
		  }
		  
		  for(T element : origin){
		    Set<T> subSet = new HashSet<T>(origin);
		    subSet.remove(element);
		    getAllSubsetsOfGivenSet2(subSet, result);
		    result.add(subSet);
		  }
		return result;
		} 
}
