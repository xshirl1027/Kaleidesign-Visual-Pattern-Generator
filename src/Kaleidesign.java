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
   static JMenuItem m1, m2, m3, m4;

   // create a frame
   static JFrame f;

   static JLabel l;

   static Pattern content;
   static JFrame window;

/**
    * The main routine opens a window that displays a drawing area
    * and color palette.  This main routine allows this class to
    * be run as a stand-alone application as well as as an applet.
    * The main routine has nothing to do with the function of this
    * class as an applet.
    */
   public static void main(String[] args) {
      window = new JFrame("Simple Paint");
      l = new JLabel("basic pattern");
      Kaleidesign m = new Kaleidesign();
      // create a menubar
      mb = new JMenuBar();

      // create a menu
      new_ = new JMenu("New");
      pen_c = new JMenu("Pen Color");
      pen_style = new JMenu("Pen Style");
      background_c = new JMenu("Background Color");

      // create menuitems
      m1 = new JMenuItem("Grid Pattern");
      m2 = new JMenuItem("Basic Pattern");
      m3 = new JMenuItem("Chaos Pattern");
      m4 = new JMenuItem("Blank Canvas");

      // add ActionListener to menuItems
      m1.addActionListener(m);
      m2.addActionListener(m);
      m3.addActionListener(m);
      m4.addActionListener(m);

      // add menu items to menu
      new_.add(m1);
      new_.add(m2);
      new_.add(m3);
      new_.add(m4);

      // add menu to menu bar
      mb.add(new_);
      mb.add(pen_c);
      mb.add(background_c);
      mb.add(pen_style);
      mb.add(l);
      window.setJMenuBar(mb);
      window.setSize(1400,750);

      //RadPattern content = new RadPattern(1400,750,12);
      content = new RadPattern(1400,750,12);
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
      l.setText(s);
      //RadPattern content = new RadPattern(1400,750,12);
      if(s=="Grid Pattern") content = new GridPattern(1400,750,200);
      if(s=="Basic Pattern") content = new RadPattern(1400,750,12);
      if(s=="Chaos Pattern") content = new ChaosPattern(1400,750);
      if(s=="Blank Canvas") content = new Pattern(1400,750);
      //BlankCanvas content = new BlankCanvas(1400,750);
      //Pattern content = new Pattern(1400, 750);
      content.setPenSize(3);
      window.setContentPane(content);
   }

}