import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
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
public class RadPattern extends JPanel
implements MouseListener, MouseMotionListener {
	private int prevX, prevY;     // The previous location of the mouse.

	private boolean dragging;      // This is set to true while the user is drawing.

	private Graphics graphicsForDrawing;  // A graphics context for the panel
	                   // that is used to draw the user's curve.
	
	private float angle; //angle in radians
	private int width;    // Panel dimensions
	private int height;
	private Point center; //point of rotation
	
	RadPattern(){
		setBackground(Color.WHITE);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);  // Fill with background color (white).

		width = getWidth();    // Width of the panel.
		height = getHeight();  // Height of the panel.
		center = new Point();
		center.x = width/2; 
		center.y = height/2;
		angle = 360/10;
		graphicsForDrawing = g;
		setUpDrawingGraphics();
		Graphics2D g2d;
		//g2d.drawLine(center.x,, center.x, center.y);
		for(int i=0; i<=360/angle; i++){
			g2d = (Graphics2D) g.create();
			System.out.println(center.y);
			g2d.setColor(Color.black);
			g2d.translate(width/2, height/2);
			g2d.rotate(Math.toRadians(i*angle));
			g2d.translate(-width/2, -height/2);
			g2d.drawLine(center.x, 0, center.x, center.y);
			g2d.dispose();

		}
		
	}
	
	private void setUpDrawingGraphics() {
		graphicsForDrawing = getGraphics();
		graphicsForDrawing.setColor(Color.BLACK);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (dragging == false)
			return;  // Nothing to do because the user isn't drawing.

			int x = e.getX();   // x-coordinate of mouse.
			int y = e.getY();   // y-coordinate of mouse.
			  // Draw the line.
			//graphicsForDrawing.fillOval(x, y, 2, 2); //create a layered effect

			//graphicsForDrawing.drawLine(prevX, prevY, x, y);
			for(int i=0; i<=360/angle; i++){
				Graphics2D g2d = (Graphics2D) graphicsForDrawing.create();
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
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		setUpDrawingGraphics();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (dragging == false)
			return;  // Nothing to do because the user isn't drawing.
			dragging = false;
			graphicsForDrawing.dispose();
			graphicsForDrawing = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
