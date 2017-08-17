package crackingTheCodeInterview.recursion;

import java.util.*;

public class ex16_9 {

	public static void main(String[] args) {
		System.out.println(flipSign(Integer.MAX_VALUE));
		System.out.println(flipSign(-19));
		System.out.println("-----MULTI----");
		//test 0, minus, two minuses, overflow.
		System.out.println(performOp(0, 10, Operation.MULTIPLY));
		System.out.println(multiply(-1, 10));
		System.out.println(multiply(-10, -10));
		System.out.println(multiply(10, -10));
		System.out.println("-----SUBS----");
		System.out.println(performOp(5, 10, Operation.SUBSTRACT));
		System.out.println(substract(10, 5));
		System.out.println(substract(-10, -5));
		System.out.println(substract(0, -5));
		System.out.println("-----DIVIDE----");
		//a smaller than b, a = 0, b = 0, non round number
		System.out.println(performOp(14, 2, Operation.DIVIDE));
		System.out.println(divide(-14, -7));
		System.out.println(divide(1, 3));
		System.out.println(divide(0, 3));
//		System.out.println(divide(0, 0));
		System.out.println(divide(10, 3));
		System.out.println("-----TEST OVERFLOW----");
//		System.out.println(performOp(Integer.MAX_VALUE, 2, Operation.MULTIPLY));
		System.out.println(performOp(Integer.MIN_VALUE, 2, Operation.SUBSTRACT));
		
	List<String> list = new ArrayList<String>();
	
	
	}
	

	private static int divide(int a, int b){
		if(b == 0){
			throw new ArithmeticException("can't divide by 0");
		}
		if(a==0){
			return 0;
		}
		
		boolean flipAtEnd = a<=0 != b<=0;
		a = Math.abs(a);
		b = Math.abs(b);
		if( a < b){
			return 0;
		}
		int result = 0;
		while(substract(a, b) >= 0){
			a = substract(a, b);
			result++;
		}
		if(flipAtEnd){
			result = flipSign(result);
		}
		return result;
	}
	
	private static int substract(int a, int b){
		int result = a + flipSign(b);
		if(a < 0 && result > 0){
			throw new ArithmeticException("number overlflow");
		}
		return result;
	}
	private static int multiply(int a, int b){
		if(a == 0 || b == 0){
			return 0;
		}
		boolean flipAtEnd = a<0 != b<0;
		a = Math.abs(a);
		b = Math.abs(b);
		int smaller = a<b?a:b;
		int bigger = a<b?b:a;
		int result = bigger;
		for(int i = 1; i<smaller;i++){
			result +=bigger;
			if(result < 0){
				throw new ArithmeticException("number overflow");
			}
		}
		if(flipAtEnd){
			result = flipSign(result);
		}
		return result;
	}
	public enum Operation{
		MULTIPLY,
		SUBSTRACT,
		DIVIDE
	}
	
	public static int performOp(int a, int b, Operation op) throws ArithmeticException {
		switch(op.ordinal()){
		case 0:
			return multiply(a, b);
		case 1:
			return substract(a, b);
		case 2:
			return divide(a, b);
		default:
			throw new IllegalArgumentException();
		}
	}
	
//	private static int flipSign(int a){
//		return (a^-1)+1;
//	}
	
	private static int flipSign(int a){
		int newSign = a < 0 ? 1 : -1;
		int result = 0;
		while(a!=0){
			result += newSign;
			a += newSign;
		}
		return result;
		
	}
}
