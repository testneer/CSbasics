package crackingTheCodeInterview.recursion;

public class ex1_6 {

	public static void main(String[] args) {
		String std = "aaabbssssssasdffarww";
		System.out.println(compress(std));
		System.out.println(compress2(std));
		System.out.println(compress3(std));
	}
	
	static String compress(String str){
		if(str==null || str.length() == 0){
			throw new IllegalArgumentException("input null or empty");
		}
		
		StringBuilder builder = new StringBuilder();
		int count = 1;
		char prev = '?';
		for(int i = 0; i < str.length(); i++){
			char current = str.charAt(i);
			if(prev != current){
				if(prev != '?'){
					builder.append(count);
					count = 1;
				}
				builder.append(current);
				prev = current;
			}
			else{
				count++;
			}
			if(i == str.length() -1){
				builder.append(count);
			}	
		}
		String compressed = builder.toString();
		return compressed.length() < str.length()?compressed:str;
		
	}
	
	static String compress2(String str){
		if(str==null || str.length() == 0){
			throw new IllegalArgumentException("input null or empty");
		}
		
		StringBuilder builder = new StringBuilder();
		int count = 1;
		char prev = '?';
		for(int i = 0; i < str.length(); i++){
			char current = str.charAt(i);
			if(current != prev){
				builder.append(current);
			}
			else{
				count++;
			}
			if(i+1 >= str.length() || str.charAt(i+1) != current){
				builder.append(count);
				count = 1;
			}
			prev = current;
		}
		String compressed = builder.toString();
		return compressed.length() < str.length()?compressed:str;
	}
	
	static String compress3(String str){
		if(str==null || str.length() == 0){
			throw new IllegalArgumentException("input null or empty");
		}
		
		//check length
		int compressedLength = 0;
		for(int i = 0; i < str.length(); i++){
			char current = str.charAt(i);
			
			if(i+1 >= str.length() || current != str.charAt(i+1)){
				compressedLength += 2;
			}
		}
		System.out.println(compressedLength + "   " + str.length());
		
		
		StringBuilder builder = new StringBuilder();
		int count = 1;
		for(int i = 0; i < str.length(); i++){
			char current = str.charAt(i);
			
			if(i+1 >= str.length() || current != str.charAt(i+1)){
				builder.append(current);
				builder.append(count);
				count = 1;
			}
			else{
				count++;
			}
			
		}
		String compressed = builder.toString();
		return compressed.length() < str.length()?compressed:str;
	}
	
	static void test(){
		int a = 3;
	}

}
