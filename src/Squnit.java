
public class Squnit {
	private int localx;
	private int localy;
	private int size;
	
	public Squnit(int x, int y, int size){
		this.localx = x;
		this.localy = y;
		this.size = size;
	}
	public int[] getRangeX(){
		int[] tup = {this.localx, this.localx+size};
		return tup;
	}
	public int[] getRangeY(){
		int[]tup = {this.localy, this.localy+size};
		return tup;
	}
	//checks if coordinate (x,y) is inside this unit
	public boolean withinRange(int x, int y){
		if(x>this.localx & x>this.localx+size & y<this.localy & y<localy+size){
			return true;
		}else{
			return false;
		}
		
	}
}
