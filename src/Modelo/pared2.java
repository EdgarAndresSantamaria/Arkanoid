package Modelo;

public class pared2 {
	private Ladrillo[] pared;
	private int Max=10;
	
	public pared2(){
		pared=new Ladrillo[Max];
		for(int i=0;i<pared.length;i++){
			Ladrillo actual=BrickFactory.getBrickFactory().createBrick();
			pared[i]=actual;
		}
	}
}
