package crackingTheCodeInterview.recursion;

public class ex16_15 {

	public static void main(String[] args) {
		char[] solution = {'R', 'G', 'B', 'Y'};
		char[] guess = {'R', 'G', 'B', 'B'};
		System.out.println(countHitsAndGhits(solution, guess));
		
	}
	
	static int getCharIndex(char c){
		switch (c){
		case 'R':
			return 0;
		case 'G':
			return 1;
		case  'B':
			return 2;
		case 'Y' :
			return 3;
		default:
			return -1;
		}
	}
	
	public static Result countHitsAndGhits(char[] solution, char[] guess){
		Result result = new Result();
		final int numOfSigns = 4;
		int[] occurrences = new int[numOfSigns];
		
		//count all the occurrences in the solution
		for(int i = 0; i < solution.length; i++){
			occurrences[getCharIndex(solution[i])]++;
		}
		
		//count hits and deduct occurrences
		for(int i = 0; i < solution.length; i++){
			if(solution[i] == guess[i]){
				result.hits++;
				occurrences[getCharIndex(solution[i])]--;
			}
		}
		
		//count gHits
		for (int i = 0; i < guess.length; i++) {
			char c = guess[i];
			int guessLocation = getCharIndex(c);
			if(occurrences[guessLocation] > 0){
				result.gHits++;
				occurrences[guessLocation]--;
			}
			
		}
		return result;
	}

	static class Result{
		int hits;
		int gHits;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "hits:" + hits + " gHits:"+gHits;
		}
	}
}
