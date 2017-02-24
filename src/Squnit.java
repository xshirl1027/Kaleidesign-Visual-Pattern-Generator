import java.awt.Point;

public class Squnit {
	private int localx;
	private int localy;
	private int size;
	
	public Squnit(int x, int y, int size){
		this.localx = x;
		this.localy = y;
		this.size = size;
	}
	public int getX(){
		return this.localx;
	}
	public int getY(){
		return this.localy;
	}
	public Point getCenter(){
		Point center = new Point();
		center.x = this.localx+size/2;
		center.y = this.localy+size/2;
		return center;
		
	}
	public int getTransformedX(int x){
		return x-localx;
	}
	public int getTransformedY(int y){
		return y-localy;
	}
	//checks if coordinate (x,y) is inside this unit
	public boolean withinRange(int x, int y){
		
		if(x>this.localx & x<this.localx+size & y>this.localy & y<localy+size){
			return true;
		}else{
			return false;
		}
		
	}
	
	public String getString(){
		String ret = "Localx: "+this.localx+" Locay:"+this.localy;
		return ret;
		
	}
}
