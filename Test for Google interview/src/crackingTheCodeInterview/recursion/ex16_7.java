package crackingTheCodeInterview.recursion;

import java.awt.BufferCapabilities.FlipContents;

public class ex16_7 {

	public static void main(String[] args) {
//		System.out.println(isBigger(3, 5));
//		System.out.println(isBigger(5, 3));
//		System.out.println(isBigger(-1, 5));
//		System.out.println(isBigger(-1, 5));
//		System.out.println(getMax(3, 5));
//		System.out.println(getMax(5, 3));
//		System.out.println(getMax(3, -5));
//		System.out.println(getMax(-433, -12345));
		System.out.println(getMaxBook(3, -5));
	}
	
	public static int getMaxBook(int a, int b){
		int k = (sign(a-b));
		int q = flip(k);
		return a*k +b*q;
	}
	public static int sign(int a){
		return flip((a>>31)&0x1);
	}
	private static int flip(int bit){
		return 1^bit;
	}
	
	private static int getBit(int num, int position){
		return (num >>> position) & 1;
	}
	
	
	
	public static int getMax(int a, int b){
		
		if(getBit(a,31) == 1 && getBit(b,31) == 0){
			return b;
		}
		else if (getBit(a,31) == 0 && getBit(b,31) == 1){
			return a;
		}
		
		for(int i = 62; i>=0;i--){
			if(getBit(a, i) == 1 && getBit(b, i) == 0){
				return a;
			}
			if(getBit(a, i) == 0 && getBit(b,i) == 1){
				return b;
			}
		}
		//equal
		return a;
	}
	
	private static boolean isBitSet(int num, int position){
		return (num &(1<<position))>>>position == 1;
	}
	
	public static boolean isBigger(int a, int b){
		boolean aPositive = !isBitSet(a,31);
		boolean bPositive = !isBitSet(b,31);
		
		if(aPositive && !bPositive){
			return true;
		}
		else if (!aPositive && bPositive){
			return false;
		}
		
		for(int i = 62; i>=0;i--){
			if(isBitSet(a, i) && !isBitSet(b, i)){
				return true;
			}
			if(!isBitSet(a, i) && isBitSet(b, i)){
				return false;
			}
		}
		//equal
		return false;
	}

}
