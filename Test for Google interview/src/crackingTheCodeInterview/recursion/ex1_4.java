package crackingTheCodeInterview.recursion;

public class ex1_4 {
	public static void main(String[] args) {
		System.out.println("false -->" +  permutatePalindorm("wweerrrrffds"));
		System.out.println("true -->" +  permutatePalindorm("wweer rrrffs"));
		System.out.println("true -->" +  permutatePalindorm("a"));
		System.out.println("false -->" +  permutatePalindorm("ad"));
	}
	
	static boolean permutatePalindorm(String str){
		boolean[] oddCount = new boolean[256];
		
		for(int i = 0; i <str.length(); i++){
			char c = str.charAt(i);
			if( (c>'a' && c < 'z') || (c>'A' && c < 'Z')){
				int index = (int)c;
				oddCount[index] = !oddCount[index];
				
			}
		}
		
		int totalOddCount =0;
		for(boolean b : oddCount){
			if(b){
				totalOddCount++;
				if(totalOddCount > 1){
					return false;
				}
			}
		}
		return true;
	}
}
