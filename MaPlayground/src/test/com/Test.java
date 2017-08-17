package test.com;

import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		int i = 3;
		
		System.out.println((i%2==0?i:i+1)/2);
		System.out.println(i%2==0);
		System.out.println("------------------------");
		int number = 5;
		System.out.println(number);
		printNum(number--);
		System.out.println(number);
		Stack<Integer> stack = new Stack<>();
		stack.add(4);
		System.out.println("[stack] " + stack.pop());
		
		
		 int[][] foo = new int[][] {
		        { 1, 2, 3 },
		        { 1, 2, 3, 4},
		    };

		    System.out.println(foo.length); //2
		    System.out.println(foo[0].length); //3
		    System.out.println(foo[1].length); //4
		    
		    int[] arr = {1,2,3};
		    for(int e : arr){
		    	System.out.print(e);
		    }
	}
	
	public void myFirstLambda(){
		System.out.println("=== RunnableTest ===");

		// Anonymous Runnable
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello world one!");
			}
		};

		// Lambda Runnable
		Runnable r2 = () -> System.out.println("Hello world two!");

		// Run em!
		r1.run();
		r2.run();

	}
	
	public static void foocall(){
		foo();
	}
	
	public static void foo() throws EmptyStackException {
		throw new EmptyStackException();
	}

	
static void printNum(int num){
	System.out.println(num);
}
}