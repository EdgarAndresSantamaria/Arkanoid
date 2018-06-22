package Modelo;
import java.awt.Color;
import java.awt.geom.Rectangle2D;


public class bloque {
	private int x;
	private int y;
	private int idx;
	private int idy;
	private int Alto;
	private int Ancho;
	private Color color;
	
	public bloque (int X,int Y,int alto,int ancho,int ix ,int iy, Color g){
		x=X;
		y=Y;
		Alto=alto;
		Ancho=ancho;
		idx=ix;
		idy=iy;
		color=g;
	}
	
	public Rectangle2D getBloque(){
		return new Rectangle2D.Double(x,y,Ancho,Alto);
	}
	
	public int getMaxX(){
		return x+Ancho;
	}
	
	public int getMaxY(){
		return y+Alto;
	}
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int y(){
		return idy;
	}
	
	public int x(){
		return idx;
	}
	public  Color getColor(){
		return color;
	}
	
}
