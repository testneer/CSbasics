import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import javax.management.openmbean.InvalidOpenTypeException;

public class TestShit {

	public static void main(String[] args) {
		printVarArgs();
//		printVarArgs(Integer.MAX_VALUE, Integer.MAX_VALUE+1);
		int a = 4;
		autobox(a);
		System.out.println(((Object)a).getClass().toGenericString());
		antibox((int) 5L);
		modulo(20);
		
		testArr();
		
		testIntOverflow();
		Nono<Bon2> mono = new Nono<>();
		
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(3);
		for(Integer i : arr){
//			arr.add(3);
			arr = new ArrayList<>();
			arr.add(3);
			arr.add(3);
			System.out.println("times");
		}
		System.out.println(arr.size());
	}
	
	static class Nono<T extends Bon>{
		
	}
	
	static class Bon2 implements Bon {};
	static interface Bon{};
	
	private static void testArr() {
		int[] arr = {1,2,3,3,4,5,6,6,7};
		
		int index = Arrays.binarySearch(arr, 3, arr.length, 3);

		System.out.println("index = "+ index + " value: " + ((index<0) ? "cgfv":arr[index]));
		System.out.println("----");
		System.out.println(0.3*0.3+0.3*0.7*2+0.7*0.7);
		System.out.println((1234/10)%10);
	}
	
	static void testIntOverflow(){
	
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		int c = Integer.MAX_VALUE;
		long d = (long)a*(long)b*(long)c;
		System.out.println("a " + a);
		System.out.println("d " + d);
		System.out.println("l " + Long.MAX_VALUE);
	}

	static void printVarArgs(int... vars){
		int[] arr = new int[20];
		for(int i: arr){
			System.out.print(i);
		}
		System.out.println(((Object)arr).getClass().getName());
		
		System.out.println("printVarArgs" + vars.getClass().toGenericString());
		for(int s: vars){
			System.out.println(s);
		}
	}
	
	static void autobox (long a){
		System.out.println(((Object)a).getClass().toGenericString());
		
	}
	
	static void antibox (int a){
		System.out.println(((Object)a).getClass().toGenericString());
		
	}
	
	static void modulo(int x){
		System.out.println(1%3);
	}
}
