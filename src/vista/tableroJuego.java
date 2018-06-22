package vista;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import Modelo.Pared;
import Modelo.Raqueta;
import Modelo.bloque;
import Modelo.pelota;


public class tableroJuego extends JPanel{
	private Pared pared;
	private pelota bola;
	private Raqueta raqueta;
	private ArrayList<bloque> tablabloques;
	
	public tableroJuego(int Width,int Height){
		setBackground(Color.BLACK);
		bola =new pelota(225,300);//posici�n inicial de la bola(0,0)
		raqueta=new Raqueta(225,550);//posiciinicial de la raqueta 
		pared=new Pared();//inicializar matriz de ladrillos
		int filas=pared.columnas();
		int columnas=pared.filas();
		tablabloques=new ArrayList<bloque>();
		int anchuraLadrillo=(Width/columnas)-(350/columnas);
		System.out.println(anchuraLadrillo);
		int alturaLadrillo=((Height/2 )/filas)-(250/filas);
		System.out.println(alturaLadrillo);
		int i=(350/columnas)/2,x=0;
		int j=(250/filas)/2,y=0;
		Color color = null;
		while(i<Width){
			while(j<Height/2){
				
				if(pared.getTipo(x, y)==1){
					color=Color.GREEN;
				}else if(pared.getTipo(x, y)==2){
					color=Color.blue;
				}else{
					color=Color.RED;
				}
				bloque temp=new bloque(i,j,	alturaLadrillo,anchuraLadrillo,x,y,color);
				tablabloques.add(temp);
				y++;
				j+=alturaLadrillo+(250/filas);
			}
			x++;
			y=0;
			j=(250/filas)/2;
			i+=anchuraLadrillo+(350/columnas);
		}
		
		
	}
	
	public boolean haGanado(){
		return pared.destruida();
	}
	
	public boolean haPerdido(){
		return bola.cotaInferior(getBounds());
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;//cambiamos al tipo Graphics2D que cuenta con m�s funcionalidad
		g2.setColor(Color.WHITE);//a�adir un color a la pelota
		dibujar(g2);//dibujar el frame actual
		actualizar();//actualizar el frame
		
	}
	
	public void dibujar(Graphics2D g){
		g.fill(bola.getPelota());//dibujar pelota en su posici�n actual
		g.fill(raqueta.getRaqueta());//dibujar la raqueta en la posici�n actual
		for(int i=0;i<tablabloques.size();i++){
			g.setColor(tablabloques.get(i).getColor());
			g.fill(tablabloques.get(i).getBloque());
		}
		
		
	}
	
	public void actualizar(){	
		
		bola.mover(getBounds(),colisionR(),colisionM());//mover la bola actualizar ejes x e y
		raqueta.mover(getBounds());//actualiza la raqueta
		
	}
	
	private boolean colisionR(){
		return bola.getPelota().intersects(raqueta.getRaqueta());
	}
	
	private bloque colisionM(){
		boolean colision=false;
		int i=0;
		bloque colisionado=null;
		
		while(i<tablabloques.size() && !colision){
			colision=bola.getPelota().intersects(tablabloques.get(i).getBloque());
			if(colision){
				boolean destruido=pared.golpear(tablabloques.get(i).x(), tablabloques.get(i).y());
				if (destruido){
						colisionado=tablabloques.get(i);
						tablabloques.remove(i);
				}else{
					    colisionado=tablabloques.get(i);
				}
			}
			i++;
		}
		
		return colisionado;
	}
	
	public boolean iterarJuego(){
		boolean fin=false;
		boolean ganado = false;
		while (!fin){
			try {
				Thread.sleep(10);//esperar 10 ms al refresco
				repaint();//refrescar tablero
			}catch(InterruptedException e){
				//si crashea...
			}
		if (haGanado())	{
			ganado=true;
			fin=true;
		}else if(haPerdido()){
			ganado=false;
			fin=true;
		}
			
			
		}
		
		return ganado;
	}	
	
}
