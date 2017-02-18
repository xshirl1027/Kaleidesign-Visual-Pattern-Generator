import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class drawComponent extends JComponent{
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Rectangle rec = new Rectangle(10,10,200,200);
		g2.draw(rec);
		rec.setLocation(getMousePosition());
		g2.draw(rec);

	}
}
