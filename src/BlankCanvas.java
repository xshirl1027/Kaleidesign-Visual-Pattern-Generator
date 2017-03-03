import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class BlankCanvas extends Pattern{

	private int initx;
	private int inity;
	public BlankCanvas(int w, int h) {
		super(w, h);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		initx = e.getX();
		inity = e.getY();

	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (dragging == false)
			return;  // Nothing to do because the user isn't drawing.

			int x = e.getX();   // x-coordinate of mouse.
			int y = e.getY();   // y-coordinate of mouse.
			Graphics2D g = (Graphics2D) getGraphics();
			utils.scaleDraw(g, prevX, prevY, x, y, Color.BLACK, initx, inity);
			prevX = x;  // Get ready for the next line segment in the curve.
			prevY = y;
		
	}
}
