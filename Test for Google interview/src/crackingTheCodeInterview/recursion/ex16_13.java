package crackingTheCodeInterview.recursion;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;


public class ex16_13 {

	public static void main(String[] args) {
//		Line2D line = new Line2D(3,4);
		Point p1 = new Point(3,4);
		Point p2 = new Point(5,3);
		Line line = new Line(p2,p1);
		System.out.println(line);
	}
	
	
	public static class Square{
		Point tl,tr,bl,br;
		public Square(Point p1, Point p2, Point p3, Point p4){
			List<Point> list = new ArrayList<>();
			list.add(p1);
			list.add(p2);
			list.add(p3);
			list.add(p4);
			list.sort((pnt1,pnt2)->pnt1.x>pnt2.x?1:pnt1.x==pnt2.x?0:-1);
			tl = list.get(0).y>list.get(1).y?list.get(0):list.get(1);
			bl = tl == list.get(0)?list.get(1):list.get(0);
//			tr = list.get(2)>list.get(3)?
		}
	}
	public static class Point{
		float x,y;
		public Point (float x, float y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
		return "("+x+","+y+")";
		}
	}
	
	public static class Line{
		Point start,end;
		
		public Line(Point p1, Point p2){
			start = p1.x<p2.x?p1:p2;
			end = p1.x<p2.x?p2:p1;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
		return start + " " + end;
		}
		
	}
}
