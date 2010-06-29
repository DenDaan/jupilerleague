package voetbal;

public class Doelpunt {

	private int minuut;
	Manier manier;
	Speler spelerPunt;
	Speler spelerAssist;
	
	public Doelpunt(Speler spelerPunt, Speler spelerAssist, int minuut, Manier manier){
		this.spelerPunt=spelerPunt;
		this.spelerAssist=spelerAssist;
		this.minuut=minuut;
		this.manier=manier;
		
	}
}
