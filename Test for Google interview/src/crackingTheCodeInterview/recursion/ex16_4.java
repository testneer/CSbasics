package crackingTheCodeInterview.recursion;


public class ex16_4 {

	public static void main(String[] args) {
		byte[][] board = {{1,1,0,1}, {0,1,1,1}, {0,1,1,0},{1,0,0,0}};
		printMatrix(board);
		System.out.println(hasWinner(board));
		System.out.println(hasWinner2(board));
	}
	
	
	public static boolean hasWinner2(byte[][] board){
		int boardSize = board.length;
		int[] xCounter = new int[2*boardSize +2];
		int[] oCounter = new int[2*boardSize +2];
		
		for(int i = 0; i < boardSize; i++){
			for (int j = 0; j < boardSize; j++) {
				int[] currentCounter;
				int value = board[i][j];
					if(value == 1){
						currentCounter = xCounter;
					}
					else if (value == 0){
						currentCounter = oCounter;
					}
					else{
						throw new IllegalArgumentException();
					}
					if(currentCounter[i] == boardSize -1){
						return true;
					}
					else{
						currentCounter[i]++;
					}
					if(currentCounter[boardSize+j] == boardSize -1){
						return true;
					}
					else{
						currentCounter[boardSize+j]++;
					}
					if(i == j){
						if(currentCounter[currentCounter.length-2] == boardSize -1){
							return true;
						}
						else{
							currentCounter[currentCounter.length-2]++;
						}
					}
					if(i+j == boardSize-1){
						if(currentCounter[currentCounter.length-1] == boardSize -1){
							return true;
						}
						else{
							currentCounter[currentCounter.length-1]++;
						}
					}
				}
		}
		return false;
	}
	
	static void printMatrix(byte[][] grid) {
	    for(int r=0; r<grid.length; r++) {
	       for(int c=0; c<grid[r].length; c++)
	           System.out.print(grid[r][c] + " ");
	       System.out.println();
	    }
	}
	
	public static boolean hasWinner(byte[][] board){
		int boardSize = board.length;
		for (int i = 0; i < boardSize; i++) {
			if(hasWinner(board, Direction.DOWN, 0, i, boardSize)){
				return true;
			}
		}
		for (int i = 0; i < boardSize; i++) {
			if(hasWinner(board, Direction.RIGHT, i, 0,boardSize)){
				return true;
			}
		}
		if(hasWinner(board, Direction.DOWNRIGHT, 0, 0, boardSize)){
			return true;
		}
		if(hasWinner(board, Direction.DOWNLEFT, 0, boardSize-1, boardSize)){
			return true;
		}
		return false;
		
	}
	
	public enum Direction{
		DOWN,
		RIGHT,
		DOWNRIGHT,
		DOWNLEFT
	}
	
	private static boolean hasWinner(byte[][] board, Direction dir, int row, int col, int boardSize){
		byte x = 0;
		byte o = 0;
		for(int i = 0; i < board.length; i++){
			if(board[row][col] == 1){
				x++;
			}
			else if ((board[row][col] == 0)){
				o++;
			}
			if(dir == Direction.RIGHT){
				col++;
			}
			else if(dir == Direction.DOWN){
				row++;
			}
			else if(dir == Direction.DOWNRIGHT){
				row++;
				col++;
			}
			else if(dir == Direction.DOWNLEFT){
				row++;
				col--;
			}
		}
		if(x==boardSize || o==boardSize){
			return true;
		}
		return false;
	}

}
