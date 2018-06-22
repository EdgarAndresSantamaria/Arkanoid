package Modelo;

public class BrickFactory {
	private static BrickFactory factoriaDelFlow;//�nica instancia de BrickFactory
	private final int Max=3;//rango m�ximo de tipos de ladrillo
	private final int Min=1;//rango minimo de tipos de ladrillo
	private int casualidad=1;
	
	private BrickFactory(){
		
	}
	
	public static BrickFactory getBrickFactory(){
		//patr�n singleton
		if(factoriaDelFlow==null){
			factoriaDelFlow=new BrickFactory();
		}
		return factoriaDelFlow;
	}
	public void modificarCasualidad(){
		if (casualidad==1){
			casualidad=2;
		}else{
			casualidad=1;
		}
	}
	
	public Ladrillo createBrick(){
		//funci�n capaz de generar ladrillos aleatorios entre los tipos disponibles
		int tipo=(int) (Math.floor(Math.random()*(Max-Min))+casualidad);
		//nos devuleve un entero acotado entre Min y max
		modificarCasualidad();
		Ladrillo miLadrillo=null;
		if(tipo==1){
			miLadrillo=new Ladrillo1();
		}else if(tipo==2){
			miLadrillo=new Ladrillo2();
		}else if(tipo==3){
			miLadrillo=new Ladrillo3();
		}
		//si se a�adieran m�s ladrillos reflejar aqu�
		return miLadrillo;
	}
}
