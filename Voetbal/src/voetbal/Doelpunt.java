package voetbal;

public class Doelpunt {

	private int minuut;
	private Manier manier;
	private Speler spelerPunt;
	private Speler spelerAssist;
	
	public Doelpunt(Speler spelerPunt, Speler spelerAssist, int minuut, Manier manier){
		this.spelerPunt=spelerPunt;		
		this.spelerAssist=spelerAssist;
		this.minuut=minuut;
		this.manier=manier;
	}
	
	public int getMinuut(){
		return minuut;
	}
	
	public Manier getManier(){
		return manier;
	}
	
	public Speler getSpelerPunt(){
		return spelerPunt;
	}
	
	public Speler getSpelerAssist(){
		return spelerAssist;
	}
}
