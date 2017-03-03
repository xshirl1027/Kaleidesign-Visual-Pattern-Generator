import javax.swing.*;


/**

 */
public class Kaleidesign extends JApplet {
   
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/**
    * The main routine opens a window that displays a drawing area
    * and color palette.  This main routine allows this class to
    * be run as a stand-alone application as well as as an applet.
    * The main routine has nothing to do with the function of this
    * class as an applet.
    */
   public static void main(String[] args) {
      JFrame window = new JFrame("Simple Paint");
      window.setSize(1400,750);
      //RadPattern content = new RadPattern(1400,750,12);
      //GridPattern content = new GridPattern(1400,750,200);
      BlankCanvas content = new BlankCanvas(1400,750);
      content.setPenSize(3);
      window.setContentPane(content);
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      window.setVisible(true);
   }
   
   /**
    * The init method of the applet simply creates a SimplePaintPanel and
    * uses it as the content pane of the applet.  All the work is done
    * by the SimplePaintPanel.
    */
   public void init() {
      //setContentPane( new RadPattern(1400,750,12) );
      //setContentPane( new GridPattern(1400,750,200) );
	  setContentPane( new BlankCanvas(1400,750) );
   }
   

} // end class SimplePaint