package voetbal;
public class Assist {

	private int minuut;
	private Speler assister;
	private Match match;
	
	public Assist(Match match, int minuut, Speler speler){
		assister=speler;
		this.minuut=minuut;
		this.match=match;
	}
}
