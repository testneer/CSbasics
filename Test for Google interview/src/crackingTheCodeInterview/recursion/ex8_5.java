package crackingTheCodeInterview.recursion;

public class ex8_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiplyRec(5, 2));
//		tesBitShift(4, 5);
	}

	public static int multiplyRec(int a, int b) { // -2,3
		if (a == 0 || b == 0) {
			return 0;
		}
		

		// Handle sign
		boolean positiveSign = false;
		if ((a > 0 && b > 0) || (a < 0 && b < 0)) {
			positiveSign = true;
		}

		// eliminate sign
		a = Math.abs(a);
		b = Math.abs(b);

		int smaller = Math.min(a, b); // 2 //***Handle overFlow
		int result = multiplyRecImpl(smaller == a ? b : a, smaller);
		int result2 = multiplyRecImplShift(smaller == a ? b : a, smaller);
		// set sign to result
		if (!positiveSign) {
			result = result - result - result;
			result2 = result2 -result2 - result2;
		}
		System.out.println("multiplyRecImplShift " + result2); //just a hack to get compare the new 0(small) method compelixty
		return result;
	}

	private static int multiplyRecImpl(int num, int iter) {
		int result = num;
		

		// base case
		if (iter == 0) {
			return 0;
		}

		int temp = multiplyRecImpl(num, iter-1);
		result = Math.addExact(temp, result);

		return result;
	}
	
	private static int multiplyRecImplShift(int num, int iter) {
		boolean b = iter%2!=0;
		int result = 0;
			//base case
			if (iter == 0 || iter ==1){
				return num;
			}
			iter = iter >> 1;
			result = multiplyRecImplShift(num << 1, iter);
			return b?result+num:result;
		
	}
	
	private static void  tesBitShift(int num, int num2){
		System.out.println(num*num2);
		System.out.println(num2<<2);
	}

}
