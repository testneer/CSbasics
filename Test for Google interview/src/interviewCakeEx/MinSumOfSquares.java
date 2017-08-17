package interviewCakeEx;

public class MinSumOfSquares {

	public static void main(String[] args) {
		System.out.println(getMinSquares(8));

	}

	// A naive recursive JAVA program to find minimum
	// number of squares whose sum is equal to a given number
	    // Returns count of minimum squares that sum to n
	    static int getMinSquares(int n)
	    {
	        // base cases
	        if (n <= 3)
	            return n;
	      
	        // getMinSquares rest of the table using recursive
	        // formula
	        int res = n; // Maximum squares required is n (1*1 + 1*1 + ..)
	      
	        // Go through all smaller numbers
	        // to recursively find minimum
	        for (int x = 1; x <= n; x++)
	        {
	            int temp = x*x;
	            if (temp > n)
	                break;
	            else
	                res =  Math.min(res, 1+getMinSquares(n - temp));
	        }
	        return res;
	    }
}
