import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
//Super class for all patterns
public class Pattern extends JPanel
implements MouseListener, MouseMotionListener {
	protected final static int BLACK = 0;
	protected int currentColor = BLACK; 
	protected int prevX, prevY;     // The previous location of the mouse.
	protected boolean dragging;      // This is set to true while the user is drawing.
	protected static Graphics2D graphicsForDrawing;  // A graphics context for the panel
	protected int pen_size = 1;
	protected int width=0;    // Width of the panel.
	protected int height=0;
	protected Point center = new Point();
	protected int initx, inity;
	/**
	* Constructor sets the background color to be
	* white and sets it to listen for mouse events on itself.
	*/
	public Pattern(int w, int h) {
		// TODO Auto-generated constructor stub
		setBackground(Color.WHITE);
		addMouseListener(this);
		addMouseMotionListener(this);
		width = w;
		height = h;
	}
	public void paintComponent(Graphics g) {

		super.paintComponent(g);  // Fill with background color (white).
		
		graphicsForDrawing = (Graphics2D) g;
		setUpDrawingGraphics(pen_size);
	}
	public void setPenSize(int size){
		pen_size = size;
	}
	
	protected void setUpDrawingGraphics(int w) {
		graphicsForDrawing.setStroke(new BasicStroke(w));
		switch (currentColor) {
		case BLACK:
		graphicsForDrawing.setColor(Color.BLACK);
		graphicsForDrawing.setBackground(Color.blue);
		break;
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (dragging == false)
			return;  // Nothing to do because the user isn't drawing.

			int x = e.getX();   // x-coordinate of mouse.
			int y = e.getY();   // y-coordinate of mouse.
			Graphics2D g = (Graphics2D) getGraphics();
			g.drawLine(prevX, prevY, x, y);
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
		initx = x;
		inity = y;
		//System.out.println("click");
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
