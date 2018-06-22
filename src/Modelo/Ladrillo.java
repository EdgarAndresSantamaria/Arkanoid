package Modelo;

public abstract class Ladrillo {
	//instancia superior de ladrillos ,todos los nuevos heredar�n de esta clase
	private int golpes;//vida del ladrillo
	private int tipo;
	
	public boolean golpear() {
		//esta funci�n simula que el bloque ha sido golpeado ,si se golpea tantas veces como puntos de vida tenga se destruir�
		golpes--;
		boolean destruido=false;//no se porque me obliga inicializar esta variable si por defecto el booleano es false
		if(golpes==0){
			destruido=true;
		}
		return destruido;
	}
	public void initialize(int Ngolpes){
		//m�todo de inicializaci�n de golpes
		golpes=Ngolpes;
		tipo=Ngolpes;
	}
	public int getTipo(){
		return tipo;
	}
	
		

}
