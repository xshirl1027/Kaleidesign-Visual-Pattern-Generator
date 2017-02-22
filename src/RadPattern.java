import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Shirley
 *
 */
public class RadPattern extends Pattern{

	private float angle; //angle in radians
	public RadPattern(int w, int h, int nseg) {
		super(w, h);
		angle = 360/nseg;
		center.x = width/2;
		center.y = height/2;
		// TODO Auto-generated constructor stub
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		graphicsForDrawing =(Graphics2D) g;
		setUpDrawingGraphics(pen_size);
		for(int i=0; i<=360/angle; i++){
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setColor(Color.black);
			g2d.setStroke(new BasicStroke(3));
			g2d.translate(width/2, height/2);
			g2d.rotate(Math.toRadians(i*angle));
			g2d.translate(-width/2, -height/2);
			g2d.drawLine(center.x, -center.y, center.x, center.y);
			g2d.dispose();
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (dragging == false)
			return;  // Nothing to do because the user isn't drawing.

			int x = e.getX();   // x-coordinate of mouse.
			int y = e.getY();   // y-coordinate of mouse.
			for(int i=0; i<=360/angle; i++){
				Graphics2D g2d = (Graphics2D) getGraphics();
				g2d.setColor(Color.blue);
				g2d.translate(width/2, height/2);
				g2d.rotate(Math.toRadians(i*angle));
				g2d.translate(-width/2, -height/2);
				g2d.drawLine(prevX, prevY, x, y);
				g2d.dispose();
			}
			prevX = x;  // Get ready for the next line segment in the curve.
			prevY = y;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();   // x-coordinate where the user clicked.
		int y = e.getY();   // y-coordinate where the user clicked.
		System.out.println("click");
		if (dragging == true)  // Ignore mouse presses that occur
		return;            //    when user is already drawing a curve.
		                 //    (This can happen if the user presses
		                 //    two mouse buttons at the same time.)
		else {
		// The user has clicked on the white drawing area.
		// Start drawing a curve from the point (x,y).
		prevX = x;
		prevY = y;
		dragging = true;
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (dragging == false)
			return;  // Nothing to do because the user isn't drawing.
			dragging = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}


}
