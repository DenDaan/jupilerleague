package voetbal;

import java.util.List;

import voetbal.speler.Speler;

public class Ploeg {
	private List<Speler> spelers;
	private List<Speler> exSpelers;
	private String naam;

	public static final Ploeg VRIJ = new Ploeg();

	// TODO:Lijst van spelers aanmaken --> ook ex-spelers, zodat per speler de
	// periode kan opgeroepen worden. De periode wordt bij de Speler bijgehouden
	// in een tabel [Ploeg,Periode]

	public Ploeg() {
		this(null,null,null);
	}

	public Ploeg(String naam) {
		this(naam,null,null);
	}
	
	public Ploeg(String naam, List<Speler> spelers, List<Speler> exSpelers){
		this.naam=naam;
		this.spelers=spelers;
		this.exSpelers=exSpelers;
	}

	public List<Speler> getSpelers() {
		return spelers;
	}

	public List<Speler> getExSpelers() {
		return exSpelers;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public void contracteer(Speler speler){
		//TODO: speler aannemen en ontslaan van ploeg of uit unemployed ploeg halen
	}
	
	public void ontsla(Speler speler){
		//TODO: speler ontslaan en in unemployed ploeg steken
	}

	public void transfer(Speler speler, Ploeg ploeg) {
		// TODO: transfer naar ploeg
	}
	
	@Override
	public String toString(){
		//TODO
		return naam;
	}
	
	@Override
	public int hashCode(){
		//TODO
		return naam.hashCode();
	}
	
	public int compareTo(Object o){
		if (o.getClass()==this.getClass()){
			return naam.compareTo(o.toString()); 
		}
		return -1;
	}
	
	@Override
	public boolean equals(Object o){
		return naam.equals(o);
	}
}
