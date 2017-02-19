import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class drawComponent extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int w, scrx, scry;
	
	public void setparams(int w, int scrx, int scry){
		this.w = w;
		this.scrx = scrx;
		this.scry = scry;
	}
	public void paintComponent(Graphics g){
		Squnit[][] scrn = new Squnit[scrx/w][scry/w];
		Graphics2D g2 = (Graphics2D) g;
		Rectangle rec = new Rectangle(0,0,w,w);
		for (int j=0; j<(scry/w); j++){
			for(int i=0; i<(scrx/w);i++){
				scrn[i][j] = new Squnit(i*w, j*w, w);
				rec.setLocation(i*w, j*w);
				g2.draw(rec);
			}
		}
	}
}
