package fromGlassDoor;

public class KPlindrome {
	public static void main(String[] args) {
		kPalin("aba", 0);
	}
	
	static void kPalin(String str, int k){
		//validation
		System.out.println(kPalin(str, k, 0, 0, str.length()-1)?"YES":"NO");
	}
	
	static boolean kPalin(String str, int k, int kCounter, int left, int right){
		if(left >= right || kCounter > k){
			if(k==kCounter){
				return true;
			}
			else{
				return false;
			}
		}
		
		//same char - increment both, don't increase kCounter
		if(str.charAt(left) == str.charAt(right)){
			return kPalin(str, k, kCounter, ++left, --right);
		}
		else{
			return kPalin(str, k, ++kCounter, ++left, right) || kPalin(str, k, ++kCounter, left, --right);
		}
	}
}
