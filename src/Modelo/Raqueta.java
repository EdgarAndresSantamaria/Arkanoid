package Modelo;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;


public class Raqueta {
	private int x,y;
	private final int Ancho=100;
	private final int Alto=10;
	private  int dx=0;
	
	public Raqueta(int X,int Y){
		x=X;
		y=Y;
	}
	
	public Rectangle2D getRaqueta(){
		return new Rectangle2D.Double(x,y,Ancho,Alto);
	}
	
	public void mover(Rectangle limites){
		
		if(eventoTeclado.R && x<limites.getMaxX()-Ancho){
			dx=2;
			
		}
		if(eventoTeclado.L && x>limites.getMinX()){
			dx=-2;
		}
		x+=dx;
		dx=0;
		
	}
	
	
}
