import java.awt.Point;

public class Radunit {
	Point start, end, center;
	public Radunit(Point start, Point end, Point center){
		this.start = start;
		this.end = end;
		this.center = center;
	}
	public Point[] rotateBy(float radians){
		Point newStart = null, newEnd = null;
		Point[] tup = {newStart, newEnd}; 
		return tup;
	}
	
	public boolean withinRange(int x, int y){
		return false;
	}
	
}
