import javax.swing.*;


/**
 * A simple applet where the user can sketch curves in a variety of
 * colors.  A color palette is shown along the right edge of the applet.
 * The user can select a drawing color by clicking on a color in the
 * palette.  Under the colors is a "Clear button" that the user
 * can press to clear the sketch.  The user draws by clicking and
 * dragging in a large white area that occupies most of the applet.
 * The user's drawing is not persistent.  It is lost whenever
 * the applet is repainted for any reason.
 * <p>The drawing that is done in this example violates the rule
 * that all drawing should be done in the paintComponent() method.
 * Although it works, it is NOT good style.
 * <p>This class also contains a main program, and it can be run as
 * a stand-alone application that has exactly the same functionality
 * as the applet.
 */
public class Kaleidesign extends JApplet {
   
   /**
    * The main routine opens a window that displays a drawing area
    * and color palette.  This main routine allows this class to
    * be run as a stand-alone application as well as as an applet.
    * The main routine has nothing to do with the function of this
    * class as an applet.
    */
   public static void main(String[] args) {
      JFrame window = new JFrame("Simple Paint");
      drawComponent content = new drawComponent();
      window.setContentPane(content);
      window.setSize(1400,750);
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      window.setVisible(true);

   }
   
   /**
    * The init method of the applet simply creates a SimplePaintPanel and
    * uses it as the content pane of the applet.  All the work is done
    * by the SimplePaintPanel.
    */
   public void init() {
      setContentPane( new drawComponent() );
   }
   
   
   /**
    * A simple paint panel contains a large white drawing surface where
    * the user can draw curves and a color palette that the user can click
    * to select the color to be used for drawing.  When this class is used
    * as an applet, the content pane of the applet is a SimplePaintPanel.
    * When this class is run as a standalone application, the content pane
    * is a SimplePaintPanel.  All the real work is done in the
    * SimplePaintPanel class.
    */

} // end class SimplePaint