package voetbal;

import java.util.Date;

public class Speler {
	
	private String voornaam;
	private String naam;
	private String nationaliteit;
	private Date geboortejaar;
	
	private Ploeg ploeg;
	private Doelpunt[] doelpunten;
	private Assist[] assisten;
	
	public Kaart[] kaarten;
	public boolean geschorst = false;
	
	public void addAssist(Assist assist){
		//Todo
	}
	
}
