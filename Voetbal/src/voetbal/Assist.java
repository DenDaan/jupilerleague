package voetbal;
public class Assist {

	private int minuut;
	private Speler assister;
	private Wedstrijd wedstrijd;
	
	public Assist(Wedstrijd wedstrijd, int minuut, Speler speler){
		assister=speler;
		this.minuut=minuut;
		this.wedstrijd=wedstrijd;
	}
	
	public int getMinuut(){
		return minuut;
	}
	
	public Speler getSpeler(){
		return assister;
	}
	
	public Wedstrijd getWedstrijd(){
		return wedstrijd;
	}
}
