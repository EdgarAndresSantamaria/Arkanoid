package Modelo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class eventoTeclado extends KeyAdapter{
	
	public static boolean L,R;
	
	
	public void keyPressed(KeyEvent e){
		int id=e.getKeyCode();
		
		if(id==KeyEvent.VK_A ||id==KeyEvent.VK_LEFT ){
			L=true;
		}else if(id==KeyEvent.VK_D ||id==KeyEvent.VK_RIGHT){
			R=true;
		}
		
	}
	
	public void keyReleased(KeyEvent e){

		int id=e.getKeyCode();
		
		if(id==KeyEvent.VK_A ||id==KeyEvent.VK_LEFT ){
			L=false;
		}else if(id==KeyEvent.VK_D ||id==KeyEvent.VK_RIGHT){
			R=false;
		}
		
	}

}
