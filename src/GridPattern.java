import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class GridPattern extends Pattern {

private boolean dragging;      // This is set to true while the user is drawing.
private Squnit currUnit;
private static int grid = 100;
private Squnit[][] scrn;

public GridPattern(int w, int h) {
	super(w, h);
	// TODO Auto-generated constructor stub
}
/**
* Draw the contents of the panel.  Since no information is
* saved about what the user has drawn, the user's drawing
* is erased whenever this routine is called.
*/
public void paintComponent(Graphics g) {

	super.paintComponent(g);  // Fill with background color (white).
	
	graphicsForDrawing = (Graphics2D) g;
	Rectangle rec = new Rectangle(0,0,grid,grid);
	scrn = new Squnit[getHeight()/grid+1][getWidth()/grid+1];
	for (int i=0; i<=(getHeight()/grid); i++){
		for(int j=0; j<=(getWidth()/grid);j++){
			scrn[i][j] = new Squnit(j*grid, i*grid, grid);
			rec.setLocation(i*grid, j*grid);
			graphicsForDrawing.setColor(new Color(i*5,j*6, i*j*2));
			graphicsForDrawing.fillRect(scrn[i][j].getX(), scrn[i][j].getY(), grid,grid);
		}
	}
	setUpDrawingGraphics(pen_size);
} // end paintComponent()

/**
* Change the drawing color after the user has clicked the
* mouse on the color palette at a point with y-coordinate y.
* (Note that I can't just call repaint and redraw the whole
* panel, since that would erase the user's drawing!)
*/

public void getSqunitAtMouse(int height, int width, int x, int y){
	for (int i = 0; i<height/grid; i++){
		for(int j = 0; j<width/grid; j++){
			if(scrn[i][j].withinRange(x, y)){
				currUnit = scrn[i][j];
				System.out.println(currUnit.getString());
				break;
			}
		}	
	}
}

/**
* This is called when the user presses the mouse anywhere in the applet.  
* There are three possible responses, depending on where the user clicked:  
* Change the current color, clear the drawing, or start drawing a curve.  
* (Or do nothing if user clicks on the border.)
*/
public void mousePressed(MouseEvent evt) {

	int x = evt.getX();   // x-coordinate where the user clicked.
	int y = evt.getY();   // y-coordinate where the user clicked.
	
	
	getSqunitAtMouse(height,width, x ,y);
	
	if (dragging == true)  // Ignore mouse presses that occur
	return;            //    when user is already drawing a curve.
	else {
		prevX = x;
		prevY = y;
		dragging = true;
	}

} // end mousePressed()


/**
* Called whenever the user releases the mouse button. If the user was drawing 
* a curve, the curve is done, so we should set drawing to false and get rid of
* the graphics context that we created to use during the drawing.
*/
public void mouseReleased(MouseEvent evt) {
	if (dragging == false)
	return;  // Nothing to do because the user isn't drawing.
	dragging = false;
}

private void drawAll(int x, int y, int prevX, int prevY){
	graphicsForDrawing = (Graphics2D) getGraphics();
	int incX = currUnit.getTransformedX(x);
	int incY = currUnit.getTransformedY(y);
	int incprevX = currUnit.getTransformedX(prevX);
	int incprevY = currUnit.getTransformedY(prevY);
	for (int i=0; i<height/grid; i++){
		for (int j=0; j<width/grid; j++){
			graphicsForDrawing.drawLine(scrn[i][j].getX()+incX, scrn[i][j].getY()+incY, scrn[i][j].getX()+incprevX, scrn[i][j].getY()+incprevY);
		}
	}
	graphicsForDrawing.dispose();
}

/**
* Called whenever the user moves the mouse while a mouse button is held down.  
* If the user is drawing, draw a line segment from the previous mouse location 
* to the current mouse location, and set up prevX and prevY for the next call.  
* Note that in case the user drags outside of the drawing area, the values of
* x and y are "clamped" to lie within this area.  This avoids drawing on the color 
* palette or clear button.
*/
public void mouseDragged(MouseEvent evt) {

	if (dragging == false)
	return;  // Nothing to do because the user isn't drawing.
	
	int x = evt.getX();   // x-coordinate of mouse.
	int y = evt.getY();   // y-coordinate of mouse.
	
	getSqunitAtMouse(getHeight(),getWidth(), x ,y);
	drawAll(x,y, prevX, prevY);
	  // Draw the line.
	//graphicsForDrawing.fillOval(x, y, 2, 2); //create a layered effect
	prevX = x;  // Get ready for the next line segment in the curve.
	prevY = y;

} // end mouseDragged()
public void mouseEntered(MouseEvent evt) { }   // Some empty routines.
public void mouseExited(MouseEvent evt) { }    //    (Required by the MouseListener
public void mouseClicked(MouseEvent evt) { }   //    and MouseMotionListener
public void mouseMoved(MouseEvent evt) { }     //    interfaces).
}  // End class SimplePaintPanel

