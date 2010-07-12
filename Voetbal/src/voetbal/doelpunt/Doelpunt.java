package voetbal.doelpunt;

import voetbal.Game;
import voetbal.doelpunt.util.Manier;
import voetbal.speler.Speler;

public class Doelpunt {

	private int minuut;
	private Manier manier;
	private Speler spelerPunt;
	private Speler spelerAssist;
	private Game match;
	
	public Doelpunt(Speler spelerPunt, Speler spelerAssist, int minuut, Manier manier){
		this.spelerPunt=spelerPunt;		
		this.spelerAssist=spelerAssist;
		this.minuut=minuut;
		this.manier=manier;
	}
	
	public Doelpunt(Speler scorer, Speler assister, int minuut, Game match, Manier manier) {
		this.spelerPunt=spelerPunt;		
		this.spelerAssist=spelerAssist;
		this.minuut=minuut;
		this.manier=manier;
		this.match=match;
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

	public Game getGame() {
		return match;
	}
}
