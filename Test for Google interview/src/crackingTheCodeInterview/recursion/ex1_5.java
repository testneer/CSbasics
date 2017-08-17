package crackingTheCodeInterview.recursion;

public class ex1_5 {

	public static void main(String[] args) {
		System.out.println(isOneWay("ooen", "ore"));

	}
	
	static boolean isOneWay(String first, String second){
		
		String shorter = first.length() > second.length() ? second : first;
		String longer = first.length() > second.length() ? first : second;
		
		if(first.length() == second.length()){
			int differenceCount = 0;
			for(int i = 0; i < first.length(); i++){
				if(first.charAt(i) != second.charAt(i)){
					differenceCount ++;
				}
				if(differenceCount > 1){
					return false;
				}
			}
			return true;
		}
		else if (longer.length() - shorter.length() > 1){
			return false;
		}
		else {
			int indexExtra = 0;
			for(int i = 0; i < shorter.length(); i++){
				if(shorter.charAt(i) != longer.charAt(i+indexExtra)){
					if(indexExtra == 1){
						return false;
					}
					else {
						indexExtra ++;
					}
				}
			}
			return true;
		}
	}
}
