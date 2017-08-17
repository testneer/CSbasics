import java.util.Arrays;

public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arr = new int[5][5];
		rotate(arr);
//		System.out.println(Arrays.deepToString(arr));
		int[][] simple = {{1,2},{3,4}};
		System.out.println(Arrays.deepToString(simple));
		rotateCW(simple);
		rotateCW(simple);
		rotateCW(simple);
		rotateCW(simple);
		System.out.println(Arrays.deepToString(simple));
		int[][] simple2 = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(Arrays.deepToString(simple2));
		rotateCW(simple2);
		rotateCW(simple2);
		rotateCW(simple2);
		rotateCW(simple2);
		System.out.println(Arrays.deepToString(simple2));
	}

	
	static int[][] rotate(int[][] matrix){
		
		System.out.println(matrix[1].length);
		return new int[1][1];
	}
	
	static void rotateCW(int[][] matrix){
		int dimension = matrix.length;
		int buffer = 0;
		int numOfLevels = dimension/2;
		
		for(int startIndex=0; startIndex < numOfLevels; startIndex++){
			int endIndex = dimension - startIndex - 1;
			for(int y = startIndex; y < endIndex; y++){
				buffer = matrix[startIndex][y];
				matrix[startIndex][y] = matrix[endIndex - y + startIndex][startIndex];
				matrix[endIndex - y + startIndex][startIndex] = matrix[endIndex][endIndex- y + startIndex];
				matrix[endIndex][endIndex- y + startIndex] = matrix[y][endIndex];
				matrix[y][endIndex] = buffer;
			}
		}
	}
}
