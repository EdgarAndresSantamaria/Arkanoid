package Modelo;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;


public class pelota {
	private int x;
	private int y;
	private final int Ancho=10;
	private final int Alto=10;	
	private  int dx=1;
	private  int dy=-1;
	
	public pelota(int X ,int Y){
		x=X;
		y=Y;
	}
	
	public Rectangle2D getPelota(){
		return new Rectangle2D.Double(x,y,Ancho,Alto);
	}
	
	public void mover(Rectangle limites,boolean colisionR,bloque colisionM){
		//m�todo que mueve la bola
		
		if( x<limites.getMinX()){
			x=(int)limites.getMinX()+10;
			dx=-dx;
		}
		
		if(x>limites.getMaxX()-Ancho ){
			x=(int)limites.getMaxX()-10;
			dx=-dx;
		}
		if(y>limites.getMaxY()){
			y=(int)limites.getMaxY()-10;
			dy=-dy;
		}
		
		if(y<limites.getMinY()){
			y=(int)limites.getMinY()+10;
			dy=-dy;
		}
		
		if(colisionR){
			y=525;
			if(Math.abs(dy)<10){
			dy++;
			}
			dy=-dy;
		}
		
		if(colisionM!=null){
			int withMin=colisionM.getX();
			int heighMin=colisionM.getY();
			int withMax=colisionM.getMaxX();
			int heighMax=colisionM.getMaxY();
			
			if(  x-dx<=withMin && heighMin<y-dy && y-dy<heighMax ){
				dx=-dx;
				x=withMin-25;
			}
			
			if(   x-dx>=withMax && heighMin<y-dy && y-dy<heighMax){
				dx=-dx;
				x=withMax+25;
			}
			
			if(	 y-dy<=heighMin && withMin<x-dx && x-dx<withMax){
				dy=-dy;
				y=heighMin-25;
			}
			
			if(  y-dy>=heighMax && withMin<x-dx && x-dx<withMax){
				dy=-dy;
				y=heighMax+25;
			}
		}
		x+=dx;//mover eje x
		y+=dy;//mover eje y
		
	}
	public boolean cotaInferior(Rectangle limites){
		return y>limites.getMaxY();
	}
}
