import java.lang.Object;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JComponent;
/**
 * @author Shirley
 *
 */
public class KaleidesignRetired extends JComponent implements ActionListener, MouseListener, MouseMotionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6659877493317654360L;
	private static int w;
	private static int scrx;
	private static int scry;
	private static int mousex;
	private static int mousey;
	private static Graphics graphicsForDrawing;
	/**
	 * @param args
	 */	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		mousex=0;
		mousey=0;
		w = 100;
		scrx = 1400;
		scry = 750;
		JFrame window = new JFrame("Kaleidesign");
		KaleidesignRetired k = new KaleidesignRetired();
		window.add(k);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		//drawComponent dc = new drawComponent();
		//setparams(100, 1400, 750);
		Timer t = new Timer(100, k);
		t.start();
		window.addMouseListener(k);
		window.addMouseMotionListener(k);
	}
	public Dimension getPreferredSize(){
		return new Dimension(scrx, scry);
	}
	@Override
	protected void paintComponent(Graphics g){
		Squnit[][] scrn = new Squnit[scrx/w][scry/w];
		Graphics2D g2 = (Graphics2D) g;
		graphicsForDrawing = g;
		Rectangle rec = new Rectangle(0,0,w,w);
		for (int j=0; j<(scry/w); j++){
			for(int i=0; i<(scrx/w);i++){
				scrn[i][j] = new Squnit(i*w, j*w, w);
				rec.setLocation(i*w, j*w);
				graphicsForDrawing.setColor(new Color(50+i*5,j*6, i*j*2));
				graphicsForDrawing.fillRect(scrn[i][j].getX(), scrn[i][j].getY(), w,w);
			}
		}
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mousex = getMousePosition().x;
		mousey = getMousePosition().y;
		graphicsForDrawing = getGraphics();
		graphicsForDrawing.setColor(new Color(0,0,0));
		graphicsForDrawing.drawLine(e.getY(), e.getX(), mousex, mousey);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mousex = getMousePosition().x;
		mousey = getMousePosition().y;
		graphicsForDrawing = getGraphics();
		graphicsForDrawing.setColor(new Color(0,0,0));
		graphicsForDrawing.drawLine(e.getY(), e.getX(), mousex, mousey);
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
