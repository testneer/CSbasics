package crackingTheCodeInterview.recursion;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

//Robot path

public class ex8_2 {

	public static void main(String[] args) {
		boolean[][] maze = {{true, false, false},{true, false, false},{true, true, false},{false, false, true}};
		System.out.println(Arrays.toString(getPath(maze).toArray()));

	}
	
	static ArrayList<Point> getPath(boolean[][] maze){
		ArrayList<Point> path = new ArrayList<>();
		
		if(getPathRec(maze, maze.length-1, maze[0].length-1, path)){
			return path;
		}
		else {
			return null;
		}
	}
	
	static boolean getPathRec(boolean[][] maze, int r, int c, ArrayList<Point> path){
		System.out.println(String.format("current point to check = (%d,%d)", r,c));
		//base conditions return true if at origin
		if(r == 0 && c == 0){
			return true; 
		}
		
		//second base condition.
		if(r < 0 || c < 0 || !maze[r][c]){
			return false;
		}
		
		if(getPathRec(maze, r-1, c, path) || getPathRec(maze, r, c-1, path) ){
			Point p = new Point(r, c){
				@Override
				public String toString() {
					return "("+x+","+y+")";
				}
			};
			path.add(p);
		}
		return !path.isEmpty();
	}
}
