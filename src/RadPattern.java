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
 * @author Shirley
 *Params: width, height, number of segments
 *This class will split the screen into user-defined(nseg) segments. User drawings will be rotated 360 degrees around the screen
 *nseg times. This will create a kaleidoscope-like effect.
 *TODO: create a mirror effect within each segment
 */
@SuppressWarnings("serial")
public class RadPattern extends Pattern{
	private int nseg;
	public RadPattern(int w, int h, int nseg) {
		super(w, h);
		this.nseg = nseg;
		center.x = width/2;
		center.y = height/2;
		//setUpDrawingGraphics(2);
		// TODO Auto-generated constructor stub
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		graphicsForDrawing =(Graphics2D) g;
		setUpDrawingGraphics(pen_size);
		setBackground(Color.YELLOW);
		utils.rotateDraw((Graphics2D) g, nseg, center.x, -center.y, center.x, center.y, center, Color.black, false);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (dragging == false)
			return;  // Nothing to do because the user isn't drawing.

			int x = e.getX();   // x-coordinate of mouse.
			int y = e.getY();   // y-coordinate of mouse.
			Graphics2D g = (Graphics2D) getGraphics();
			//utils.rotateDraw(g, nseg, prevX, prevY, x, y, center, Color.CYAN, true);
			utils.rotateDraw(g, nseg, prevX, prevY, x, y, center, Color.CYAN, true);
			prevX = x;  // Get ready for the next line segment in the curve.
			prevY = y;
	}



}
