import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class drawComponent extends JPanel
implements MouseListener, MouseMotionListener {

/**
* Some constants to represent the color selected by the user.
*/
private final static int BLACK = 0;

private int currentColor = BLACK;  // The currently selected drawing color,
                          //   coded as one of the above constants.


/* The following variables are used when the user is sketching a
curve while dragging a mouse. */

private int prevX, prevY;     // The previous location of the mouse.

private boolean dragging;      // This is set to true while the user is drawing.

private Graphics graphicsForDrawing;  // A graphics context for the panel
                   // that is used to draw the user's curve.
private Squnit currUnit;

private static int w = 100;
private Squnit[][] scrn;

/**
* Constructor for SimplePaintPanel class sets the background color to be
* white and sets it to listen for mouse events on itself.
*/
drawComponent() {
setBackground(Color.WHITE);
addMouseListener(this);
addMouseMotionListener(this);
}


/**
* Draw the contents of the panel.  Since no information is
* saved about what the user has drawn, the user's drawing
* is erased whenever this routine is called.
*/
public void paintComponent(Graphics g) {

super.paintComponent(g);  // Fill with background color (white).

int width = getWidth();    // Width of the panel.
int height = getHeight();  // Height of the panel.

int colorSpacing = (height ) / 7;
// Distance between the top of one colored rectangle in the palette
// and the top of the rectangle below it.  The height of the
// rectangle will be colorSpacing - 3.  There are 7 colored rectangles,
// so the available space is divided by 7.  The available space allows
// for the gray border and the 50-by-50 CLEAR button.



/* Draw the "Clear button" as a 50-by-50 white rectangle in the lower right
corner of the applet, allowing for a 3-pixel border. */
int scrx = width;
int scry = height;

Graphics2D g2 = (Graphics2D) g;
graphicsForDrawing = g;
Rectangle rec = new Rectangle(0,0,w,w);
scrn = new Squnit[getHeight()/w+1][getWidth()/w+1];
for (int i=0; i<=(getHeight()/w); i++){
	for(int j=0; j<=(getWidth()/w);j++){
		scrn[i][j] = new Squnit(j*w, i*w, w);
		rec.setLocation(i*w, j*w);
		graphicsForDrawing.setColor(new Color(i*5,j*6, i*j*2));
		graphicsForDrawing.fillRect(scrn[i][j].getX(), scrn[i][j].getY(), w,w);
	}
}

} // end paintComponent()


/**
* Change the drawing color after the user has clicked the
* mouse on the color palette at a point with y-coordinate y.
* (Note that I can't just call repaint and redraw the whole
* panel, since that would erase the user's drawing!)
*/



/**
* This routine is called in mousePressed when the user clicks on the drawing area.
* It sets up the graphics context, graphicsForDrawing, to be used to draw the user's 
* sketch in the current color.
*/
private void setUpDrawingGraphics() {
graphicsForDrawing = getGraphics();
switch (currentColor) {
case BLACK:
graphicsForDrawing.setColor(Color.BLACK);
break;
}
} // end setUpDrawingGraphics()


/**
* This is called when the user presses the mouse anywhere in the applet.  
* There are three possible responses, depending on where the user clicked:  
* Change the current color, clear the drawing, or start drawing a curve.  
* (Or do nothing if user clicks on the border.)
*/
public void mousePressed(MouseEvent evt) {

int x = evt.getX();   // x-coordinate where the user clicked.
int y = evt.getY();   // y-coordinate where the user clicked.



int width = getWidth();    // Width of the panel.
int height = getHeight();  // Height of the panel.

for (int i = 0; i<=height/w; i++){
	for(int j = 0; j<=width/w; j++){
		if(scrn[i][j].withinRange(x, y)){
			currUnit = scrn[i][j];
			System.out.println(currUnit.getString());
			break;
		}
	}	
}

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
graphicsForDrawing.dispose();
graphicsForDrawing = null;
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



graphicsForDrawing.drawLine(prevX, prevY, x, y);  // Draw the line.
graphicsForDrawing.drawLine(prevX-1, prevY-1, x-1, y-1);  // Draw the line.
//graphicsForDrawing.fillOval(x, y, 2, 2); //create a layered effect
prevX = x;  // Get ready for the next line segment in the curve.
prevY = y;

} // end mouseDragged()


public void mouseEntered(MouseEvent evt) { }   // Some empty routines.
public void mouseExited(MouseEvent evt) { }    //    (Required by the MouseListener
public void mouseClicked(MouseEvent evt) { }   //    and MouseMotionListener
public void mouseMoved(MouseEvent evt) { }     //    interfaces).


}  // End class SimplePaintPanel

