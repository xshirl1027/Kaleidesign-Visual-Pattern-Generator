import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

public class utils {
	
	public static int distFromCenter(Point center, int x, int y){
		return (int) Math.sqrt((Math.pow((center.x-x),2)+Math.pow((center.y-y),2)));
	}
	
	public static void drawSimple(Graphics2D g, int x1, int y1, int x2, int y2, Color c, Stroke s){
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(c);
		g2d.drawLine(x1, y1, x2, y2);
		g2d.dispose();
	}
	
	public static void rotateDraw(Graphics2D g, int nseg, int x1, int y1, int x2, int y2, Point center, Color c){
		for(int i=0; i<=nseg; i++){
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setColor(c);
			g2d.setStroke(new BasicStroke(2));
			g2d.translate(center.x, center.y);
			g2d.rotate(Math.toRadians(i*360/nseg));
			g2d.translate(-center.x, -center.y);
			g2d.drawLine(x1, y1, x2, y2);
			g2d.dispose();
		}
	}
	
	

}
