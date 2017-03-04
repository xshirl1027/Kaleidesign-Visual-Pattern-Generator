import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.Random;

public class ChaosPattern extends Pattern {

	ChaosPattern(int w, int h) {
		// TODO Auto-generated constructor stub
		super(w,h);
		setBackground(Color.BLACK);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Graphics2D g = (Graphics2D) getGraphics();

		int size = (int)(Math.random()*20);
		for(int i=0; i<10; i++){	
			Color c = new Color( (int)(Math.random()*15+70), (int)(Math.random()*15+70), (int)(Math.random()*150+100));
			int xr = (int) (Math.random()*width);
			int yr = (int) (Math.random()*height);
			size = (int)(Math.random()*20);
			g.setColor(c);
			g.fillOval(xr, yr, size, size);
			//System.out.println((int)(Math.random()*width));
		}
		g.fillOval(x, y, size, size);
		g.dispose();


	}

}
