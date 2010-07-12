package voetbal.kaart;

import voetbal.Game;
import voetbal.speler.Speler;

public abstract class Kaart {
//TODO
	private Game game;
	private Speler speler;
	
	public Kaart(){};
	
	public Game getGame(){
		return game;
	}
	
	public Speler getSpeler(){
		return speler;
	}
}
