package crackingTheCodeInterview.recursion;

public class ex16_1 {

	public static void main(String[] args) {
		//swap in place
		int a = 5;
		int b = 3;
		System.out.println("a " + a + " b " + b);
		a = a<<16;
		a += b;
		b = b<<16;
		b+= (a>>16);
		a &= 65535;
		b &= 65535;
		
		System.out.println("a " + a + " b " + b);
			
		betterSolution();
		xorSolution();
	}

	private static void xorSolution() {
		int a = 5;
		int b = 3; 
		System.out.println("a " + a + " b " + b);
		a = a-b; // 5-3 = 2
		b = b+a; //= 3+2 = 5  
		a = b-a; // 
		System.out.println("a " + a + " b " + b);
		
	}

	private static void betterSolution() {
		int a = 5;
		int b = 3; 
		System.out.println("a " + a + " b " + b);
		a = b^a; // 5-3 = 2
		b = b^a; //= 3+2 = 5  
		a = b^a; // 
		System.out.println("a " + a + " b " + b);
		
	}
	
	

}
