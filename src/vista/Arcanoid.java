package vista;

import java.io.IOException;

import javax.swing.JFrame;


public class Arcanoid {
	
	private ventana window;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		boolean fin = false,correcto=false;
		while (!fin){
		
			Arcanoid juego=new Arcanoid();
			
			if(juego.jugar()){
				System.out.println("felicidades");
			}else{
				System.out.println("otra vez ser�");
			}
			
		while(!correcto){	
			System.out.println("otra?  pulse y/n ");
			char respuesta= (char) System.in.read();
			if (respuesta=='n'){
				fin=true;correcto=true;
			}else if (respuesta=='y'){
				correcto=true;
			}else{
				System.out.println("incorrecto pulse y o n");
			}
			
		}	
			
			
		}
		System.out.println("Hasta otra !!");
	}
	public boolean jugar(){
		return window.jugar();
	}

	public Arcanoid(){
		window=new ventana();
	}
}
