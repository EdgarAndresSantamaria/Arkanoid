package vista;
import javax.swing.JFrame;

import Modelo.eventoTeclado;


public class ventana extends JFrame{
	public final int Ancho=800;
	public final int Alto=600;
	private tableroJuego lamina;//tablero del juego
	private eventoTeclado eventos=new eventoTeclado();
	
	public ventana(){
		setTitle("Arcanoid");//t�tulo del juego
		setSize(Ancho,Alto);//ventana con las medidas estandar
		setLocationRelativeTo(null);//centrar ventana
		setResizable(false);//evitamos que se redimensione la ventana
		lamina=new tableroJuego(Ancho,Alto);//inicializamos el tablero 
		add(lamina);//a�adimos el tablero
		addKeyListener(eventos);//a�adimos la clase encargada de recoger la interaccion con teclado
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public boolean jugar(){
		return lamina.iterarJuego();//podriamos omitir la clase hilo utilizando este otro m�todo como hilo de juego
	}
	
}
