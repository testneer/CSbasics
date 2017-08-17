package interviewCakeEx;

import java.util.Arrays;

public class Fibon {
	
	public static void main(String[] args){
	
		int n =30;
		printFiboToN(n);
		System.out.println("rec : " + fibo(n));
	}

	private static void printFiboToN(int n) {
		int prev1 = 1;
		int prev2 = 1;
		
		if(n > 0){
			System.out.println(1);
			if(n > 1){
				System.out.println(1);
			}
		}
		for(int i = 2; i < n; i++){
			int temp = prev1 +prev2;
			prev2=prev1;
			prev1 = temp;
			System.out.println(temp);
		}
	}
	
	private static int fibo(int n){
		
		return fibo(n, new int[n+1]);
	}
	
	private static int fibo(int n, int[] mem){
		if (n ==0){
			return 0;
		}
		
		if(n ==1){
			return 1;
		}
		
		if(mem[n] == 0){
			mem[n] = (fibo(n-1, mem) + fibo(n-2, mem));
		}
		System.out.println(Arrays.toString(mem));
		return mem[n];
		
	
	}

}
