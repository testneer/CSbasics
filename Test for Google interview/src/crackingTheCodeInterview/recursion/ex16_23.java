package crackingTheCodeInterview.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Element;

public class ex16_23 {
	public static void main(String[] args) {
		int[] arr = {7,1,1,7,1,4,4,4};
		int k =8;
		System.out.println(pairsWithSum(arr, k));
		System.out.println(bookSolution1(arr, k));
	}
	
	public static ArrayList<Pair> bookSolution1(int[] arr, int sum){
		ArrayList<Pair> result = new ArrayList<Pair>();
		HashSet<Integer> set = new HashSet<>();
		for(int x : arr){
			int complement = sum - x;
			if(set.contains(complement) && !set.contains(x)){
				result.add(new Pair(x, complement));
			}
			set.add(x);
		}
		return result;
	}
	
	public static ArrayList<Pair> pairsWithSum(int[] arr, int k){
		List<Pair> res = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int num : arr){
			Integer previousCount = map.get(num);
			Integer newCount = new Integer(1);
			if(previousCount != null){
				newCount = new Integer(previousCount.intValue()+1);
			}
			map.put(num, newCount);
		}
		
		for (int num : arr){
			int target = k-num;
			Integer targetCount = map.get(target);
			Integer numCount = map.get(num);
			if(targetCount != null && targetCount.intValue() > 0 && numCount.intValue() > 0){
				res.add(new Pair(target, num));
				map.put(target, targetCount.intValue()-1);
				numCount = map.get(num);
				map.put(num, numCount.intValue()-1);
			}
			
		}
		return (ArrayList<Pair>) res;
	}
	
	public static class Pair{
		public final int first;
		public final int second;
		
		public Pair(int first, int second){
			this.first = first;
			this.second = second;
		}
		
		@Override
		public String toString() {
			return "<"+first+","+second+">";
		}
	}
}
