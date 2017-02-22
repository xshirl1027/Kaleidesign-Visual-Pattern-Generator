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
	protected static int currentColor = BLACK; 
	protected static int prevX, prevY;     // The previous location of the mouse.
	protected static boolean dragging;      // This is set to true while the user is drawing.
	protected static Graphics2D graphicsForDrawing;  // A graphics context for the panel
	protected static int pen_size = 1;
	protected static int width=0;    // Width of the panel.
	protected static int height=0;
	protected static Point center = new Point();
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
	
	public void setPenSize(int size){
		pen_size = size;
	}
	
	protected void setUpDrawingGraphics(int w) {
		graphicsForDrawing = (Graphics2D) getGraphics();
		graphicsForDrawing.setStroke(new BasicStroke(w));
		switch (currentColor) {
		case BLACK:
		graphicsForDrawing.setColor(Color.BLACK);
		break;
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
