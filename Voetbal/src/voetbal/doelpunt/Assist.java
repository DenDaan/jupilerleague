package voetbal.doelpunt;

import voetbal.Game;
import voetbal.speler.Speler;

public class Assist {

	private int minuut;
	private Speler assister;
	private Game wedstrijd;
	
	public Assist(Game wedstrijd, int minuut, Speler speler){
		assister=speler;
		this.minuut=minuut;
		this.wedstrijd=wedstrijd;
	}
	
	public Assist(Doelpunt doelpunt){
		assister=doelpunt.getSpelerAssist();
		minuut=doelpunt.getMinuut();
		wedstrijd=doelpunt.getGame();
	}
	
	public int getMinuut(){
		return minuut;
	}
	
	public Speler getSpeler(){
		return assister;
	}
	
	public Game getWedstrijd(){
		return wedstrijd;
	}
}
