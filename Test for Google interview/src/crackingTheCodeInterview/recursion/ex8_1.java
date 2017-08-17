package crackingTheCodeInterview.recursion;

public class ex8_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(possilbeWaysToGoUpStairsMemo(36));
System.out.println(possilbeWaysToGoUpStairs(36));
	}
	
	
	/*
	 * brute force
	 */
	static int possilbeWaysToGoUpStairs(int stairs){
		
		if(stairs == 1){
			return 1;
		}
		if(stairs == 2){
			return 2;
		}
		if(stairs == 3){
			return 4;
		}
		
		return possilbeWaysToGoUpStairs(stairs -1) + possilbeWaysToGoUpStairs(stairs-2) + possilbeWaysToGoUpStairs(stairs-3);
		
	}
	
	
	static int possilbeWaysToGoUpStairsMemo(int stairs){
		int[] memo = new int[stairs+1];
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		
		return possilbeWaysToGoUpStairsMemoImpl(stairs, memo);
	}
	
	static int possilbeWaysToGoUpStairsMemoImpl(int stairs, int[] memo){
		
		if(memo[stairs] != 0){
			return memo[stairs];
		}
		else{
			memo[stairs] = possilbeWaysToGoUpStairsMemoImpl(stairs-1, memo) + possilbeWaysToGoUpStairsMemoImpl(stairs-2, memo) + possilbeWaysToGoUpStairsMemoImpl(stairs-3, memo);
		}
		return memo[stairs];
	}

}
