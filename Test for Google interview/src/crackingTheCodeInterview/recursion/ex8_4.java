package crackingTheCodeInterview.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class ex8_4 {
	
	public static void main(String[] args){
		Set<Object> set = new HashSet<>();
		ArrayList<Integer> arraySet= new ArrayList<>();
		for (int i = 1; i < 12; i++) {
			set.add(""+i);
			arraySet.add(i);
		}
		System.out.println(set);
		System.out.println(arraySet);
		long startTime = System.currentTimeMillis();
		Set<Set<Object>> allSubsetsOfGivenSet = getAllSubsetsOfGivenSet2(set);
		long endTime = System.currentTimeMillis();
		System.out.println("Time in milis " + (endTime - startTime));
		System.out.println("size:" + allSubsetsOfGivenSet.size() + " " + allSubsetsOfGivenSet);
		
		startTime = System.currentTimeMillis();
		ArrayList<ArrayList<Integer>> powerSet = getPowerSet(arraySet);
		endTime = System.currentTimeMillis();
		System.out.println("----------");
		System.out.println("Time in milis " + (endTime - startTime));
		System.out.println("size:" + powerSet.size() + " " + powerSet);
	}
	
	
	
//	static <T> Set<Set<T>> getAllSubsetsOfGivenSet(Set<T> origin){
//		Set<Set<T>> result = new HashSet<>();
//		return getAllSubsetsOfGivenSet(origin, result); 
//	}
//	
//	
//	static <T> Set<Set<T>> getAllSubsetsOfGivenSet(Set<T> origin, Set<Set<T>> result){
//		  //base case
//		  if(origin.size() == 0 || result.contains(origin)){
//		    return null;
//		  }
//		 
//		  for(T o : origin){
//		    Set<T> subSet = new HashSet<>(origin);
//		    subSet.remove(o);
//		    getAllSubsetsOfGivenSet(subSet, result);
//		    result.add(subSet);
//		  }
//		    return result;
//		}
	
	static ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> set){
		if(set == null){
			throw new IllegalArgumentException("can't be null");
		}
		ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();
		ArrayList<Integer> emptySet = new ArrayList<>();
		powerSet.add(emptySet);
		
		for(Integer element : set){
			int powerSetSize = powerSet.size();
			for(int j = 0 ; j < powerSetSize; j++){
				ArrayList<Integer> currentSet = powerSet.get(j);
				ArrayList<Integer> newSet = new ArrayList<>(currentSet);
				newSet.add(element);
				powerSet.add(newSet);
			}
		}
		return powerSet;
		
		
		
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
