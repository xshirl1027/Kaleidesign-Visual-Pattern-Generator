import java.lang.Object;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JComponent;
/**
 * 
 */

/**
 * @author Shirley
 *
 */
public class main {

	/**
	 * @param args
	 */	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame();
		window.setSize(800, 700);
		window.setTitle("Kaleidesign");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		drawComponent dc = new drawComponent();
		window.add(dc);
		
	}


}
