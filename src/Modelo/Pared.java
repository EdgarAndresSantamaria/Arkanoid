package Modelo;

public class Pared {
	private Ladrillo [][] tabladrillos;//matriz de ladrillos (pared)
	private final int Max_Fila=7;//constante m�ximo de filas
	private final int Max_Col=5;//constante m�ximo columnas
	
	
	public Pared(){
		//constructoras de pared 
		tabladrillos=new Ladrillo[Max_Fila][Max_Col];
		
		for(int i=0;i<Max_Fila;i++){
			for(int j=0;j<Max_Col;j++){
				Ladrillo actual=BrickFactory.getBrickFactory().createBrick();
				tabladrillos[i][j]=actual;
				
			}
			
		}
	}
	
	public int getTipo(int i , int j){
		return tabladrillos [i][j].getTipo();
	}
	
	public boolean golpear(int i , int j){
		//m�todo parra golpear el ladrillo especificado
		boolean destruido=tabladrillos [i][j].golpear();
		if(destruido){
			tabladrillos [i][j]=null;
		}
		return destruido;
	}
	
	public boolean destruida(){
		//m�todo que recorre la matriz entera para saber si todos los ladrillos han sido destruidos
		boolean destruida=true;
		int i=0,j=0;
		
		while(destruida && i<Max_Fila){
			while(destruida && j<Max_Col){
				destruida=tabladrillos[i][j]==null;

			}
				
		}
		return destruida;
	}
	
	public int filas(){
		return Max_Fila;
	}
	
	public int columnas(){
		return Max_Col;
	}
	
}
