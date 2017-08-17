package paint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.*;

public class Tablet {

	private final List<MyPoint> points = new ArrayList<MyPoint>();	
	private static Tablet tablet = new Tablet();
	
	
	public static void main(String[] args) {
		int index = 1;
		System.out.println("Welcome to my app. \nType q to exit at any stage");
		Scanner in = new Scanner(System.in);
		while(true){
			try{
				System.out.println("Please enter the X value of point number " + index + ": ");
				int x = in.nextInt();
				
				System.out.println("Please enter the Y value of point number " + index + ": ");
				int y = in.nextInt();
				index++;
				tablet.addPoint(new MyPoint(x,y));
				tablet.printLines();
			}catch(java.util.InputMismatchException e){
				in.close();
				System.exit(1);
			}
		}
	}
	
	private void printLines() {
		if(points.size() < 2){
			return;
		}
		for(int i=0;i<points.size()-1;i++){
			System.out.println("Line);
		}
	}

	public void addPoint(MyPoint point){
		points.add(point);
	}

}
