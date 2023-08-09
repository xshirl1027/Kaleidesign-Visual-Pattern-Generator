import javax.swing.*;
import java.awt.event.*;
/**

 */
public class Kaleidesign extends JPanel implements ActionListener {
   
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   // menubar
   static JMenuBar mb;

   // JMenu
   static JMenu new_, pen_c, background_c, pen_style;

   // Menu items
   static JMenuItem m1, m2, m3;

   // create a frame
   static JFrame f;

   static JLabel l;

/**
    * The main routine opens a window that displays a drawing area
    * and color palette.  This main routine allows this class to
    * be run as a stand-alone application as well as as an applet.
    * The main routine has nothing to do with the function of this
    * class as an applet.
    */
   public static void main(String[] args) {
      JFrame window = new JFrame("Simple Paint");
      l = new JLabel("no pattern selected");
      Kaleidesign m = new Kaleidesign();
      // create a menubar
      mb = new JMenuBar();

      // create a menu
      new_ = new JMenu("New");
      pen_c = new JMenu("Pen Color");
      pen_style = new JMenu("Pen Style");
      background_c = new JMenu("Background Color");

      // create menuitems
      m1 = new JMenuItem("Grid Patterns");
      m2 = new JMenuItem("Basic Pattern");
      m3 = new JMenuItem("Chaos Pattern");

      // add ActionListener to menuItems
      m1.addActionListener(m);
      m2.addActionListener(m);
      m3.addActionListener(m);

      // add menu items to menu
      new_.add(m1);
      new_.add(m2);
      new_.add(m3);

      // add menu to menu bar
      mb.add(new_);
      mb.add(pen_c);
      mb.add(background_c);
      mb.add(pen_style);
      mb.add(l);
      window.setJMenuBar(mb);
      window.setSize(1400,750);

      RadPattern content = new RadPattern(1400,750,12);
      //GridPattern content = new GridPattern(1400,750,200);
      //BlankCanvas content = new BlankCanvas(1400,750);
      //Pattern content = new Pattern(1400, 750);
      content.setPenSize(3);
      window.setContentPane(content);
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      window.setVisible(true);
   }
   public void actionPerformed(ActionEvent e)
   {
      String s = e.getActionCommand();

      // set the label to the menuItem that is selected
      l.setText(s + " selected");
   }
   /**
    * The init method of the applet simply creates a SimplePaintPanel and
    * uses it as the content pane of the applet.  All the work is done
    * by the SimplePaintPanel.
    */
   public void init() {
    //setContentPane( new RadPattern(1400,750,12) );
    //setContentPane( new GridPattern(1400,750,200) );
	  //setContentPane( new BlankCanvas(1400,750) );
	  //setContentPane( new Pattern(1400,750) );
   }
   

} // end class SimplePaint