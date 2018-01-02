
public class gcd {
	
	public static void main(String[] args) {
		System.out.println(gcd(12, 18));
	}
	
	static int gcd(int a, int b){	
		
		if(b==0){
			return a;
		}
		else{
			System.out.println("a= " + a + " b= " + b + " a%b= " + a%b);
			return gcd(b, a%b);
		}
		
	}
}
